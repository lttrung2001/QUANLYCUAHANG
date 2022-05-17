package quanlycuahang.controller.customer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quanlycuahang.dao.customer.ClientAccountDAO;
import quanlycuahang.entity.Client;
import quanlycuahang.entity.ClientAccount;

@Controller
public class RegisterController {
	@Autowired
	private ClientAccountDAO clientAccountDAO;
	
	@RequestMapping(value = "register")
	public String register(ModelMap model) {
		model.addAttribute("account", new ClientAccount());
		return "customer/register";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(ModelMap model, @ModelAttribute("account") ClientAccount account, BindingResult errors) {
		Client client = account.getClientInfo();
		client.setId(account.getUsername());
		account.setClientInfo(client);
		account.setCreatedDate(new Date());
		
		int res = clientAccountDAO.checkAccountExists(account);
		// Trùng tên tài khoản
		if (res == -1) {
			errors.rejectValue("username", "account", "Tên tài khoản đã tồn tại!");
		}
		// Trùng email
		else if (res == -2) {
			errors.rejectValue("email", "account", "Email đã tồn tại!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("account", account);
			return "customer/register";
		}
		else {
			clientAccountDAO.createAccount(account);
			return "customer/customer_home";
		}
	}
}
