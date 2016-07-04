package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.ISectionDAO;
import br.ufc.model.News;
import br.ufc.model.Section;

@Repository
public class SectionDAO implements ISectionDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insert(Section section) {
		manager.persist(section);
	}

	@Override
	public void remove(Long id) {

		Section section = this.recover(id);
		if (section != null) {
			manager.remove(section);

		}
	}

	@Override
	public Section recover(Long id) {

		Section section = manager.find(Section.class, id);
		return section;
	}

	@Override
	public void update(Section section) {

		if (section != null) {
			manager.merge(section);
		}
	}

	@Override
	public List<Section> list() {
		return manager.createQuery("select s from secao as s", Section.class).getResultList();
	}

	@Override
	public List<News> listNews(Long id){
		
		Section section = recover(id);
		if(section != null){
			return section.getNews();
		}
		return null;
	}
}
