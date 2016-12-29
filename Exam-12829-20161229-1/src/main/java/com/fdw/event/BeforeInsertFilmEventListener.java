package com.fdw.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;
@Component
public class BeforeInsertFilmEventListener implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof BeforeInsertFilmEvent){
			System.out.println(((BeforeInsertFilmEvent) event).getMsg());
		}else if (event instanceof ContextStartedEvent ){
			System.out.println(" Context Start ");
		}
	}

}
