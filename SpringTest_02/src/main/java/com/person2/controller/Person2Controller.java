package com.person2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.person2.model.Person2DAOImpl;
import com.person2.model.PersonVO;

@Controller
public class Person2Controller {
	@Autowired
	private Person2DAOImpl dao;
	
	@RequestMapping("person_insert.go")
	public String person_insert() {
		return "personForm";
	}
	@RequestMapping(value="person_insert.go",method = RequestMethod.POST)
	public String insert(PersonVO person) {
		dao.person_insert(person);
		return "redirect:person_list.go";
	}
	
	@RequestMapping("person_list.go")
	public String person_list(Model model) {
		List<PersonVO> personlist = dao.person_list();
		int count = dao.person_count();
		model.addAttribute("personlist", personlist);
		model.addAttribute("count", count);
		return "personList";
	}
	@RequestMapping("person_view.go")
	public String view(String id,Model model) {
		PersonVO person =  dao.person_view(id);
		model.addAttribute("person", person);
		return "personView";
	}
	
	@RequestMapping("person_update.go")
	public String updateform(String id,Model model) {
		model.addAttribute("person",  dao.person_view(id));
		return "personUpdate";
	}
	@RequestMapping(value="person_update.go",method = RequestMethod.POST)
	public String update(PersonVO person) {
		dao.person_update(person);
		return "redirect:person_list.go";
	}
	@RequestMapping("person_delete.go")
	public String person_delete(String id,Model model) {
		dao.person_delete(id);
		return "redirect:person_list.go";
	}
}
