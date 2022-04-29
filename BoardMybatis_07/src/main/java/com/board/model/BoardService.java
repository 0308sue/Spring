package com.board.model;

import java.util.HashMap;
import java.util.List;

import com.board.dto.BoardDTO;
import com.board.dto.FileBoardDTO;

public interface BoardService {

	public void  insert(BoardDTO board);
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	public BoardDTO findByNum(int num);
	public void update(BoardDTO board);
	public void delete(int num);
	public int getCount(HashMap<String, Object> hm);
	public void fileInsert(FileBoardDTO board);
	public List<FileBoardDTO> fileList();
	
}
