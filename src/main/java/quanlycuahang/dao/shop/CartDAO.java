package quanlycuahang.dao.shop;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.Cart;


@Transactional
@Repository
public class CartDAO {
	@Autowired
	SessionFactory factory;
	
	public List<Cart> getCartByProID(int id) {
		Session session = factory.getCurrentSession();
		String hql = "from Cart where productInCart.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<Cart> list = query.list();
		return list;
	}
	
	public int deleteCart(Cart Cart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(Cart);
			t.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			session.close();
			return 0;
		}
	}
}
