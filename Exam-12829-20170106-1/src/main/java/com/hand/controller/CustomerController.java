package com.hand.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.entity.Customer;
import com.hand.service.CustomerService;

@Controller
@RequestMapping("/costomer")
public class CustomerController {
	@Autowired
	private  CustomerService customerService;
	
	@RequestMapping(path="",method = RequestMethod.GET)
	@ResponseBody
	public  String    login(@RequestParam(name = "firstName", required = false ) String firstName) {
		Customer customer = new Customer();
		if(firstName!=null &&!"".equals(firstName)){
			customer.setFirstName(firstName);
		}
		Customer customer2 = new Customer();
		String MSG = "登陆失败,账号不存在或账号错误!";
		try {
			customer2 =	customerService.selectByFistName(customer);	
			if(customer2!=null){
				return MSG= "登陆成功!";
			}else{
				return MSG="登陆失败,账号不存在或账号错误!";
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return MSG;
		}
	}
}
