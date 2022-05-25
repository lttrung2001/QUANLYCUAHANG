package quanlycuahang.controller.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
import quanlycuahang.entity.Product;
import quanlycuahang.entity.Bill;
import quanlycuahang.entity.BillDetail;
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
		model.addAttribute("b", Bill.get(1));
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
	
	
	
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping(value = "index/{id}.htm", params = "btnConfirm")
	public String confirm(ModelMap model,
			//@ModelAttribute("Bill") Bill Bill,
			@PathVariable("id") int id) {
		Bill tempBill = this.getBill(id);
		tempBill.setStatus('Y');
		model.addAttribute("b", tempBill);
		int temp = this.updateConfirm(tempBill);
		List<Bill> Bill = this.getBill();
		model.addAttribute("Bill", Bill);
		model.addAttribute("message", "");
		
		
		Set<BillDetail> getBillDetail=tempBill.getBillDetails();
		String listProduct="";
		Double total=0.0;
		for(BillDetail item: getBillDetail){
			Product product=item.getProductInBill();
			total+=item.getAmount()*product.getPrice();
			listProduct+=Integer.toString(item.getAmount())+" "+ product.getName()+", đơn giá "+Double.toString(product.getPrice())+"00VND \n";
		}
		listProduct+="Tổng đơn hàng của bạn là: "+ Double.toString(total)+"00VND";
		ClientAccount client= tempBill.getCustomerAcc();
		String email= client.getEmail();
		model.addAttribute("client",client.getUsername());
		
		try {
			MimeMessage mail= mailSender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(mail, true);
			
			helper.setFrom("no-reply-email");
			helper.setTo(email);
			helper.setSubject("ĐƠN HÀNG CÓ MÃ " +Integer.toString(id)+ " ĐÃ ĐƯỢC XÁC NHẬN! ");
			helper.setText("Chào "+client.getUsername()+ ", Chi tiết đơn hàng gồm: \n"+listProduct +"\n CẢM ƠN BẠN ĐÃ CHỌN SẢN PHẨM TẠI SHOP.\n HẸN GẶP LẠI!");
			mailSender.send(mail);	
			model.addAttribute("message","Gửi mail thành công!");
		}
		catch(Exception e) {
			model.addAttribute("message","Gửi mail thất bại!");
		}
		
		
		return "shop/QL_DonHang";
	}
	@RequestMapping(value = "index/{id}.htm", params = "btnView")
	public String view(ModelMap model,
			@PathVariable("id") int id) {
		List<Bill> Bill = this.getBill();
		model.addAttribute("Bill", Bill);
		model.addAttribute("b", this.getBill(id));
//		Bill tempBill = this.getBill(id);
//		ClientAccount client= tempBill.getCustomerAcc();
//		model.addAttribute("client",client.getUsername());
		
		return "shop/QL_DonHang";
	}

}
