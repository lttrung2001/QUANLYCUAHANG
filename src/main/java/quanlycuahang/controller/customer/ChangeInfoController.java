package quanlycuahang.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlycuahang.dao.customer.ClientAccountDAO;
import quanlycuahang.dao.customer.ClientDAO;
import quanlycuahang.entity.Client;
import quanlycuahang.entity.ClientAccount;

@Controller
@Transactional
@RequestMapping(value = "account")
public class ChangeInfoController {
	@Autowired
	private SessionFactory factory;
	@Autowired
	private ClientAccountDAO clientAccountDAO;
	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping(value = "info")
	public String info(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ClientAccount accountInSession = (ClientAccount) session.getAttribute("account");
		ClientAccount account = clientAccountDAO.getClientAccountByUsername(accountInSession.getUsername());
		model.addAttribute("account", account);
		model.addAttribute("info", account.getClientInfo());
		return "customer/security";
	}
	
	@RequestMapping(value = "info", method = RequestMethod.POST)
	public String info(ModelMap model, @Validated @ModelAttribute("info") Client info, BindingResult errors) {
		if (errors.hasErrors()) {
			factory.getCurrentSession().refresh(info);
			model.addAttribute("info-message", "Sửa thông tin thất bại!");
		}
		else {
			clientDAO.changeClientInfo(info);
			factory.getCurrentSession().refresh(info);
			model.addAttribute("info-message", "Sửa thông tin thành công!");
		}
		model.addAttribute("info", info);
		model.addAttribute("account", info.getClientAccount());
		return "customer/security";
	}
	
	@RequestMapping(value = "email", method = RequestMethod.POST)
	public String email(ModelMap model, @Validated @ModelAttribute("account") ClientAccount account, BindingResult errors) {
		String email = account.getEmail();
		ClientAccount inDB = clientAccountDAO.getClientAccountByUsername(account.getUsername());
		String code = inDB.getCode();
		factory.getCurrentSession().refresh(account);
		if (errors.hasErrors()) {
			model.addAttribute("account-message", "Thay đổi email thất bại!");
		}
		else {
			if (account.getEmail().equals(email)) {
				errors.rejectValue("email", "account", "Email mới trùng với email hiện tại!");
			}
			else if (account.getCode().equals(code)) {
				account.setEmail(email);
				account.setCode("");
				clientAccountDAO.updateAccount(account);
				model.addAttribute("account-message", "Thay đổi email thành công!");				
			}
			else {
				model.addAttribute("account-message", "Thay đổi email thất bại!");
				errors.rejectValue("code", "account", "Mã code sai mất rồi!");
			}
		}
		model.addAttribute("account", account);
		model.addAttribute("info", account.getClientInfo());
		return "customer/security";
	}
	
	@RequestMapping(value = "password", method = RequestMethod.POST)
	public String password(ModelMap model, 
							HttpServletRequest request, 
							@ModelAttribute("account") ClientAccount account, 
							BindingResult errors) {
		String oldPassword = request.getParameter("currentPassword");
		String password1 = request.getParameter("password-1");
		String password2 = request.getParameter("password-2");
		factory.getCurrentSession().refresh(account);
		if (oldPassword.equals("")) {
			errors.rejectValue("password", "account", "Không được để trống mật khẩu hiện tại!");
		}
		else if (password1.equals("") || password2.equals("")) {
			errors.rejectValue("password", "account", "Không được để trống mật khẩu mới!");
		}
		else if (account.getPassword().equals(oldPassword)) {
			if (password1.equals(password2)) {
				account.setPassword(password1);
				clientAccountDAO.updateAccount(account);
				model.addAttribute("password-message", "Thay đổi mật khẩu thành công!");
			}
			else {
				errors.rejectValue("password", "account", "Mật khẩu mới không khớp!");
			}
		}
		else {
			model.addAttribute("password-message", "Mật khẩu hiện tại không đúng!");
			errors.rejectValue("password", "account", "Mật khẩu hiện tại không đúng!");
		}
		model.addAttribute("account", account);
		model.addAttribute("info", account.getClientInfo());
		return "customer/security";
	}
}
