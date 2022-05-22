package quanlycuahang.dao.shop;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.Bill;

@Transactional
@Repository
public class QLBillDAO {

	@Autowired
	SessionFactory factory;
	
	public List<Bill> getAllBill() {
		Session session = factory.getCurrentSession();
		String hql ="from Bill";
		Query query = session.createQuery(hql);
		List<Bill> listBill = query.list();
		return listBill;
	}
}
