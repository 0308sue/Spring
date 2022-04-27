package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService{
	@Autowired
	private GuestDAOImpl dao;

	@Override
	public void guestinsert(GuestDTO guest) {
		dao.dao_guestinsert("insertGuest", guest);
		
	}

	@Override
	public List<GuestDTO> guestlist(HashMap<String, String> hm) {
		return dao.dao_guestlist("listGuest", hm);
	}

	@Override
	public GuestDTO findByNum(int num) {
		return dao.dao_findByNum("viewGuest", num);
	}

	@Override
	public void guestUpdate(GuestDTO guest) {
		dao.dao_guestUpdate("updateGuest", guest);
		
	}

	@Override
	public void guestDelete(int num) {
		dao.dao_guestDelete("deleteGuest", num);
		
	}

	@Override
	public int guestCount(HashMap<String, String> hm) {
		return dao.dao_guestCount("guestCount", hm);
	}

}
