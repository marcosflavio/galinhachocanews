package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Role;

public interface IRoleDAO {

	public void insert(Role role);

	public void remove(Long id);

	public Role recover(Long id);

	public void update(Role role);

	public List<Role> list();

}
