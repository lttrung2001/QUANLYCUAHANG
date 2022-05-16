package quanlycuahang.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	private quanlycuahang.dao.shop.QLSanPhamDAO productDAO;
	
	@RequestMapping(value = "home")
	public String home(ModelMap model) {
		model.addAttribute("products", productDAO.getAllProduct());
		return "customer/customer_home";
	}
}
