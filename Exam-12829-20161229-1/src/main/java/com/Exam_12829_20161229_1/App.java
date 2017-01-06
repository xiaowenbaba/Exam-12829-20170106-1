package com.Exam_12829_20161229_1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdw.entity.Film;
import com.fdw.entity.Page;
import com.fdw.service.FilmService;

/**
 * 执行程序入口
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml",
    				"classpath:mybatis-config.xml");
    		FilmService filmService = (FilmService)beanFactory.getBean("filmService");
    		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)beanFactory;
    		configurableApplicationContext.start();
    		/*Film film = new Film();
    		Scanner scanner = new Scanner(System.in);
    		System.out.println("请输入电影名称");
    		String title = scanner.nextLine();
    		if(!"".equals(title)&&title!=null){
    			film.setTitle(title);
    		}
    		Scanner scanner1 = new Scanner(System.in);
    		System.out.println("请输入电影描述");
    		
    		String description = scanner1.nextLine();
    		if(!"".equals(description)&&description!=null){
    			film.setDescription(description);
    		}
    		Scanner scanner2 = new Scanner(System.in);
    		System.out.println("请输入语言ID");
    		Integer language_id = scanner2.nextInt();
    		if(language_id!=null){
    			film.setLanguageId(language_id);
    		}
    		filmService.insertFilm(film);*/
    		Page<Film > page  = new Page<Film>();
    		page.setCurrentPage(1);
    		Page<Film> page1=filmService.queryFilmListByPage(page);
    		System.out.println(page1.getData().toString());
    		configurableApplicationContext.close();
    		
    }
}
