package com.fdw.event;

import org.springframework.context.ApplicationEvent;

public class BeforeInsertFilmEvent  extends ApplicationEvent{
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public BeforeInsertFilmEvent(Object source) {
		super(source);
	}
	public BeforeInsertFilmEvent(String  msg) {
		super(msg);
		this.msg = msg;
	}

}
