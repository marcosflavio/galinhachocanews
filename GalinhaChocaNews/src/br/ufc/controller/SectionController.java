package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.ISectionDAO;
import br.ufc.model.News;
import br.ufc.model.Section;
import br.ufc.model.User;

@Transactional
@Controller
public class SectionController {

	@Autowired
	@Qualifier(value = "sectionDAO")
	private ISectionDAO sectionDAO;

	@RequestMapping("/insertSectionForm")
	public String insertSectionForm() {

		return "section/insert_section_form";
	}

	@RequestMapping("/insertSection")
	public String insertSection(Section section, HttpSession session) {

		section.setUser(((User) (session.getAttribute("user_logged_editor"))));
		sectionDAO.insert(section);
		return "section/insert_section_ok";
	}

	@RequestMapping("/removeSection")
	public String removeSection(Long id) {
		sectionDAO.remove(id);

		return "redirect:listSection";
	}

	@RequestMapping("/updateSectionForm")
	public String updateSectionForm(Long id, Model model) {

		Section section = sectionDAO.recover(id);

		model.addAttribute(section);

		return "section/update_section_form";
	}

	@RequestMapping("/updateSection")
	public String updateSection(Section section, HttpSession session) {

		section.setUser(((User) (session.getAttribute("user_logged_editor"))));
		sectionDAO.update(section);
		return "redirect:listSection";
	}

	@RequestMapping("/listSection")
	public String listSection(Model model) {

		List<Section> sections = sectionDAO.list();

		model.addAttribute("sections", sections);
		return "section/list_section";
	}
	
	@RequestMapping("/showNewsInSection")
	public String showNewsInSection(Long id, Model model){
		
		List<News> newsList = sectionDAO.listNews(id);
		
		model.addAttribute("newsList", newsList);
		
		return "news/show_news_in_section";
	}
}







