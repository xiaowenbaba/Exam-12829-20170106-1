package com.fdw.controller;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.fdw.service.UserService;
@Controller
public class Test {
	@Autowired
	private UserService userService;
	
	public void start(){
		while(true){
			System.out.println("1[删除],2【批量出入】3【监听事件】");
			Scanner scanner = new Scanner(System.in);
			String key  = scanner.nextLine();
			if(key.equals("1")){
				userService.deleteByIdOrName();	
			}else if(key.equals("2")){
				userService.selectUserByFirstOrLastName();				
			}else {
				System.out.println("输入有误请从新输入！");
			}
		}
	}
	public void start2(){
		userService.insertBatch();
		
	}
}
