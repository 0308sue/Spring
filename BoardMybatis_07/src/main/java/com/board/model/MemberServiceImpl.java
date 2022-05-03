package com.board.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.BoardDTO;
import com.board.dto.MemberDTO;
import com.board.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
@Autowired
private MemberMapper mmapper;
	@Override
	public void join(MemberDTO member) {
		mmapper.join(member);
		
	}

	@Override
	public int idCheck(String id) {
		return mmapper.idCheck(id);
	}

	@Override
	public MemberDTO loginCheck(String id) {
		return mmapper.loginCheck(id);
	}
	
	
	public void memberupdate(MemberDTO member) {
		mmapper.memberupdate(member);
	}
	
	public void memberdelete(String id) {
		mmapper.memberdelete(id);
	}

}
