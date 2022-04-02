package quanlycuahang.controller;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import quanlycuahang.entity.Bill;
import quanlycuahang.entity.BillDetail;
import quanlycuahang.entity.Staff;

@Controller
@Transactional
public class TestController {
	@Autowired
	private SessionFactory factory;
	
	@RequestMapping(value = "test")
	@ResponseBody
	public String test() {
		Query query = factory.getCurrentSession().createQuery("from Staff where id = 106");
		Staff trung = (Staff) query.list().get(0);
		String result = "";
		result += "<h1>Danh sach hoa don do nhan vien 106 tao</h1>";
		for (Bill bill : trung.getCreatedBills()) {
			result += "<h3>Hoa don: "+bill.getId()+"</h3>";
			result += "<p>Ngay tao: "+bill.getCreateDate()+"</p>";
			result += "<p>Ho ten nhan vien: "
					+bill.getStaffCreate().getLastName()
					+" "+bill.getStaffCreate().getFirstName()+"</p>";
			result += "<p>Trang thai: "+bill.getStatus()+"</p>";
			result += "<p>Dia chi giao hang: "+bill.getAddress()+"</p>";
			result += "<ul>";
			for (BillDetail billDetail : bill.getBillDetails()) {
				result += "<li>"+billDetail.getProductInBill().getName()
						+"_So luong: "+billDetail.getAmount()
						+"_Gia: "+billDetail.getProductInBill().getPrice()
						+"</li>";
			}
			result += "</ul>";
		}
		return result;
	}
}
