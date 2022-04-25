package com.person.model;

import java.util.List;

public interface PersonDAO {

	public void personInsert(PersonDTO person);
	public List<PersonDTO> personList();
	public PersonDTO personView(String id);
	public void personUpdate(PersonDTO person);
	public void personDelete(String id);
}
