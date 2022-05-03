package com.board.app07;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.MemberDTO;
import com.board.model.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;

	
	@GetMapping("join")
	public void join() {}
	
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody MemberDTO member) {
		int cnt = mservice.idCheck(member.getId());
		if(cnt!=0)return"fail";
		mservice.join(member);
		return "success";
	}
	
	@GetMapping("idcheck")
	@ResponseBody
	public int idcheck(String id) {		
		return mservice.idCheck(id);
	}
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	@ResponseBody
	public String login(String id,String pass,HttpSession session) {
		String result="";
		MemberDTO member = mservice.loginCheck(id);
		if(member==null) {
			result="no";
		}else if(member.getPass().equals(pass)){
			session.setAttribute("sMember", member);
			result="success";
		}else {
			result="passError";
		}
		return result;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/login";
	}
	
	@GetMapping("change")
	public String change(HttpSession session) {
		//MemberDTO member = mservice.findByid(session.getId() );
		//session.setAttribute("sMember", member);
		return "member/memberview";
	}
	@GetMapping("update")
	public String update(HttpSession session) {
		return "member/memberupdate";
	}
	
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody MemberDTO member,HttpSession session) {
		mservice.memberupdate(member);
		session.invalidate();
		return "success";
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public String delete(@PathVariable String id,HttpSession session) {
		mservice.memberdelete(id);
		session.invalidate();
		return "success";
	}
	
}
