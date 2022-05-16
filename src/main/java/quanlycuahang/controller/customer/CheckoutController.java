package quanlycuahang.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.dao.customer.ClientAccountDAO;
import quanlycuahang.entity.ClientAccount;

@Controller
public class CheckoutController {
	// Test
	@Autowired
	private ClientAccountDAO dao;
	
	@RequestMapping(value = "checkout")
	public String checkout(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		session.setAttribute("account", dao.getClientAccountById(1));
		ClientAccount account = (ClientAccount) session.getAttribute("account");
		model.addAttribute("cart", account.getProducts());
		return "customer/cart";
	}
}
