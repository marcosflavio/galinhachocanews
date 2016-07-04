package br.ufc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.INewsDAO;
import br.ufc.interfaces.ISectionDAO;
import br.ufc.model.News;
import br.ufc.model.Section;
import br.ufc.model.User;

@Controller
@Transactional
public class NewsController {

	@Autowired
	@Qualifier(value = "newsDAO")
	private INewsDAO newsDAO;

	@Autowired
	@Qualifier(value = "sectionDAO")
	private ISectionDAO sectionDAO;

	@RequestMapping("/insertNewsForm")
	public String insertNewsForm() {
		return "news/insert_news_form";
	}

	@RequestMapping("/insertNews")
	public String insertNews(News news, HttpSession session) {
		Calendar data = Calendar.getInstance();
		Date d = data.getTime();

		Long id = news.getIdSection();
		Section section = sectionDAO.recover(id);
		news.setSection(section);
		news.setNewsDate(d);

		news.setUser(((User) session.getAttribute("user_logged_journalist")));
		
		System.out.println("Data: " + news.getDate());
		newsDAO.insert(news);

		return "news/insert_news_ok";
	}

	
	
	@RequestMapping("/listNews")
	public String listNews(Model model) {

		List<News> newsList = newsDAO.list();
		model.addAttribute("newsList", newsList);
		return "news/list_news";
	}

	@RequestMapping("/removeNews")
	public String removeNews(Long id) {

		newsDAO.remove(id);

		return "redirect:listNews";
	}

	@RequestMapping("/updateNewsForm")
	public String updateNewsForm(Long id, Model model) {

		News news = newsDAO.recover(id);
		model.addAttribute(news);

		return "news/update_news_form";
	}

	@RequestMapping("/updateNews")
	public String updateNews(News news, HttpSession session) {

		Calendar data = Calendar.getInstance();
		Date d = data.getTime();

		Long id = news.getIdSection();
		Section section = sectionDAO.recover(id);
		news.setSection(section);
		news.setNewsDate(d);

		news.setUser(((User) session.getAttribute("user_logged_journalist")));
		newsDAO.update(news);

		return "redirect:listNews";
	}
	
	@RequestMapping("/showNewsForm")
	public String showNewsForm(Long id, Model model) {
		News news = newsDAO.recover(id);
		if (news != null) {
			model.addAttribute(news);
			return "news/show_news_form";
		}
		return "criarPaginaDeErro";
	}

//	@RequestMapping("/showNews")
//	public String showNews() {
//
//		return "user/show_news";//criar
//	}
}
