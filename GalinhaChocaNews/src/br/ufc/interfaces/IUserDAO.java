package br.ufc.interfaces;

import java.util.List;
import br.ufc.model.User;


public interface IUserDAO {
	
	public void insert(User user);
	public void remove(Long id);
	public User recover(Long id);
	public void update(User user);
	public List<User> list();
	public User recover(String login);
}
