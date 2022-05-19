package quanlycuahang.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<Client> clients = khachHangDAO.getAllClient();
		model.addAttribute("clients", clients);
		return "shop/QL_KhachHang";
	}
	
	@RequestMapping(value = "/index/{id}.htm", params = "linkInfo")
	public String clientInfo(ModelMap model,@PathVariable("id") String id) {
		
		/* model.addAttribute("btnStatus", "btnEdit"); */
		Client client = new Client();
		client =khachHangDAO.getClientByID(id);
		model.addAttribute("client", client);
		model.addAttribute("clients", khachHangDAO.getAllClient());
		return "shop/QL_KhachHang";
	}
	
	@RequestMapping(value = "index", params = "btnsearch")
	public String searchPro(HttpServletRequest request, ModelMap model) {
		String firstName = request.getParameter("searchInput");
		List<Client> list = khachHangDAO.searchClient(firstName);
		model.addAttribute("clients", list);
		return "shop/QL_KhachHang";
	}

}
