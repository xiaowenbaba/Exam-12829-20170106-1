package com.fdw.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.fdw.event.AfterInsertFilmEvent;
import com.fdw.event.BeforeInsertFilmEvent;

@Aspect
@Component
public class ComServiceAOP implements ApplicationEventPublisherAware {
	@Pointcut("execution(* com.fdw.service..*.*(..))")
	private void anyMethod1() {
		
	}//声明一个切入点	
	private ApplicationEventPublisher ajcDeclareAnnotation;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		// TODO Auto-generated method stub
		this.ajcDeclareAnnotation = applicationEventPublisher;
	}
	@Around("anyMethod1()")//环绕通知
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		String befMSG="Before Insert Film Data";
		BeforeInsertFilmEvent beforeInsertFilmEvent = new BeforeInsertFilmEvent(befMSG);
		ajcDeclareAnnotation.publishEvent(beforeInsertFilmEvent);
		Object object= pjp.proceed();
		String aftMSG="After Insert Film Data";
		AfterInsertFilmEvent afterInsertFilmEvent = new AfterInsertFilmEvent(aftMSG);
		ajcDeclareAnnotation.publishEvent(afterInsertFilmEvent);
		return object;
	}
}

