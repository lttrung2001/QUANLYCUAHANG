package quanlycuahang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import quanlycuahang.dao.customer.PartDAO;
import quanlycuahang.dao.shop.QLSanPhamDAO;

public class HomeInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private PartDAO partDAO;
	
	@Autowired
	private QLSanPhamDAO productDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		request.setAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		request.setAttribute("products", productDAO.getAllProduct());
		return super.preHandle(request, response, handler);
	}
}
