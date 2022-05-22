package quanlycuahang.controller.shop;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.entity.ClientAccount;
import quanlycuahang.entity.Bill;
import quanlycuahang.entity.Client;
import quanlycuahang.entity.ProductType;

@Transactional
@Controller
@RequestMapping("admin/donhang/")
public class QL_DonHangController {

	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index(ModelMap model) {

		List<Bill> Bill = this.getBill();

		model.addAttribute("Bill", Bill);
		return "shop/QL_DonHang";
	}

	public Bill getBill(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Bill list = (Bill) query.list().get(0);
		return list;
	}
	
	public List<Bill> getBill() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill";
		Query query = session.createQuery(hql);
		List<Bill> list = query.list();
		return list;
	}

	public List<Bill> searchBill(String maBill) {
		int maBillInt;
		Session session = factory.getCurrentSession();
		String hql;
		if (maBill == "") {
			hql = "FROM Bill";
			Query query = session.createQuery(hql);
			List<Bill> list = query.list();
			return list;
		} else {
			maBillInt = Integer.parseInt(maBill);
			hql = "FROM Bill where id = :maBill";
			Query query = session.createQuery(hql);
			query.setParameter("maBill", maBillInt);
			List<Bill> list = query.list();
			return list;
		}

		
	}

	@RequestMapping(value = "index", params = "btnsearch")
	public String search(HttpServletRequest request, ModelMap model) {

		List<Bill> Bill;
		Bill = this.searchBill(request.getParameter("searchInput"));
		model.addAttribute("Bill", Bill);
		return "shop/QL_DonHang";

	}
	
	public int updateConfirm(Bill bill) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(bill);
			t.commit();
		} catch (Exception ex) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	@RequestMapping(value = "index/{id}.htm", params = "btnConfirm")
	public String confirm(ModelMap model,
			//@ModelAttribute("Bill") Bill Bill,
			@PathVariable("id") int id) {
		Bill tempBill = this.getBill(id);
		tempBill.setStatus('Y');
		int temp = this.updateConfirm(tempBill);
		List<Bill> Bill = this.getBill();
		model.addAttribute("Bill", Bill);
		model.addAttribute("message", "Bắc đẹp trai");
		return "shop/QL_DonHang";
	}
	@RequestMapping(value = "index/{id}.htm", params = "btnView")
	public String view(ModelMap model,
			//@ModelAttribute("Bill") Bill Bill,
			@PathVariable("id") int id) {
		List<Bill> Bill = this.getBill();
		model.addAttribute("Bill", Bill);
		return "shop/QL_DonHang";
	}

}
