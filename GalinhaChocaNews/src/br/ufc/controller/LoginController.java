package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.IUserDAO;
import br.ufc.model.User;

@Transactional
@Controller
public class LoginController {

	@Autowired
	@Qualifier(value = "userDAO")
	private IUserDAO userDAO;
	
	@RequestMapping("/loginForm")
	public String loginForm() {

		return "login_form";
	}
	
	

	@RequestMapping("/tentativaLogin")
	public String tentativaLogin(User user, HttpSession session) {
		User candidato = userDAO.recover(user.getLogin());
		System.out.println(candidato == null);
		if ((candidato != null)) {
			System.out.println(candidato.getPassword() + "        " + user.getPassword());
			
			if (candidato.getPassword().equals(user.getPassword())) {
				System.out.println("Entrei");
				
				if (candidato.getRole().getRole().equals("Editor")) {
					session.setAttribute("user_logged_editor", candidato);

				} else if (candidato.getRole().getRole().equalsIgnoreCase("Jornalista")) {
					session.setAttribute("user_logged_journalist", candidato);
				} else if (candidato.getRole().getRole().equals("Administrador")) {
					session.setAttribute("user_logged_adm", candidato);
				}

				System.out.println("PorrinhaQualqur");
				return "redirect:login";
			}

		}

		return "redirect:loginForm"; // Redireciona pro outro método
	}

	@RequestMapping("/login")
	public String login(HttpSession session) {

		if (session.getAttribute("user_logged_journalist") != null) {
			return "home2";

		} else if (session.getAttribute("user_logged_editor") != null) {
			return "home";

		} else if (session.getAttribute("user_logged_adm") != null) {
			return "home";
		} else {
			return "redirect:loginForm";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // apaga a sessão

		return "redirect:loginForm";
	}
}
