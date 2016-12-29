package com.fdw.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fdw.entity.User;
@Repository
public class UserTamplate  {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	public List<User> selectUserByFirstOrLastName(User user) {
		System.out.println(user);
		List<User> use =sqlSessionTemplate.selectList("com.fdw.mapper.UserMapper.selectUserByFirstOrLastName",user);
		System.out.println(use);
		return use;
	}

	
	public int insertBatch(List<User> list) {
		int result=sqlSessionTemplate.insert("com.fdw.mapper.UserMapper.insertBatch", list);
		return result;
	}

	
	public int deleteById(User user) {
		int result=sqlSessionTemplate.delete("com.fdw.mapper.UserMapper.deleteByIdOrName", user);
		return result;
	}
	
}
