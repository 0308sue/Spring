package com.myguest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestDAO {
	public void dao_guestinsert(String mid,GuestDTO guest);
	public List<GuestDTO> dao_guestlist(String mid,HashMap<String, String> hm);
	public GuestDTO dao_findByNum(String mid,int num);
	public void dao_guestUpdate(String mid,GuestDTO guest);
	public void dao_guestDelete(String mid,int num);
	public int dao_guestCount(String mid,HashMap<String, String> hm);
}
