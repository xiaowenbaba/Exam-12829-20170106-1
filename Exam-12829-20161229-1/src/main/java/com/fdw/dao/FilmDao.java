package com.fdw.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fdw.entity.Film;
@Repository
public class FilmDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public  int insertOneInToFilm(Film film){
		return sqlSessionTemplate.insert("com.fdw.mapper.FilmMapper.insertOneInToFilm", film);
	}
}
