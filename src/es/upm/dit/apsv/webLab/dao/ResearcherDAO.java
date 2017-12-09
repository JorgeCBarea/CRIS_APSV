package es.upm.dit.apsv.webLab.dao;

import java.util.List;

import es.upm.dit.apsv.webLab.dao.model.Researcher;

public interface ResearcherDAO {
	
	public Researcher create(Researcher research);
	public Researcher read(Researcher research);
	public Researcher update (Researcher researcher);
	public Researcher delete(Researcher researcher);
	public List<Researcher> readAll();


}
