package com.myspring.models;

import java.util.HashMap;
import java.util.List;

import com.myspring.vo.PersonVO;


public interface PersonService {
	public void insert(PersonVO person);
	public List<PersonVO> list(HashMap<String, String> hm);
	public List<PersonVO> listAll();
	public PersonVO view(String id);
	public void update(PersonVO person);
	public void delete(String id);
	public int count(HashMap<String, String> hm);
	public int countAll();
}
