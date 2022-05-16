package quanlycuahang.controller.shop;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.dao.shop.QLKhachHangDAO;
import quanlycuahang.entity.Client;


@Controller
@RequestMapping("/admin/customer/")
public class QLKhachHangController {
	@Autowired
	QLKhachHangDAO khachHangDAO;

	@RequestMapping(value = "index")
	public String index(ModelMap model) {
		List<Client> clients= khachHangDAO.getAllClient();
		model.addAttribute("clients", clients);
		return "shop/QL_KhachHang";
	}
	
	
}

