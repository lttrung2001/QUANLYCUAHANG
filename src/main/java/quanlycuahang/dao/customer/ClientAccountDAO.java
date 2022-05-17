package quanlycuahang.dao.customer;

import java.util.List;



import javax.transaction.Transactional;

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
			if (session.get(ClientAccount.class, account.getUsername()) == null) {
				session.close();
				return -1;
			}
			session.save(account);
			transaction.commit();
			session.close();
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			session.close();
			return -2; // Tạo tài khoản thất bại
		}
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
	@SuppressWarnings("unchecked")
	public ClientAccount getClientAccountByUsername(String username) {
		Session session = factory.getCurrentSession();
		return (ClientAccount) session.get(ClientAccount.class, username);
	}
	@SuppressWarnings("unchecked")
	public List<ClientAccount> getAccounts() {
		Session session = factory.getCurrentSession();
		return (List<ClientAccount>) session.createQuery("from ClientAccount").list();
	}
}
