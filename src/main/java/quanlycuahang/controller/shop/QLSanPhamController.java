package quanlycuahang.controller.shop;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import quanlycuahang.entity.ProductType;
import quanlycuahang.entity.Product;
import quanlycuahang.dao.shop.QLSanPhamDAO;

@Controller
@RequestMapping("admin/product/")
public class QLSanPhamController {
	@Autowired
	QLSanPhamDAO sanPhamDAO;

	@Autowired
	SessionFactory factory;


	@RequestMapping(value = "index" ,method = RequestMethod.GET)
	public String index( ModelMap model, @ModelAttribute("product") Product product) {
		List<Product> products = sanPhamDAO.getAllProduct();
		model.addAttribute("btnStatus", "btnAdd"); 
		model.addAttribute("products", products);

		return "shop/QL_SanPham";
	}

	@Transactional
	@ModelAttribute("productTypeSelect")
	public List<ProductType> getProductType() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductType";
		Query query = session.createQuery(hql);
		List<ProductType> list = query.list();
		return list;
	}

	@RequestMapping(value = "index1", params = "btnAdd", method = RequestMethod.POST)
	public String addProduct(ModelMap model,
			@ModelAttribute("product") Product product,@RequestParam("file") MultipartFile file) {
		String fileName = sanPhamDAO.uploadFile1(file);
		if (fileName.equals("/resources/my_image/") || fileName.equals("0") ) {
			product.setImage(sanPhamDAO.defaulttName());
		} else {
			product.setImage(fileName); 
		}
		 product.setInsertDate(new Date()); 
		int temp = sanPhamDAO.insertProduct(product);
		if (temp != 0) {
			model.addAttribute("message", "Them thanh cong");
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("product", new Product());
		} else {
			model.addAttribute("message", "Them that bai");
			model.addAttribute("btnStatus", "btnAdd");
		}
		 model.addAttribute("products", sanPhamDAO.getAllProduct()); 
		return "shop/QL_SanPham";
	}

	@RequestMapping(value = "/index/{id}.htm", params = "linkDelete")
	public String deleteProduct( ModelMap model,

			@ModelAttribute("product") Product product, @PathVariable("id") int id) {

		int temp = sanPhamDAO.deleteProduct(product);
		if (temp != 0) {
			model.addAttribute("message", "Xoa thanh cong");
		} else {
			model.addAttribute("message", "Xoa that bai");
		}
		model.addAttribute("products", sanPhamDAO.getAllProduct());
		return "shop/QL_SanPham";
	}

	@RequestMapping(value = "/index/{id}.htm", params = "linkEdit")
	public String editProduct( ModelMap model,

			@ModelAttribute("product") Product product, @PathVariable("id") int id) {

		model.addAttribute("btnStatus", "btnEdit");
		model.addAttribute("product", sanPhamDAO.getProductByID(id));
		model.addAttribute("products", sanPhamDAO.getAllProduct());
		return "shop/QL_SanPham";
	}

	@RequestMapping(value = "index1", params = "btnEdit", method = RequestMethod.POST)
	public String edit_Product( ModelMap model,
			@ModelAttribute("product") Product product,@RequestParam("file") MultipartFile file) {
		Product proTam = sanPhamDAO.getProductByID(product.getId());
		String fileName = sanPhamDAO.uploadFile1(file);
		if (!fileName.equals("/resources/my_image/")) {
			product.setImage(fileName);
		}
		product.setInsertDate(proTam.getInsertDate());
		int temp = sanPhamDAO.updateProduct(product);
		if (temp != 0) {
			model.addAttribute("message", "Sua thanh cong");
		} else {

			model.addAttribute("message", "Sua that bai");
		}
		// model.addAttribute("products", this.getProducts());
		model.addAttribute("products", sanPhamDAO.getAllProduct());
		return "shop/QL_SanPham";
	}

	@RequestMapping(value = "index", params = "btnsearch")
	public String searchPro(HttpServletRequest request, ModelMap model,
			@ModelAttribute("product") Product product) {
		String name = request.getParameter("searchInput");
		List<Product> list = sanPhamDAO.searchProduct(name);
		model.addAttribute("products", list);
		/* model.addAttribute("products", sanPhamDAO.getAllProduct()); */
		model.addAttribute("btnStatus", "btnAdd"); 
		return "shop/QL_SanPham";
	}

}
