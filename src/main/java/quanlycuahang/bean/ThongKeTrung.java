package quanlycuahang.bean;

import quanlycuahang.entity.Product;

public class ThongKeTrung {
	private Product product;
	private int amount;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ThongKeTrung(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
	}
	public ThongKeTrung() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
