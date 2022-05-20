package quanlycuahang.controller.customer;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quanlycuahang.dao.shop.ProductTypeDAO;
import quanlycuahang.dao.shop.QLSanPhamDAO;
import quanlycuahang.entity.Product;

@Controller
public class SearchController {
	@Autowired
	private ProductTypeDAO productTypeDAO;
	@Autowired
	private QLSanPhamDAO productDAO;
	
	@RequestMapping(value = "home", params = "search")
	public String searchHome(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("part", "home");
		model.addAttribute("products", productDAO.searchProduct(search));
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "top", params = "search")
	public String searchTop(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("part", "top");
		model.addAttribute("products", productDAO.searchProduct(search));
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "top/{id}", params = "search")
	public String searchTop(ModelMap model, 
							@PathVariable("id") int id, 
							@RequestParam("search") String search) {
		List<Product> products = new ArrayList<Product>();
		productTypeDAO.getProductTypeById(id).getList().forEach(product-> {
			if (product.getName().contains(search))
				products.add(product);
		});
		model.addAttribute("part", "top"+id);
		model.addAttribute("products", products);
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "bot", params = "search")
	public String searchBot(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("part", "bot");
		model.addAttribute("products", productDAO.searchProduct(search));
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "bot/{id}", params = "search")
	public String searchBot(ModelMap model, 
							@PathVariable("id") int id, 
							@RequestParam("search") String search) {
		List<Product> products = new ArrayList<Product>();
		productTypeDAO.getProductTypeById(id).getList().forEach(product-> {
			if (product.getName().contains(search))
				products.add(product);
		});
		model.addAttribute("part", "bot"+id);
		model.addAttribute("products", products);
		return "customer/customer_home";
	}
}
