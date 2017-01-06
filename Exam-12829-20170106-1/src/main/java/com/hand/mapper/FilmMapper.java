package com.hand.mapper;

import java.util.List;
import java.util.Map;

import com.hand.entity.Film;

public interface FilmMapper {
	List<Film> queryFilmListByPage(Map<String, Object> parameter);
	int insertOneInToFilm(Film film);
	int deleteById(Film film);
	Film selectById(Film film);
	int updateById (Film film);
}
