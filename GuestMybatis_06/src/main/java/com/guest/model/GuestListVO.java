package com.guest.model;

import java.util.List;

import lombok.Getter;
@Getter
public class GuestListVO {
	private List<GuestVO> arr;
	private int count;
	
	public GuestListVO(int count,List<GuestVO> arr) {
		this.count = count;
		this.arr = arr;
	}
}
