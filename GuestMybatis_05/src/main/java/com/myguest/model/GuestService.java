package com.myguest.model;

import java.util.HashMap;
import java.util.List;



public interface GuestService {
	public void guestinsert(GuestDTO guest);
	public List<GuestDTO> guestlist(HashMap<String, String> hm);
	public GuestDTO findByNum(int num);
	public void guestUpdate(GuestDTO guest);
	public void guestDelete(int num);
	public int guestCount(HashMap<String, String> hm);
}
