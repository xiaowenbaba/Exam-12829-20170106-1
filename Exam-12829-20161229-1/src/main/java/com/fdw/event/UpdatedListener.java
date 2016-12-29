package com.fdw.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.fdw.service.User_InfoService;
@Component
public class UpdatedListener  implements ApplicationListener<UpdatedUserEvent>{
	@Autowired
	private User_InfoService user_InfoService;
	public void onApplicationEvent(UpdatedUserEvent event) {
		if(event instanceof UpdatedUserEvent){
			System.out.println(((UpdatedUserEvent) event).getUser_Info());
				user_InfoService.insertByListener(((UpdatedUserEvent) event).getUser_Info());
		}
	}

}
