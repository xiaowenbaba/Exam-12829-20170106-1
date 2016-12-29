package com.fdw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.fdw.dao.UserTamplate;
import com.fdw.entity.User;
import com.fdw.entity.User_Info;
import com.fdw.event.UpdatedUserEvent;

@Service
public class UserService  implements ApplicationEventPublisherAware{
	@Autowired
	private UserTamplate  userTamplate;
	private ApplicationEventPublisher ajcDeclareAnnotation;
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		// TODO Auto-generated method stub
		this.ajcDeclareAnnotation=applicationEventPublisher;
	}
	
	public void deleteByIdOrName(){
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要删除的id");
		Integer id = scanner.nextInt();
		if (id != null) {
			System.out.println("确定要删除吗？输入YES表示删除 ,输入其他表示返回!");
			Scanner scanner2 = new Scanner(System.in);
			String key = scanner2.nextLine();
			if (key.equals("YES")) {
				user.setId(id);
				int result = userTamplate.deleteById(user);
				System.out.println(result);
				if (result > 0) {
					System.out.println("删除成功！");
				}
			} else {
				System.out.println("返回成功！");
			}
		}
	}
	public  void  selectUserByFirstOrLastName(){
		User user = new User();
		user.setFirstName("%"+""+"%");
		user.setLastName("%"+""+"%");
		List<User> list=userTamplate.selectUserByFirstOrLastName(user);
		System.out.println(list);
	}
	
	
	public  void  insertBatch(){
		List<User> list= new ArrayList<User>();
		User user = new User();
		user.setId(35);
		user.setFirstName("dsadas");
		user.setLastName("dsaddadaad");
		list.add(user);
		userTamplate.insertBatch(list);
		User_Info user_Info = new User_Info();
		user_Info.setUserId(user.getId());
		user_Info.setTel("");
		user_Info.setAddress("");
		UpdatedUserEvent event = new UpdatedUserEvent(user_Info);
		System.out.println("insertBatch");
		ajcDeclareAnnotation.publishEvent(event);
	}
	
}
