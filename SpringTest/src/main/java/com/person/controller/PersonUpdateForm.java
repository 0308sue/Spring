package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAO;
import com.person.model.PersonDTO;

public class PersonUpdateForm extends AbstractController {

	private PersonDAO dao;
	
	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String id = req.getParameter("id");
		PersonDTO person = dao.personView(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("person",person);
		mv.setViewName("WEB-INF/jsp/personUpdate.jsp");
		return mv;
	}


}
