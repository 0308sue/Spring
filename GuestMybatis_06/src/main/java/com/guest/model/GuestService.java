package com.guest.model;

import java.util.HashMap;
import java.util.List;



public interface GuestService {
	public void guestinsert(GuestVO guest);
	public List<GuestVO> guestlist(HashMap<String, String> hm);
	public GuestVO findByNum(int num);
	public void guestUpdate(GuestVO guest);
	public void guestDelete(int num);
	public int guestCount(HashMap<String, String> hm);
}
