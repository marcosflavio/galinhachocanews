package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.IRoleDAO;
import br.ufc.model.Role;

@Repository
public class RoleDAO implements IRoleDAO {

	@PersistenceContext
	EntityManager manager;

	@Override
	public void insert(Role role) {

		manager.persist(role);
	}

	@Override
	public void remove(Long id) {
		Role rl = recover(id);

		if (rl != null) {
			manager.remove(rl);
		}
	}

	@Override
	public Role recover(Long id) {

		return manager.find(Role.class, id);

	}

	@Override
	public void update(Role role) {

		manager.merge(role);

	}

	@Override
	public List<Role> list() {
		//papel é o nome da entity que declarei!!
		return manager.createQuery("select r from papel as r", Role.class).getResultList();
	}
	
}
