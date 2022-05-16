package quanlycuahang.dao.customer;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.ClientAccount;

@Transactional
@Repository
public class ClientAccountDAO {
	@Autowired
	private SessionFactory factory;
	
	public int createAccount(ClientAccount account) {
		Session session =  factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// Tài khoản đã tồn tại
			if (getAccounts().contains(account)) {
				session.close();
				return -1;
			}
			session.save(account);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			session.close();
			return -2; // Tạo tài khoản thất bại
		}
		session.close();
		return 0;
	}
	public int updateAccount(ClientAccount account) {
		Session session =  factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(account);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			session.close();
			return -1; // Lỗi khi cập nhật tài khoản
		}
		session.close();
		return 0;
	}
	public ClientAccount getClientAccountById(int id) {
		Session session = factory.getCurrentSession();
		return (ClientAccount)session.get(ClientAccount.class, id);
	}
	@SuppressWarnings("unchecked")
	public ClientAccount getClientAccountByUsername(String username) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from ClientAccount where username = :username").setParameter("username", username);
		List<ClientAccount> result = query.list();
		return result.isEmpty() ? null : result.get(0);
	}
	@SuppressWarnings("unchecked")
	public List<ClientAccount> getAccounts() {
		Session session = factory.getCurrentSession();
		return (List<ClientAccount>) session.createQuery("from ClientAccount").list();
	}
}
