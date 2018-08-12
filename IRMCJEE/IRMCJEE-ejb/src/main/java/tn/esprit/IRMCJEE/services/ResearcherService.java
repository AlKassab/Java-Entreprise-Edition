package tn.esprit.IRMCJEE.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.IRMCJEE.persistence.Researcher;
@Stateless
public class ResearcherService implements ResearcherServiceLocal, ResearcherServiceRemote {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Researcher CreateResearcher(Researcher u) {
		// TODO Auto-generated method stub
		u.setPassword(MD5It(u.getPassword()));
		em.persist(u);
		em.flush();
		return u;
	}

	@Override
	public void UpdateResearcher(Researcher u) {
		// TODO Auto-generated method stub
		if(u.getPassword() != null){
			u.setPassword(UserService.MD5It(u.getPassword()));
		}
		else {
			u.setPassword(FindResearcherById(u.getId()).getPassword());
		}
		em.merge(u);
	}

	@Override
	public void DeleteResearcher(int id) {
		// TODO Auto-generated method stub
		Researcher researcher = em.find(Researcher.class, id);
		em.remove(researcher);
	}

	@Override
	public Researcher FindResearcherById(int id) {
		// TODO Auto-generated method stub
		Researcher researcher = em.find(Researcher.class, id);
		return researcher;
	}

	@Override
	public Researcher FindUserByResearchername(String username) {
		// TODO Auto-generated method stub
		List<Researcher> lu = (em.createQuery("SELECT u FROM User u WHERE u.userName = :UName")
				.setParameter("UName", username)).getResultList(); 
		if (lu.isEmpty() ) {
			return null;	
		}
		return lu.get(0);
	}

	@Override
	public List<Researcher> GetAllResearchers() {
		// TODO Auto-generated method stub
		return (em.createQuery("SELECT u FROM User u WHERE role='Researcher'")).getResultList();
	}

	@Override
	public boolean loginCheck(String UserName, String Password) {
		// TODO Auto-generated method stub
		return false;
	}
	public static String MD5It(String pass) {
		String generatedPassword = "";
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest

			md.update(pass.getBytes(), 0, pass.length());
			generatedPassword = new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

}
