package com.fdw.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
@Component
public class AfterInsertFilmEventListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof AfterInsertFilmEvent ){
			System.out.println(((AfterInsertFilmEvent) event).getMsg());
		}else if(event instanceof ContextClosedEvent){
			System.out.println("Context stop");
		}
		
	}

}
