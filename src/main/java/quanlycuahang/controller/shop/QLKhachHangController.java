package quanlycuahang.controller.shop;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.dao.shop.QLKhachHangDAO;
import quanlycuahang.dao.shop.QLSanPhamDAO;
import quanlycuahang.entity.Client;

@Controller
@Transactional
@RequestMapping("admin/")
public class QLKhachHangController {
	@Autowired
	QLKhachHangDAO khachHangDAO;
	
	@Autowired
	private SessionFactory factory;

	@RequestMapping(value = "indexKH")
	public String index(ModelMap model) {
		List<Client> clients= khachHangDAO.getAllClient();
		model.addAttribute("clients", clients);
		return "qlKhachHang";
	}
	
	
}

