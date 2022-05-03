package com.board.model;


import com.board.dto.MemberDTO;

public interface MemberService {
	
	public void join(MemberDTO member);
	
	public int idCheck(String id);
	
	public MemberDTO loginCheck(String id);
	

	
	public void memberupdate(MemberDTO member);	
	
	public void memberdelete(String id);
	
}
