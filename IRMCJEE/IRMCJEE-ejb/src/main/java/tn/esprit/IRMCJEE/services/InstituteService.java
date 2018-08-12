package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.IRMCJEE.persistence.Institute;

@Stateless

public class InstituteService implements InstituteServiceRemote,InstituteServiceLocal{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Institute addInstitute(Institute ins) {
		// TODO Auto-generated method stub
		 em.persist(ins);
		
		return ins;
	}

	

	@Override
	public void updateInstitute(Institute ins) {
		// TODO Auto-generated method stub
		em.merge(ins);
		
	}

	@Override
	public Institute findInstituteById(int id) {
		// TODO Auto-generated method stub
		Institute ins = em.find(Institute.class, id);
		return ins;
	}

	@Override
	public Institute FindInstituterByName(String name) {
		// TODO Auto-generated method stub
		Institute ins = em.find(Institute.class, name);
		return ins;
	}

	@Override
	public List<Institute> getAllInstitutes() {
		// TODO Auto-generated method stub
		return (em.createQuery("SELECT i FROM Institute i")).getResultList();
	}



	@Override
	public void deleteInstitute(int id) {
		// TODO Auto-generated method stub
		Institute ins = em.find(Institute.class, id);
		em.remove(ins);
		
	}
	
	
	@Override
  	public String nbrMed() {


  		Query req = em.createQuery(
  				"SELECT count(*) from Institute i where i.type='Mediatheque' ");
  		
  			
  			String result =req.getSingleResult().toString();

  			return result;
  	}
	
	@Override
  	public String nbrbib() {


  		Query req = em.createQuery(
  				"SELECT count(*) from Institute i where i.type='Bibliotheque' ");
  		
  			
  			String result =req.getSingleResult().toString();

  			return result;
  	}
	
	
	@Override
  	public String nbrcentre() {


  		Query req = em.createQuery(
  				"SELECT count(*) from Institute i where i.type='CentreDeRecherche' ");
  		
  			
  			String result =req.getSingleResult().toString();

  			return result;
  	}
	
	
	@Override
  	public String nbrarch() {


  		Query req = em.createQuery(
  				"SELECT count(*) from Institute i where i.type='Archives' ");
  		
  			
  			String result =req.getSingleResult().toString();

  			return result;
  	}

}
