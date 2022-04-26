package com.myspring.models;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.vo.PersonVO;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDAOImpl dao;
	
	@Override
	public void insert(PersonVO person) {
		dao.dao_insert("insertPerson", person);
		
	}

	@Override
	public List<PersonVO> list(HashMap<String, String> hm) {
		return dao.dao_list("listPerson", hm);
	}

	@Override
	public PersonVO view(String id) {
		return dao.dao_view("viewPerson", id);
	}

	@Override
	public void update(PersonVO person) {
		dao.dao_update("updatePerson", person);
		
	}

	@Override
	public void delete(String id) {
		dao.dao_delete("deletePerson", id);
		
	}

	@Override
	public int count(HashMap<String, String> hm) {
		return dao.dao_count("personCount", hm);
	}

	@Override
	public List<PersonVO> listAll() {
		return dao.dao_listAll("allPerson");
	}

	@Override
	public int countAll() {
		return dao.dao_countAll("allCount");
	}

}
