package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.IAdsDAO;
import br.ufc.model.Ads;
import br.ufc.model.News;
import br.ufc.model.User;

@Transactional
@Controller
public class AdsController {

	@Autowired
	@Qualifier(value = "adsDAO")
	private IAdsDAO adsDAO;

	@RequestMapping("/insertAdsForm")
	public String insertAdsForm() {

		return "ads/insert_ads_form";
	}

	@RequestMapping("/insertAds")
	public String insertAds(Ads ads, HttpSession session) {

		ads.setUser(((User) session.getAttribute("user_logged_editor")));
		
		adsDAO.insert(ads);
		return "ads/insert_ads_ok";
	}

	@RequestMapping("/removeAds")
	public String removeAds(Long id){
		
		adsDAO.remove(id);
		return "redirect:listAds";
	}
	
	@RequestMapping("/listAds")
	public String listAds(Model model){
		
		List<Ads> adsList = adsDAO.list();
		
		model.addAttribute("adsList", adsList);
		
		return "ads/list_ads";
	}
	
	@RequestMapping("/listAdsUser")
	public String listAdsUser(Model model){
		
		List<Ads> adsList = adsDAO.list();
		
		model.addAttribute("adsList", adsList);
		
		return "ads/list_ads_user";
	}
	
	@RequestMapping("/updateAdsForm")
	public String updateAdsForm(Long id, Model model){
		
		Ads ads = adsDAO.recover(id);
		model.addAttribute(ads);
		
		return "ads/update_ads_form";
	}
	
	@RequestMapping("/updateAds")
	public String updateAds(Ads ads, HttpSession session){
		
		ads.setUser(((User) session.getAttribute("user_logged_editor")));
		adsDAO.update(ads);
		
		return "redirect:listAds";
	}
	
	@RequestMapping("/showAdsForm")
	public String showAdsForm(Long id, Model model) {
		Ads ads = adsDAO.recover(id);
		if (ads != null) {
			model.addAttribute(ads);
			return "ads/show_ads_form";
		}
		return "criarPaginaDeErro";
	}
	
}
