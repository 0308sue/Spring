package com.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.CommentDTO;
import com.board.mapper.CommentMapper;
@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper cmapper;

	@Override
	public void insert(CommentDTO comment) {
		cmapper.insert(comment);
		
	}

	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	@Override
	public void delete(int cnum) {
		 cmapper.delete(cnum);
		
	}

}
