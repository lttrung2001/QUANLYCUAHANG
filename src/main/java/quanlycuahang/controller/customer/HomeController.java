package quanlycuahang.controller.customer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.dao.customer.PartDAO;
import quanlycuahang.dao.shop.ProductTypeDAO;
import quanlycuahang.dao.shop.QLSanPhamDAO;
import quanlycuahang.entity.Product;
import quanlycuahang.entity.ProductType;

@Controller
public class HomeController {
	@Autowired
	private QLSanPhamDAO productDAO;
	@Autowired
	private PartDAO partDAO;
	@Autowired
	private ProductTypeDAO productTypeDAO;
	
	@RequestMapping(value = "home")
	public String home(ModelMap model, Integer offset, Integer maxResults) {
		model.addAttribute("part", "home");
		model.addAttribute("count", productDAO.count());
		model.addAttribute("offset", offset);
		model.addAttribute("products", productDAO.findAll(offset, maxResults));
//		model.addAttribute("products", productDAO.getAllProduct());
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "top")
	public String top(ModelMap model) {
		model.addAttribute("part", "top");
		List<ProductType> productType = partDAO.getPartById(1).getProTypeList();
		List<Product> products = new ArrayList<Product>();
		for (ProductType pt : productType) 
			products.addAll(pt.getList());
		model.addAttribute("products", products);
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "top/{id}")
	public String topByType(ModelMap model, @PathVariable("id") int id) {
		model.addAttribute("part", "top/"+id);
		model.addAttribute("products", productTypeDAO.getProductTypeById(id).getList());
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "bot")
	public String bot(ModelMap model) {
		model.addAttribute("part", "bot");
		List<ProductType> productType = partDAO.getPartById(2).getProTypeList();
		List<Product> products = new ArrayList<Product>();
		for (ProductType pt : productType) 
			products.addAll(pt.getList());
		model.addAttribute("products", products);
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "bot/{id}")
	public String botByType(ModelMap model, @PathVariable("id") int id) {
		model.addAttribute("part", "top/"+id);
		model.addAttribute("products", productTypeDAO.getProductTypeById(id).getList());
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "new")
	public String newArrival(ModelMap model) {
		model.addAttribute("part", "new");
		model.addAttribute("products", productDAO.getTop20Product());
		return "customer/customer_home";
	}
}
