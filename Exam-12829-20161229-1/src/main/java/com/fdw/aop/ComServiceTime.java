package com.fdw.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ComServiceTime {
	@Pointcut("execution(* com.fdw.service..*.*(..))")
	private void anyMethod1() {
		
	}//声明一个切入点	
	
	@Around("anyMethod1()")//环绕通知
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		long begin = System.currentTimeMillis(); 
		Object object= pjp.proceed();
		long end = System.currentTimeMillis();
		Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        //Object target = pjp.getTarget();
       // Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
		System.out.println(msig.getName()+"方法执行时间为"+(end-begin)+"毫秒");  
		return object;
	}
}

