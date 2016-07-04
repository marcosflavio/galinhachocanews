package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.Ads;

public interface IAdsDAO {

	public void insert(Ads ads);

	public void remove(Long id);

	public Ads recover(Long id);

	public void update(Ads ads);

	public List<Ads> list();

}
