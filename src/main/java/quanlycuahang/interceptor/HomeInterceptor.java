package quanlycuahang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import quanlycuahang.dao.customer.PartDAO;

public class HomeInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private PartDAO partDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("productTypeTop", partDAO.getPartById(1).getProTypeList());
		request.setAttribute("productTypeBot", partDAO.getPartById(2).getProTypeList());
		return super.preHandle(request, response, handler);
	}
}
