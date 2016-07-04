package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.interfaces.IAdsDAO;
import br.ufc.model.Ads;

@Repository
public class AdsDAO implements IAdsDAO {

	@PersistenceContext
	EntityManager manager;

	@Override
	public void insert(Ads ads) {

		manager.persist(ads);

	}

	@Override
	public void remove(Long id) {
		Ads ads = recover(id);
		if (ads != null) {
			manager.remove(ads);

		}

	}

	@Override
	public Ads recover(Long id) {

		Ads ads = manager.find(Ads.class, id);

		return ads;
	}

	@Override
	public void update(Ads ads) {

		manager.merge(ads);

	}

	@Override
	public List<Ads> list() {
		return manager.createQuery("select a from classificados as a", Ads.class).getResultList();
	}

}
