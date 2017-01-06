package com.hand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.dto.ResponeData;
import com.hand.entity.Language;
import com.hand.mapper.LanguageMapper;
import com.hand.service.LanguageService;
@Service
public class LanguageServiceImpl implements LanguageService {
	@Autowired
	private LanguageMapper languageMapper;
	@Override
	public ResponeData<Language> selectOne() {
		ResponeData<Language> languageResponeData = new ResponeData<>();
		 languageResponeData.setData(languageMapper.selectOne());
		 return languageResponeData;
	}
	
}
