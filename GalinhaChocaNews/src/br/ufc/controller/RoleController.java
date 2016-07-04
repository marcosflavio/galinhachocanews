package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.interfaces.IRoleDAO;
import br.ufc.model.Role;
import br.ufc.model.User;

@Transactional
@Controller
public class RoleController {

	@Autowired
	@Qualifier(value = "roleDAO")
	private IRoleDAO roleDAO;

	@RequestMapping("/insertRoleForm")
	public String inserRoleForm() {

		return "role/insert_role_form";
	}

	
	
	@RequestMapping("/insertRole")
	public String insertRole(Role role, HttpSession sessao) {
		roleDAO.insert(role);

		System.out.println(((User)(sessao.getAttribute("user_logged_editor"))).getName());
		return "role/insert_role_ok";
	}

	@RequestMapping("/removeRole")
	public String removeRole(Long id) {

		Role rf = roleDAO.recover(id);

		roleDAO.remove(rf.getId());

		return "redirect:listRole";
	}

	@RequestMapping("/updateRoleForm")
	public String updateRoleForm(Long id, Model model) {
		Role role = roleDAO.recover(id);
		model.addAttribute(role);
		return "role/update_role_form";
	}

	@RequestMapping("/updateRole")
	public String updateRole(Role role) {
		roleDAO.update(role);

		return "redirect:listRole";
	}

	@RequestMapping("/listRole")
	public String listRole(Model model) {

		List<Role> roles = this.roleDAO.list();
		model.addAttribute("roles", roles);
		return "role/list_role";
	}

}
