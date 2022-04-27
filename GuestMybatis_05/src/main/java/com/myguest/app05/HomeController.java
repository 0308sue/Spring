package com.myguest.app05;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myguest.model.GuestDTO;
import com.myguest.model.GuestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private GuestService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "insert";
	}
	
	@PostMapping("gInsert")
	public String insert(GuestDTO guest,HttpServletRequest request) {
		guest.setIpaddr(request.getRemoteAddr());
		service.guestinsert(guest);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(String field,String word,Model model) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);
		List<GuestDTO>guestlist = service.guestlist(hm);
		int count = service.guestCount(hm);
		model.addAttribute("guestlist",guestlist);
		model.addAttribute("count",count);
		return "list";
	}
	
	@GetMapping({"view","update"})
	public void view(int num,Model model) {
		model.addAttribute("guest",service.findByNum(num));
	}
	
	@PostMapping("update")
	public String update(GuestDTO guest) {
		service.guestUpdate(guest);
		return "redirect:list";
	}
	
	@GetMapping("delete")
	public String delete(int num) {
		service.guestDelete(num);
		return "redirect:list";
	}
	
}
