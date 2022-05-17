package quanlycuahang.controller.customer;

import java.util.HashSet;

import java.util.Set;

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
	public String home(ModelMap model) {
		model.addAttribute("part", "home");
		model.addAttribute("products", productDAO.getAllProduct());
		model.addAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		model.addAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "top")
	public String top(ModelMap model) {
		model.addAttribute("part", "top");
		model.addAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		model.addAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		Set<ProductType> productType = partDAO.getPartById(1).getProTypeList();
		Set<Product> products = new HashSet<Product>();
		for (ProductType pt : productType) 
			products.addAll(pt.getList());
		model.addAttribute("products", products);
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "top/{id}")
	public String topByType(ModelMap model, @PathVariable("id") int id) {
		model.addAttribute("part", "top/"+id);
		model.addAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		model.addAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		model.addAttribute("products", productTypeDAO.getProductTypeById(id).getList());
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "bot")
	public String bot(ModelMap model) {
		model.addAttribute("part", "bot");
		model.addAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		model.addAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		Set<ProductType> productType = partDAO.getPartById(2).getProTypeList();
		Set<Product> products = new HashSet<Product>();
		for (ProductType pt : productType) 
			products.addAll(pt.getList());
		model.addAttribute("products", products);
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "bot/{id}")
	public String botByType(ModelMap model, @PathVariable("id") int id) {
		model.addAttribute("part", "top/"+id);
		model.addAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		model.addAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		model.addAttribute("products", productTypeDAO.getProductTypeById(id).getList());
		return "customer/customer_home";
	}
	
	@RequestMapping(value = "new")
	public String newArrival(ModelMap model) {
		model.addAttribute("part", "new");
		model.addAttribute("products", productDAO.getAllProduct());
		model.addAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		model.addAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		return "customer/customer_home";
	}
}
