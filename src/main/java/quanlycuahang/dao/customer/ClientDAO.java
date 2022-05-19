package quanlycuahang.dao.customer;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.Client;

@Repository
@Transactional
public class ClientDAO {
	@Autowired
	private SessionFactory factory;
	
	public void changeClientInfo(Client client) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(client);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		} finally {
			session.close();
		}
	}
}
