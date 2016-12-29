package com.fdw.mapper;

import java.util.List;

import com.fdw.entity.User;

public interface UserMapper {
	List<User> selectUserByFirstOrLastName(User user);
	
	int  insertBatch(List<User> list);
	
	int  deleteById(User user);
}
