package com.Exam_12829_20161229_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdw.controller.Test;

/**
 * 执行程序入口
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml",
    				"classpath:mybatis-config.xml");
    		Test test = (Test)beanFactory.getBean("test");
    		test.start();
    	
    }
}
