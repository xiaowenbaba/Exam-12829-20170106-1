package com.fdw.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fdw.entity.User;
import com.fdw.entity.User_Info;
@Repository
public class User_InfoDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public  int  insertByListener(User_Info user){
		return sessionTemplate.insert("com.fdw.mapper.User_InfoMapper.insertByListener", user);
	}
}
