package com.hand.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.dto.ResponeData;
import com.hand.entity.Language;
import com.hand.service.LanguageService;

@Controller
@RequestMapping("/language")
public class LanguageController {
	@Autowired
	private  LanguageService languageService;
	
	@RequestMapping(path="",method = RequestMethod.GET)
	@ResponseBody
	public  ResponeData<Language>   getLanguage() {
		return 	languageService.selectOne();
	}
}
