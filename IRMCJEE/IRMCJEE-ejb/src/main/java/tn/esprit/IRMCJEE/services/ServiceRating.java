package tn.esprit.IRMCJEE.services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.IRMCJEE.persistence.Post;
import tn.esprit.IRMCJEE.persistence.Rating;
import tn.esprit.IRMCJEE.persistence.RatingPk;
import tn.esprit.IRMCJEE.persistence.Researcher;

/**
 * Session Bean implementation class ServiceRating
 */
@Stateless
public class ServiceRating implements ServiceRatingRemote, ServiceRatingLocal {

	@PersistenceContext
	private EntityManager em;
	@EJB
	private ResearcherServiceLocal rs;
	@EJB
	private ServicePostLocal servicePostLocal;

	/**
	 * Default constructor.
	 */
	public ServiceRating() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addRating(int researcherid, long idpost, Integer value) {
		// TODO Auto-generated method stub
		Rating rating = new Rating();
		Post post = new Post();
		Researcher researcher = new Researcher();
		rating = findRatingByResearcherPost(idpost, researcherid);
		if (rating != null) {
			rating.setValue(value);
			rating.setDaterating(new Date());
			em.merge(rating);
		} else {
			post = servicePostLocal.findById(idpost);
			researcher = rs.FindResearcherById(researcherid);
			Rating r = new Rating();
			RatingPk ratingPk = new RatingPk();
			ratingPk.setIdPost(idpost);
			ratingPk.setIdsearcher(researcherid);
			r.setRatingPk(ratingPk);
			r.setValue(value);
			r.setUser(researcher);
			r.setPost(post);
			r.setDaterating(new Date());
			em.persist(r);
		}
	}

	@Override
	public Rating findRatingByResearcherPost(long idpost, int id) {
		// TODO Auto-generated method stub
		Rating r = null;
		TypedQuery<Rating> query = em
				.createQuery("SELECT r FROM Rating r WHERE r.user.id = :i AND r.post.idPost = :p", Rating.class)
				.setParameter("i", id).setParameter("p", idpost);
		try {
			r = query.getSingleResult();
			return r;
		} catch (NoResultException e) {
			// TODO: handle exception
			System.out.println("NOT FOUND");
		}
		return null;
	}

}
