package com.fdw.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fdw.entity.Film;
import com.fdw.entity.Page;

@Repository
public class FilmDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public  int insertOneInToFilm(Film film){
		return sqlSessionTemplate.insert("com.fdw.mapper.FilmMapper.insertOneInToFilm", film);
	}
	public Page<Film> queryFilmListByPage(Page<Film> page) {
		
		 page.setData( sqlSessionTemplate.selectList("com.fdw.mapper.FilmMapper.queryFilmListByPage", page));
		return page;
	}
}
