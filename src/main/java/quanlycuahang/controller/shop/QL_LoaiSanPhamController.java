package quanlycuahang.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quanlycuahang.entity.*;

@Transactional
@Controller
@RequestMapping("admin/product/")
public class QL_LoaiSanPhamController {

	@Autowired
	SessionFactory factory;

	@RequestMapping("productType")
	public String index(ModelMap model, @ModelAttribute("productType") ProductType productType) {

		List<ProductType> ProductType = this.getProductType();
		model.addAttribute("ProductType", ProductType);
		model.addAttribute("btnStatus", "btnAdd");
		return "shop/QL_LoaiSanPham";
	}

	public List<ProductType> getProductType() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductType";
		Query query = session.createQuery(hql);
		List<ProductType> list = query.list();
		return list;
	}

	public List<ProductType> searchProductType(String pro_type_name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductType where proTypeName LIKE :pro_type_name";
		Query query = session.createQuery(hql);
		query.setParameter("pro_type_name", "%" + pro_type_name + "%");
		List<ProductType> list = query.list();
		return list;
	}

	@RequestMapping(value = "productType", params = "btnsearch")
	public String search(HttpServletRequest request, ModelMap model,
			@ModelAttribute("productType") ProductType productType) {

		List<ProductType> ProductType = this.searchProductType(request.getParameter("searchInput"));
		model.addAttribute("ProductType", ProductType);
		return "shop/QL_LoaiSanPham";
	}

	@ModelAttribute("namePart")
	public List<Part> getNamePart() {

		Session session = factory.getCurrentSession();
		String hql = "FROM Part";
		Query query = session.createQuery(hql);
		List<Part> list = query.list();
		return list;
	}

	public ProductType getProductType(int id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductType where proTypeId = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ProductType list = (ProductType) query.list().get(0);
		return list;
	}
	
	public int updateProductType(ProductType pt) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(pt);
			t.commit();
		} catch (Exception ex) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "productType/{id}.htm", params = "linkEdit")
	public String editProductType(HttpServletRequest request, ModelMap model,
			@ModelAttribute("productType") ProductType productType,
			@PathVariable("id") int id) {

		List<ProductType> ProductType = this.getProductType();
		model.addAttribute("ProductType", ProductType);
		model.addAttribute("productType", this.getProductType(id));
		System.out.println( this.getProductType(id));
		model.addAttribute("btnStatus", "btnEdit");
		return "shop/QL_LoaiSanPham";
	}
	
	@RequestMapping(value = "productType", params = "btnEdit")
	public String edit(ModelMap model, 
			@ModelAttribute("productType") ProductType productType) {
		System.out.println(productType);
		int temp = this.updateProductType(productType);
		if (temp != 0) {
			model.addAttribute("message", "Sửa thành công");

		} else {
			model.addAttribute("message", "Sửa thất bại");
		}
		List<ProductType> ProductType = this.getProductType();
		model.addAttribute("ProductType", ProductType);
		return "shop/QL_LoaiSanPham";
	}

	public int insertProductType(ProductType pt) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(pt);
			t.commit();
		} catch (Exception ex) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	@RequestMapping(value = "productType", params = "btnAdd", method = RequestMethod.POST)
	public String add(ModelMap model, @ModelAttribute("productType") ProductType productType) {

		int temp = this.insertProductType(productType);
		
		if (temp != 0) {
			model.addAttribute("message", "Thêm thành công");

		} else {
			model.addAttribute("message", "Thêm thất bại");
		}
		List<ProductType> ProductType = this.getProductType();
		model.addAttribute("ProductType", ProductType);
		return "shop/QL_LoaiSanPham";
	}

	public int deleteProductType(ProductType pt) {
		Session session = factory.openSession();
		session.refresh(pt);
		Transaction t = session.beginTransaction();
		try {
			session.delete(pt);
			t.commit();
		} catch (Exception ex) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;

	}

	@RequestMapping(value = "productType/{id}.htm", params = "linkDelete")
	public String delete(HttpServletRequest request, ModelMap model,
			@ModelAttribute("productType") ProductType productType, @PathVariable("id") int id) {

		ProductType tmp = getProductType(id);
		int temp = this.deleteProductType(tmp);
		if (temp != 0) {
			model.addAttribute("message", "Xóa thành công");

		} else {
			model.addAttribute("message", "Xóa thất bại");
		}
		List<ProductType> ProductType = this.getProductType();
		model.addAttribute("ProductType", ProductType);
		return "shop/QL_LoaiSanPham";
	}

}
