package quanlycuahang.controller.customer;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlycuahang.dao.customer.ClientAccountDAO;
import quanlycuahang.dao.customer.PartDAO;
import quanlycuahang.dao.shop.QLSanPhamDAO;
import quanlycuahang.entity.ClientAccount;

@Controller
public class LoginController {
	@Autowired
	private ClientAccountDAO clientAccountDAO;
	@Autowired
	private QLSanPhamDAO productDAO;
	@Autowired
	private PartDAO partDAO;
	
	@RequestMapping(value = "login")
	public String login(ModelMap model) {
		model.addAttribute("account", new ClientAccount());
		return "customer/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(ModelMap model,
						HttpServletRequest request,
						@Validated @ModelAttribute("account") ClientAccount account,
						BindingResult errors) {
		model.addAttribute("part", "home");
		model.addAttribute("products", productDAO.getAllProduct());
		model.addAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		model.addAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		if (errors.hasFieldErrors("username") || errors.hasFieldErrors("password")) {
			model.addAttribute("account", account);
			return "customer/login";
		}
		else {
			ClientAccount accountInTable = clientAccountDAO.getClientAccountByUsername(account.getUsername());
			if (accountInTable != null && 
				accountInTable.getUsername().equals(account.getUsername()) &&
				accountInTable.getPassword().equals(account.getPassword())) {
				if (accountInTable.getCode().equals("") ) {
					HttpSession session = request.getSession();					session.setAttribute("account", account);
					return "customer/customer_home";									
				}
				else {
					errors.rejectValue("password", "account", "Tài khoản chưa được kích hoạt!");
					model.addAttribute("account", account);
					return "customer/login";
				}
			}
			else {
				errors.rejectValue("password", "account", "Sai thông tin đăng nhập!");
				model.addAttribute("account", account);
				return "customer/login";
			}
		}
	}
	
	@RequestMapping(value = "logout")
	public String logout(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("account");
		model.addAttribute("part", "home");
		model.addAttribute("products", productDAO.getAllProduct());
		model.addAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		model.addAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		return "customer/customer_home";
	}
}