package es.upm.dit.apsv.webLab.dao;

import es.upm.dit.apsv.webLab.dao.model.Publication;

public interface PublicationDAO {
	
	public Publication create(Publication publication);
	public Publication read(Publication publication);
	public Publication update(Publication publication);
	public Publication delete(Publication publication);

}
