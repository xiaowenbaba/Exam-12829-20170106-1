package com.fdw.event;


import org.springframework.context.ApplicationEvent;

public class AfterInsertFilmEvent extends ApplicationEvent{
	private String msg;
	public AfterInsertFilmEvent(Object source) {
		super(source);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public AfterInsertFilmEvent(String  msg) {
		super(msg);
		this.msg = msg;
	}
}
