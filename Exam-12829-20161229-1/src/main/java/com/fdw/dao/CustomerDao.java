package com.fdw.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdw.entity.Customer;

@Service
public class CustomerDao  {
	@Autowired
	private	SqlSessionTemplate  sqlSessionTemplate;
	
	
	public Customer login(String first_name) {
		Customer customer=sqlSessionTemplate.selectOne("com.fdw.mapper.CustomerMapper.login", first_name);
		return customer;
	}
	
}
