package quanlycuahang.dao.customer;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.Part;

@Repository
@Transactional
public class PartDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public Part getPartById(int id) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from Part WHERE id = :id");
		query.setParameter("id", id);
		return (Part) query.list().get(0);
	}
}
