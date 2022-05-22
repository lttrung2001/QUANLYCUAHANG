package quanlycuahang.dao.shop;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.entity.BillDetail;

@Transactional
@Repository
public class BillDetailDAO {

	@Autowired
	SessionFactory factory;
	
	public boolean checkProIDinBillDetail(int id)
	{
		Session session = factory.getCurrentSession();
		String hql="FROM BillDetail  where  productInBill.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<BillDetail> check =  query.list();
		if (check.isEmpty()) {
			return true;
		}
		else
		{
			return false;
		}
	}
}
