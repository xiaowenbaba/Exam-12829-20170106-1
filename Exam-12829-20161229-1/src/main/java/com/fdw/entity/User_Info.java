package com.fdw.entity;

public class User_Info {
	private int  userId;
	private String tel;
	private String address;
	
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "User_Info [userId=" + userId + ", tel=" + tel + ", address=" + address + "]";
	}
}
