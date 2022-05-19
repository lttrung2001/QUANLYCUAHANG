package quanlycuahang.controller.customer;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlycuahang.dao.customer.ClientAccountDAO;
import quanlycuahang.entity.ClientAccount;

@Controller
@Transactional
@RequestMapping(value = "account")
public class ForgotPassWordController {
	@Autowired
	private ClientAccountDAO clientAccountDAO;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "forgot")
	public String forgot(ModelMap model) {
		model.addAttribute("account", new ClientAccount());
		return "customer/forgetpass";
	}
	@RequestMapping(value = "forgot", method = RequestMethod.POST)
	public String forgot(ModelMap model, @Validated @ModelAttribute("account") ClientAccount account,
						BindingResult errors) throws MessagingException {
		if (errors.hasFieldErrors("username") || errors.hasFieldErrors("email")) {
			model.addAttribute("account", account);
			return "customer/forgetpass";
		}
		else { 
			ClientAccount tmp = clientAccountDAO.getClientAccountByUsername(account.getUsername());
			if (!tmp.getUsername().equals(account.getUsername())) {
				errors.rejectValue("username", "account", "Tài khoản không khớp!");
				model.addAttribute("account", account);
				return "customer/forgetpass";
			}
			else if (!tmp.getEmail().equalsIgnoreCase(account.getEmail())) {
				errors.rejectValue("email", "account", "Email không khớp!");
				model.addAttribute("account", account);
				return "customer/forgetpass";
			}
			else {
				Random rand = new Random();
				Integer num = rand.nextInt(100000, 999999);
				
				tmp.setPassword(num.toString());
				clientAccountDAO.updateAccount(tmp);
				
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message);

				helper.setFrom("no-reply-email");
				helper.setTo(tmp.getEmail());
				helper.setSubject("ĐẶT LẠI MẬT KHẨU CHO TÀI KHOẢN: " + tmp.getUsername());
				helper.setText("Mật khẩu của bạn là: " + num);
				mailSender.send(message);
				
				model.addAttribute("account", new ClientAccount());
				return "customer/login";
			}
		}
	}
}
