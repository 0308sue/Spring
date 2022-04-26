package com.myspring.model;

import java.util.List;


public interface MPersonDAO {
	public void per_insert(Person person);
	public List<Person> per_list();
	public int per_count();
	public Person per_view(String id);
	public void per_update(Person person);
	public void per_delete(String id);
	
	

}
