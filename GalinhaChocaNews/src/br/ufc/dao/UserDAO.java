package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.IUserDAO;
import br.ufc.model.User;

@Repository
public class UserDAO implements IUserDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insert(User user) {

		manager.persist(user);
	}

	@Override
	public void remove(Long id) {

		User user = recover(id);

		if (user != null) {
			manager.remove(user);
		}

	}

	@Override
	public User recover(Long id) {

		return manager.find(User.class, id);

	}

	@Override
	public void update(User user) {

		if (user != null)
			manager.merge(user);

	}

	@Override
	public List<User> list() {
		return manager.createQuery("select u from usuario as u", User.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User recover(String login) {
		String hql = "select u from usuario as u "
				+ "where u.login = :param_login";
		Query query = manager.createQuery(hql);
		List<User> users = query.setParameter("param_login", login).getResultList();
		if (!users.isEmpty())
			return users.get(0);
		return null;
	}


}
