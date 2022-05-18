package quanlycuahang.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.dao.customer.ClientAccountDAO;
import quanlycuahang.entity.ClientAccount;

@Controller
@RequestMapping(value = "account")
public class ChangeInfoController {
	@Autowired
	private ClientAccountDAO clientAccountDAO;
	
	@RequestMapping(value = "info")
	public String info(ModelMap model) {
		model.addAttribute("account", new ClientAccount());
		return "customer/security";
	}
}
