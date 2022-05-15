package quanlycuahang.dao.shop;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.Product;
@Repository
public class QLSanPhamDAO {
	@Autowired
	SessionFactory factory;
	
	public List<Product> getAllProduct() {
		Session session = factory.getCurrentSession();
		String hql ="from Product";
		Query query = session.createQuery(hql);
		List<Product> listProduct = query.list();
		return listProduct;
	}
	
	public Product getProductByID(int id) {
		Session session = factory.getCurrentSession();
		String hql = "from Product where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Product list = (Product) query.list().get(0);
		return list;
	}
	
	public Product getProductByName(String name) {
		Session session = factory.getCurrentSession();
		String hql = "from Product where name = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		Product list = (Product) query.list().get(0);
		return list;
	}
	
	public List<Product> searchProduct(String name) {
		Session session = factory.getCurrentSession();
		String hql = "from Product where name like :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + name + "%");

		List<Product> list = query.list();
		return list;
	}
	
	public int insertProduct(Product product) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(product);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public int updateProduct(Product product) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(product);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public int deleteProduct(Product product) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(product);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
}
