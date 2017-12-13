package es.upm.dit.apsv.webLab.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import es.upm.dit.apsv.webLab.dao.model.Researcher;
import java.util.logging.Logger;
import java.util.logging.Level;


public class ResearcherDAOImpl implements ResearcherDAO {
	
	private static ResearcherDAOImpl instance;
	private static final Logger logger = Logger.getLogger("ResearcherDAOImpl");
	
	private ResearcherDAOImpl() {}
	
	public static ResearcherDAOImpl getInstance() {
		if(instance == null)
			instance = new ResearcherDAOImpl();
		return instance;
	}

	@Override
	public Researcher create(Researcher u) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
		} catch(Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return u;
	}
	
	@Override
	public Researcher read(Researcher r) {
		Session session = SessionFactoryService.get().openSession();
		Researcher res = null;
		//Link pagina explicacion queries hibernate
		//http://cursohibernate.es/doku.php?id=unidades:05_hibernate_query_language:02_hql
		try {
			res = (Researcher) session
					.createQuery("select r from Researcher r where r.id = :id")
					.setParameter("id", r.getId())
					.uniqueResult();
			
			
			System.out.println("La query es: "+ res);
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public Researcher update(Researcher r) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(r);
			session.getTransaction().commit();
		} catch(Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return r;
	}

	 @Override
	public Researcher delete(Researcher r) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(r);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return r;
	}
	
	@Override
	public List<Researcher> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<Researcher> res = new ArrayList<>();
		try {
			res.addAll(session.createQuery("select r from Researcher r")
					.getResultList());
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return res;

	}
	
	public Researcher readName(Researcher r) {
		Session session = SessionFactoryService.get().openSession();
		Researcher researcher = null;
		try {
			researcher = (Researcher) session
					.createQuery("select r from Researcher r where r.name = :name and r.password = :pwd")
					.setParameter("name", r.getName())
					.setParameter("pwd", r.getPassword())
					.uniqueResult();
			
		} catch (Exception e) {
			throw e;
			//logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return researcher;
	}


}
