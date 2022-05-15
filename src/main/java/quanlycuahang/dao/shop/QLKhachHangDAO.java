package quanlycuahang.dao.shop;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.Client;

@Repository
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
}
