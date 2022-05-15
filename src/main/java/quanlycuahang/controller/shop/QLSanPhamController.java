package quanlycuahang.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.entity.ProductType;
import quanlycuahang.entity.Product;
import quanlycuahang.dao.shop.QLSanPhamDAO;

@Controller
@RequestMapping("admin/")
public class QLSanPhamController {
	@Autowired
	QLSanPhamDAO sanPhamDAO;
	
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "indexSP")
	public String index(HttpServletRequest request, ModelMap model, @ModelAttribute("product") Product product) {
		List<Product> products = sanPhamDAO.getAllProduct();
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("products", products);

		return "qlSanPham";
	}
	
	@ModelAttribute("productTypeSelect")
	public List<ProductType> getProductType(){
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductType";
		Query query = session.createQuery(hql);
		List<ProductType> list = query.list();
		return list;
	}
	
	@RequestMapping(value="index",params = "btnAdd")
	public String addProduct(HttpServletRequest request,ModelMap model,
			@ModelAttribute("product") Product product) {
		Integer temp = sanPhamDAO.insertProduct(product);
		if(temp!=0)
		{
			model.addAttribute("message","Them thanh cong");
		}
		else
		{
			model.addAttribute("message","Them that bai");
		}
		model.addAttribute("products",  sanPhamDAO.getAllProduct());
		return "qlSanPham";
	}
	
	@RequestMapping(value="/index/{id}.htm",params = "linkDelete")
	public String deleteProduct(HttpServletRequest request,ModelMap model,
			@ModelAttribute("product") Product product,@PathVariable("id") Integer id) {
		Integer temp = sanPhamDAO.deleteProduct(product);
		if(temp!=0)
		{
			model.addAttribute("message","Xoa thanh cong");
		}
		else
		{
			model.addAttribute("message","Xoa that bai");
		}
		model.addAttribute("products", sanPhamDAO.getAllProduct());
		return "qlSanPham";
	}
	
	@RequestMapping(value="/index/{id}",params = "linkEdit")
	public String editProduct(HttpServletRequest request,ModelMap model,
			@ModelAttribute("product") Product product,@PathVariable("id") Integer id) {
		Integer temp = sanPhamDAO.insertProduct(product);
		if(temp!=0)
		{
			model.addAttribute("message","Them thanh cong");
		}
		else
		{
			model.addAttribute("message","Them that bai");
		}
		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("products", sanPhamDAO.getProductByID(id));
		model.addAttribute("products", sanPhamDAO.getAllProduct());
		return "qlSanPham";
	}
	
	@RequestMapping(value="index", params = "btnsearch")
	public String searchPro(HttpServletRequest request, ModelMap model,
			@ModelAttribute("product") Product product) {
		
		model.addAttribute("products", sanPhamDAO.searchProduct(request.getParameter("searchInput")));
		model.addAttribute("products", sanPhamDAO.getAllProduct());
		
		 return "qlSanPham";
	}
}
