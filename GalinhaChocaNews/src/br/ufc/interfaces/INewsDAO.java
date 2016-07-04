package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.News;


public interface INewsDAO {

	public void insert(News news);

	public void remove(Long id);

	public News recover(Long id);

	public void update(News news);

	public List<News> list();

}
