package com.hand.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hand.common.Page;
import com.hand.dto.ResponeData;
import com.hand.entity.Film;
import com.hand.service.FilmService;

@Controller
@RequestMapping("/film")
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	@RequestMapping(path="",method = RequestMethod.GET)
	@ResponseBody
	public Page<Film>  queryFilmListByPage( @RequestParam(name = "title", required = false ) String title,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "currentPage",required = false) int currentPage,
            @RequestParam(name = "pageSize", required = false) int pageSize,
            @RequestParam(name = "languageId", required = false) Integer languageId){
		Page<Film> page = new Page<Film>();
		Film  film = new Film();
		film.setLanguageId(languageId);			
		film.setTitle(title);
		film.setDescription(description);
		page.setCurrentPage(currentPage);
		page.setPageNumber(pageSize);
		page.setData(filmService.queryFilmListByPage(page,film));
		return page;
	}
	@RequestMapping("/insert")
	@ResponseBody
	public  Integer   insertOneInToFilm(@RequestParam(name = "title", required = false ) String title,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "languageId", required = false) Integer languageId){
		Film film = new Film();
		film.setTitle(title);
		film.setLanguageId(languageId);
		film.setDescription(description);
		int result=filmService.insertOneInToFilm(film);
		if(result>0){
			return 1;			
		}
			return 0;			
		
	}

	@RequestMapping("/delete")
	@ResponseBody
	public  String    deleteById(@RequestParam(name="id") Integer id){
		Film film = new Film();
		film.setFilmId(id);
			int result=0;
		try {			
			 result = filmService.deleteById(film);
			if(result>0){
				return "删除成功！";			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (result==0) {
				return "删除失败,该数据还有用哦,亲~";						
			}
		}
		return "删除失败";
	}
	@RequestMapping("/getId")
	public  String   getId( HttpServletRequest request,@RequestParam(name = "id", required = false ) Integer id){
		request.getSession().setAttribute("id", id);
		return "modify";
	}  
	
	@RequestMapping("/getFilm")
	@ResponseBody
	public  ResponeData<Film>  selectById(HttpServletRequest request){
		ResponeData<Film> responeData = new ResponeData<>();
		List<Film> list = new ArrayList<>();
		Film film = new Film();
		Integer id =(Integer) request.getSession().getAttribute("id");		
		film.setFilmId(id);			
		list.add(filmService.selectById(film));
		responeData.setData(list);
		return responeData;
	}
	@RequestMapping("/modify")
	@ResponseBody
	public  int    modifyFilm( @RequestParam(name = "title", required = false ) String title,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "filmId", required = false ) Integer id,
			@RequestParam(name = "language", required = false ) Integer languageId){
			Film film = new Film();
			film.setTitle(title);
			film.setDescription(description);
			film.setLanguageId(languageId);
			film.setFilmId(id);
			int  result=filmService.updateById(film);
		return result;
	}
}
