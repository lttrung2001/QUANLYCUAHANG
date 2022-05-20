package quanlycuahang.dao.shop;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import quanlycuahang.bean.ThongKeTrung;
import quanlycuahang.entity.Bill;
import quanlycuahang.entity.BillDetail;

@Transactional
@Repository
public class ThongKeDAO {
	
	@Autowired
	QLBillDAO billDAO;
	
	public List<ThongKeTrung> getThongKe(){
		List<Bill> bills = new ArrayList<Bill>();
		billDAO.getAllBill().forEach(bill-> {
			if (bill.getStatus() == 'Y') {
				bills.add(bill);
			}
		});
		List<ThongKeTrung> tk = new ArrayList<ThongKeTrung>();
		for (Bill bill : bills) {
			for (BillDetail bd : bill.getBillDetails()) {
				if (tk.isEmpty()) {
					tk.add(new ThongKeTrung(bd.getProductInBill(), bd.getAmount()));
				}
				else {
					for (ThongKeTrung t : tk) {
						if (bd.getProductInBill().getId() == t.getProduct().getId()) {
							t.setAmount(t.getAmount()+bd.getAmount());
							break;
						}
					}
					tk.add(new ThongKeTrung(bd.getProductInBill(), bd.getAmount()));
				}
			}
		}
		return tk;
	}
	
	public int getSum(List<ThongKeTrung> listhongKe)
	{
		int sum = 0;
		for(ThongKeTrung tk: listhongKe)
		{
			sum+=tk.getAmount()*tk.getProduct().getPrice();
		}
		return sum;
	}
	
	public int getSumAmount(List<ThongKeTrung> listhongKe)
	{
		int sumAmount = 0;
		for(ThongKeTrung tk: listhongKe)
		{
			sumAmount+=tk.getAmount();
		}
		return sumAmount;
	}
	
	public String getMax(List<ThongKeTrung> listhongKe)
	{
		ThongKeTrung Max = new ThongKeTrung();
		Max.setAmount(0);
		for(ThongKeTrung tk: listhongKe)
		{
			if( Max.getAmount() < tk.getAmount())
			{
				Max = tk;
			}
		}
		return Max.getProduct().getName();
	}
	
}
