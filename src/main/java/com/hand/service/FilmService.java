package com.hand.service;



import java.util.List;

import com.hand.common.Page;
import com.hand.entity.Film;

public interface FilmService {
	List<Film> queryFilmListByPage(Page<Film> page,Film film);
	int insertOneInToFilm(Film film);
	int  deleteById(Film film);
	Film selectById(Film film);
	int updateById (Film film);
}
