package quanlycuahang.controller.shop;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.bean.ThongKeTrung;
import quanlycuahang.dao.shop.QLBillDAO;
import quanlycuahang.dao.shop.QLKhachHangDAO;
import quanlycuahang.dao.shop.ThongKeDAO;
import quanlycuahang.entity.Client;

@Transactional
@Controller
@RequestMapping("admin/thongke/")
public class ThongKeController {

	@Autowired
	QLBillDAO billDAO;
	
	@Autowired
	QLKhachHangDAO qlKhachHangDAO;
	
	@Autowired
	ThongKeDAO thongKeDAO;
	
	@RequestMapping("index")
	public String index(ModelMap model)
	{ 
		List<ThongKeTrung> listhongKe = thongKeDAO.getThongKe();
		List<Client> listTop6 = qlKhachHangDAO.top6();
		List<Client> countClient = qlKhachHangDAO.getAllClient();
		int sumAmount = thongKeDAO.getSumAmount(listhongKe);
		String maxProduct = thongKeDAO.getMax(listhongKe);
		int sum = thongKeDAO.getSum(listhongKe);
		int count = countClient.size();
		model.addAttribute("sumAmount", sumAmount);
		model.addAttribute("max", maxProduct);
		model.addAttribute("count", count);
		model.addAttribute("sum", sum);
		model.addAttribute("list", listhongKe);
		model.addAttribute("listTop6", listTop6);
		return "shop/QL_ThongKe";
	}
}
