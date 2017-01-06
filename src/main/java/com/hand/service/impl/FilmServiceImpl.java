package com.hand.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Service;

import com.hand.common.Page;
import com.hand.entity.Film;
import com.hand.mapper.FilmMapper;
import com.hand.service.FilmService;
@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmMapper filmMapper;
	
	public	List<Film> queryFilmListByPage(Page<Film> page,Film film) {
		Map<String,Object> parameter = new  HashMap<String, Object>();
		parameter.put("page", page);
		parameter.put("film",film );
		List<Film> responseData = new ArrayList<Film>();
		responseData=filmMapper.queryFilmListByPage(parameter);
		return responseData;
	}

	@Override
	public int insertOneInToFilm(Film film) {
		return filmMapper.insertOneInToFilm(film);
	}

	@Override
	public int deleteById(Film film) {
		return filmMapper.deleteById(film);
	}

	@Override
	public Film selectById(Film film) {
		
		return filmMapper.selectById(film);
	}

	@Override
	public int updateById(Film film) {
		return filmMapper.updateById(film);
	}

}
