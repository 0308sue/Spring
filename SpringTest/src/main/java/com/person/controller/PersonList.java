package com.person.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAO;
import com.person.model.PersonDTO;

public class PersonList extends AbstractController{
	private PersonDAO dao;
	
	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		List<PersonDTO> userlist = dao.personList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("personlist",userlist);
		mv.setViewName("WEB-INF/jsp/personList.jsp");
		return mv;
	}

}
