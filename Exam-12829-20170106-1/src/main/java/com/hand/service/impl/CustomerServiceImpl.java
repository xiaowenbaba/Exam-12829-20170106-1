package com.hand.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Service;

import com.hand.common.Page;
import com.hand.dto.ResponeData;
import com.hand.entity.Customer;
import com.hand.entity.Film;
import com.hand.entity.Language;
import com.hand.mapper.CustomerMapper;
import com.hand.mapper.FilmMapper;
import com.hand.service.CustomerService;
import com.hand.service.FilmService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public Customer selectByFistName(Customer customer) {
		System.out.println(customer.getFirstName());
		return customerMapper.selectByFistName(customer);
	}
	

}
