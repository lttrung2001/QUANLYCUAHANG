package quanlycuahang.dao.shop;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.ProductType;

@Repository
@Transactional
public class ProductTypeDAO {
	@Autowired
	private SessionFactory factory;
	
	public ProductType getProductTypeById(int id) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from ProductType where id = :id");
		query.setParameter("id", id);
		return (ProductType) query.list().get(0);
	}
}
