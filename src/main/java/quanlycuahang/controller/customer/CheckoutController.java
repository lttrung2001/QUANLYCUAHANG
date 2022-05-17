package quanlycuahang.controller.customer;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.entity.ClientAccount;

@Controller
public class CheckoutController {
	
	@RequestMapping(value = "checkout")
	public String checkout(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		ClientAccount account = (ClientAccount) session.getAttribute("account");
		model.addAttribute("cart", account.getProducts());
		return "customer/cart";
	}
}
