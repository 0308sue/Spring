package com.myspring.app04;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.models.PersonService;
import com.myspring.vo.PersonVO;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private PersonService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("per_insert")
	public String per_insert() {
		return "insert";
	}
	
	@PostMapping("per_insert")
	public String insert(@ModelAttribute PersonVO person) {
		service.insert(person);
		return "redirect:per_list";
	}
	
	@GetMapping("per_list")
	public String list(String field,String word,Model model) {
//		List<PersonVO>personlist = service.listAll();
//		int count = service.countAll();
		HashMap<String, String> hm = new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);
		List<PersonVO>personlist = service.list(hm);
		int count = service.count(hm);
		model.addAttribute("personlist",personlist);
		model.addAttribute("count",count);
		return "list";
	}
	
	@GetMapping({"view","update"})
	public void view(String id,Model model) {
		model.addAttribute("person",service.view(id));
	}
	
	@PostMapping("update")
	public String update(PersonVO person) {
		service.update(person);
		return "redirect:per_list";
	}
	
	@GetMapping("delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:per_list";
	}
}
