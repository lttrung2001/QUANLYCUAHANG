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
	
	public void createAccount(ClientAccount account) {
		Session session =  factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(account);
			session.save(account.getClientInfo());
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		} finally {
			session.close();
		}
	}
	public int updateAccount(ClientAccount account) {
		Session session =  factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(account);
			System.out.println(account.toString());
			transaction.commit();
			session.close();
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			session.close();
			return -1; // Lỗi khi cập nhật tài khoản
		}
	}
	public ClientAccount getClientAccountByUsername(String username) {
		Session session = factory.getCurrentSession();
		return (ClientAccount) session.get(ClientAccount.class, username);
	}
	@SuppressWarnings("unchecked")
	public List<ClientAccount> getAccounts() {
		Session session = factory.getCurrentSession();
		return (List<ClientAccount>) session.createQuery("from ClientAccount").list();
	}
	public int checkAccountExists(ClientAccount account) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from ClientAccount where username = :username and email = :email");
		query.setParameter("username", account.getUsername());
		query.setParameter("email", account.getEmail());
		List<ClientAccount> list = query.list();
		if (list.isEmpty())  {
			return 0;
		}
		ClientAccount acc = list.get(0);
		if (acc.getEmail().equalsIgnoreCase(account.getEmail()))
			return -2; // Trùng email
		else 
			return -1; // Trùng tên tài khoản
	}
}
