package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.INewsDAO;
import br.ufc.model.News;

@Repository
public class NewsDAO implements INewsDAO {

	@PersistenceContext
	EntityManager manager;

	@Override
	public void insert(News news) {

		manager.persist(news);
	}

	@Override
	public void remove(Long id) {

		News news = recover(id);
		if (news != null) {
			manager.remove(news);
		}
	}

	@Override
	public News recover(Long id) {
		News news = manager.find(News.class, id);

		return news;
	}

	@Override
	public void update(News news) {

		manager.merge(news);

	}

	@Override
	public List<News> list() {
		return manager.createQuery("select n from noticia as n", News.class).getResultList();
	}

}
