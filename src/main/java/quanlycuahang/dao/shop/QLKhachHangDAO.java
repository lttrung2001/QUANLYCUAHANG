package quanlycuahang.dao.shop;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.Client;

@Repository
@Transactional
public class QLKhachHangDAO {
	@Autowired
	SessionFactory factory;
	
	public List<Client> getAllClient() {
		Session session = factory.getCurrentSession();
		String hql ="from Client";
		Query query = session.createQuery(hql);
		List<Client> list = query.list();
		return list;
	}
	
	public Client getClientByID(String id) {
		Session session = factory.getCurrentSession();
		String hql = "from Client where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Client list = (Client) query.list().get(0);
		return list;
	}
	
	public List<Client> searchClient(String  firstName) {
		Session session = factory.getCurrentSession();
		/*
		 * select u from User u where lower(concat(u.lastName,' ',u.firstName)) like
		 * lower(:typedName) or lower(concat(u.firstName,' ',u.lastName)) like
		 * lower(:typedName)
		 */
		String hql ="from Client where firstName like :firstName";
		Query query = session.createQuery(hql);
		query.setParameter("firstName", "%" + firstName + "%");
		List<Client> list = query.list();
		return list;
	}
	
	public List<Client> top6() {
		Session session = factory.getCurrentSession();
		String hql ="from Client as ac order by ac.clientAccount.createdDate desc";
		Query query = session.createQuery(hql).setMaxResults(6);
		List<Client> listProduct = query.list();
		return listProduct;
	}
	
}
