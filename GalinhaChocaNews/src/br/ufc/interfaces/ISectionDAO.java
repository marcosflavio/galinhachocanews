package br.ufc.interfaces;

import java.util.List;

import br.ufc.model.News;
import br.ufc.model.Section;


public interface ISectionDAO {
	
	public void insert(Section section);
	public void remove(Long id);
	public Section recover(Long id);
	public void update(Section section);
	public List<Section> list();
	public List<News> listNews(Long id);

}
