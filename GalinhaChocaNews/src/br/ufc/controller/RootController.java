package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.IAdsDAO;
import br.ufc.interfaces.ISectionDAO;
import br.ufc.model.Section;

@Controller
@Transactional
public class RootController {

	@Autowired
	@Qualifier(value = "sectionDAO")
	private ISectionDAO sectionDAO;

	@Autowired
	@Qualifier(value = "adsDAO")
	private IAdsDAO adsDAO;
	
	@RequestMapping("/")
	public String home(Model model){
		List<Section> sections = sectionDAO.list();

		model.addAttribute("sections", sections);
		return "index";
	}
	
}
