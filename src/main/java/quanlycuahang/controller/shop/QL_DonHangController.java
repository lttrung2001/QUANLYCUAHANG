package quanlycuahang.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.entity.Bill;
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
		/* model.addAttribute("btnStatus", "btnAdd"); */
		model.addAttribute("Bill", Bill);
		return "shop/QL_DonHang";
	}

	public List<Bill> getBill() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill";
		Query query = session.createQuery(hql);
		List<Bill> list = query.list();
		return list;
	}

	public List<Bill> searchBill(int maBill) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill where id = :maBill";
		Query query = session.createQuery(hql);
		query.setParameter("maBill", maBill);
		List<Bill> list = query.list();
		return list;
	}

	@RequestMapping(value = "index", params = "btnsearch")
	public String search(HttpServletRequest request, ModelMap model){
		List<Bill> Bill = this.searchBill(Integer.parseInt(request.getParameter("searchInput")));
		model.addAttribute("Bill", Bill);
		
		return "shop/QL_DonHang";
	}

}
