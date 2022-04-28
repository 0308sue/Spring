package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService{
@Autowired
private GuestRepository repository;
	@Override
	public void guestinsert(GuestVO guest) {
		repository.dao_guestinsert(guest);
		
	}

	@Override
	public List<GuestVO> guestlist(HashMap<String, String> hm) {
		return repository.dao_guestlist(hm);
	}

	@Override
	public GuestVO findByNum(int num) {
		// TODO Auto-generated method stub
		return repository.dao_findByNum(num);
	}

	@Override
	public void guestUpdate(GuestVO guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guestDelete(int num) {
		repository.dao_guestDelete(num);
		
	}

	@Override
	public int guestCount(HashMap<String, String> hm) {
		return repository.dao_guestCount(hm);
	}

}
