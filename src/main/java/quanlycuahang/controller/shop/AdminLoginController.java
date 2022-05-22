package quanlycuahang.controller.shop;

import java.util.List;

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
import quanlycuahang.bean.Admin;
import quanlycuahang.dao.shop.QLSanPhamDAO;
import quanlycuahang.entity.Product;

@Controller
@RequestMapping("admin/login/")
public class AdminLoginController {
	@Autowired
	private Admin admin;
	
	@Autowired
	private QLSanPhamDAO sanPhamDAO;
	
	@RequestMapping(value = "index" ,method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("admin", new Admin());
		return "shop/QL_Login";
	}
	
	@RequestMapping(value = "index", method = RequestMethod.POST)
	public String index(HttpServletRequest request, ModelMap model, @Validated @ModelAttribute("admin") Admin a,
						BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("admin", a);
			return "shop/QL_Login";
		}
		else {
			if (!a.getUsername().equals(admin.getUsername())) {
				errors.rejectValue("username", "admin", "Tài khoản không khớp!");
			}
			if (!a.getPassword().equals(admin.getPassword())) {
				errors.rejectValue("password", "admin", "Mật khẩu không chính xác!");
			}
			if (errors.hasErrors()) {
				model.addAttribute("admin", a);
				return "shop/QL_Login";
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				List<Product> products = sanPhamDAO.getAllProduct();
				model.addAttribute("product", new Product());
				model.addAttribute("btnStatus", "btnAdd"); 
				model.addAttribute("products", products);
				return "shop/QL_SanPham";
			}
		}
	}
}
