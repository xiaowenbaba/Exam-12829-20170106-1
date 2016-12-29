package com.fdw.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.dao.User_InfoDao;
import com.fdw.entity.User;
import com.fdw.entity.User_Info;

@Service
public class User_InfoService {
	@Autowired
	private   User_InfoDao  user_InfoDao;
	public  void  insertByListener(User_Info user){
		user_InfoDao.insertByListener(user);
	}
}
