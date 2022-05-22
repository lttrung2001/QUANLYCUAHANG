package quanlycuahang.controller.customer;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.dao.shop.QLBillDAO;
import quanlycuahang.entity.Bill;
import quanlycuahang.entity.BillDetail;
import quanlycuahang.entity.ClientAccount;
import quanlycuahang.entity.Product;

@Controller
@Transactional
@RequestMapping(value = "account")
public class HistoryController {
	@Autowired
	private SessionFactory factory;
	
	@Autowired
	private QLBillDAO billDAO;
	@RequestMapping("history")
	public String history(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		String username = ((ClientAccount)session.getAttribute("account")).getUsername();
		List<Bill> list = new ArrayList<Bill>();
		billDAO.getAllBill().forEach(b-> {
			if (b.getCustomerAcc().getUsername().equals(username)) {
				list.add(b);
			}
		});
		model.addAttribute("bills", list);
		return "customer/bill";
	}
	
	@RequestMapping(value = "bill-detail-{id}")
	public String billDetailOfUser(ModelMap model, @PathVariable("id") int id) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from Bill where id = :id");
		query.setParameter("id", id);
		model.addAttribute("bill", query.list().get(0));
		return "customer/bill-detail";
	}
	
	@RequestMapping(value = "bill-{id}")
	public String cancelBill (HttpServletRequest request, ModelMap model, @PathVariable("id") int id) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Bill where id = :id");
		query.setParameter("id", id);
		Bill bill = (Bill) query.list().get(0);
		if (bill.getStatus() == 'N') {
			bill.setStatus('H');
			Product p = null;
			Query query2 = session.createQuery("from Product where id = :id");
			try {
				for (BillDetail bd : bill.getBillDetails()) {
					query2.setParameter("id", bd.getProductInBill().getId());
					p = (Product) query2.list().get(0);
					p.setQttInStock(p.getQttInStock()+bd.getAmount());
					session.update(p);
				}
				session.save(bill);
				t.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				t.rollback();
			} finally {
				session.close();
			}
		}
		HttpSession session1 = request.getSession();
		String username = ((ClientAccount)session1.getAttribute("account")).getUsername();
		List<Bill> list = new ArrayList<Bill>();
		billDAO.getAllBill().forEach(b-> {
			if (b.getCustomerAcc().getUsername().equals(username)) {
				list.add(b);
			}
		});
		model.addAttribute("bills", list);
		return "customer/bill";
	}
}
