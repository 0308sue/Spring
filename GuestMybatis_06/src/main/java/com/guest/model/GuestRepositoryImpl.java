package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.guest.mapper.GuestMapper;

@Repository
public class GuestRepositoryImpl implements GuestRepository{
	@Autowired
	private GuestMapper mapper;

	@Override
	public void dao_guestinsert(GuestVO guest) {
		mapper.insert(guest);		
	}

	@Override
	public List<GuestVO> dao_guestlist(HashMap<String, String> hm) {
		// TODO Auto-generated method stub
		return mapper.list(hm);
	}

	@Override
	public GuestVO dao_findByNum(int num) {
		// TODO Auto-generated method stub
		return mapper.view(num);
	}

	@Override
	public void dao_guestUpdate(GuestVO guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dao_guestDelete(int num) {
		mapper.delete(num);
		
	}

	@Override
	public int dao_guestCount(HashMap<String, String> hm) {
		// TODO Auto-generated method stub
		return mapper.count(hm);
	}

}
