package quanlycuahang.controller;

import javax.transaction.Transactional;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import quanlycuahang.entity.Staff;

@Controller
@Transactional
public class TestController {
	@Autowired
	private SessionFactory factory;

	@RequestMapping(value = "test2")
	public String test2(ModelMap modelMap) {
		Query query = factory.getCurrentSession().createQuery("from Staff where id = 106");
		Staff trung = (Staff) query.list().get(0);
		modelMap.addAttribute("trung", trung);
		return "test2";
	}
}
