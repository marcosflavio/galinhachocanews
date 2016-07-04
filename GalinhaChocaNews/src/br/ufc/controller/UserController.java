package br.ufc.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.interfaces.IRoleDAO;
import br.ufc.interfaces.IUserDAO;
import br.ufc.model.Role;
import br.ufc.model.User;
import br.ufc.util.FileUtil;

@Transactional
@Controller
public class UserController {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	@Qualifier(value = "userDAO")
	private IUserDAO userDAO;

	@Autowired
	@Qualifier(value = "roleDAO")
	private IRoleDAO roleDAO;

	@RequestMapping("/insertUserForm")
	public String insertUserForm() {

		return "user/insert_user_form";
	}

	@RequestMapping(value ="/insertUser", method = RequestMethod.POST)
	public String insertUser(User user, @RequestParam(value="imagem", required=false) MultipartFile imagem) {

		Long idAux = user.getRoleAux();

		Role role = roleDAO.recover(idAux);

		user.setRole(role);

		String path = servletContext.getRealPath("/")+"resources/images/"+user.getLogin()+".png";
		FileUtil.salvarImagem(path, imagem);
		
		userDAO.insert(user);

		return "user/insert_user_ok";
	}

	@RequestMapping("/updateUserForm")
	public String updateUserForm(Long id, Model model) {

		User user = userDAO.recover(id);
		model.addAttribute(user);

		return "user/update_user_form";

	}

	@RequestMapping("/updateUser")
	public String updateUser(User user) {

		Long idAux = user.getRoleAux();

		Role role = roleDAO.recover(idAux);

		user.setRole(role);

		userDAO.update(user);
		return "user/update_user_ok";

	}

	@RequestMapping("/removeUser")
	public String removeUser(Long id) {

		userDAO.remove(id);
		return "user/remove_user_ok";
	}

	@RequestMapping("/listUser")
	public String listUser(Model model) {
		List<User> users = userDAO.list();

		model.addAttribute("users", users);
		return "user/list_user";
	}

	@RequestMapping("/showUserForm")
	public String showUserForm(Long id, Model model) {
		// Pelo nome??

		User user = userDAO.recover(id);
		System.out.println(user.getName());
		if (user != null) {
			model.addAttribute(user);
			return "user/show_user_form";
		}
		return "criarPaginaDeErro";
	}

	@RequestMapping("/showUser")
	public String showUser() {

		return "user/show_user";
	}

}
