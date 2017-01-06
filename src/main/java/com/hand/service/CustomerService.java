package com.hand.service;

import java.util.List;

import com.hand.dto.ResponeData;
import com.hand.entity.Customer;
import com.hand.entity.Language;

public interface CustomerService {
	Customer selectByFistName(Customer customer);
}
