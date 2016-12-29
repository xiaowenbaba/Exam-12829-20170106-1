package com.fdw.event;

import org.springframework.context.ApplicationEvent;

import com.fdw.entity.User_Info;

public class UpdatedUserEvent extends ApplicationEvent {
	
	private   User_Info  user_Info ;
	public UpdatedUserEvent(Object source) {
		super(source);
	}
	
	public UpdatedUserEvent(User_Info user_Info) {
		super(user_Info);
		this.user_Info = user_Info;
	}

	public User_Info getUser_Info() {
		return user_Info;
	}

	public void setUser_Info(User_Info user_Info) {
		this.user_Info = user_Info;
	}
	
	
}
