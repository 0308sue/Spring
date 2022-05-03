package com.board.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.board.dto.MemberDTO;

public interface MemberMapper {

	@Insert("insert into member values(#{id},#{name},#{pass},#{addr},now())")
	public void join(MemberDTO member);
	
	public int idCheck(String id);
	
	@Select("select * from member where id = #{id}")
	public MemberDTO loginCheck(String id);

	@Update ("update member set name=#{name},pass=#{pass},addr=#{addr},regdate=now() where id=#{id}")
	public void memberupdate(MemberDTO member);
	
	@Delete("delete from member where id = #{id}")
	public void memberdelete(String id);
	
	

}
