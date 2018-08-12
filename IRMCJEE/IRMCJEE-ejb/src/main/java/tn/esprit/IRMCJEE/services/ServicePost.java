package tn.esprit.IRMCJEE.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.IRMCJEE.persistence.Post;

/**
 * Session Bean implementation class ServicePost
 */
@Stateless
public class ServicePost implements ServicePostRemote, ServicePostLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ServicePost() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void addPost(Post p) {
		p.setDatepub(new Date());
		em.persist(p);
	}

	@Override
	public List<Post> getListPostByUser(int id) {
		// TODO Auto-generated method stub
		TypedQuery<Post> lQuery = em.createQuery("SELECT p FROM Post p WHERE p.user.id = :id", Post.class)
				.setParameter("id", id);
		try {
			return lQuery.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("NO RESULT");
		}
		return null;
	}

	@Override
	public void updatePost(Post p) {
		// TODO Auto-generated method stub
		p.setDatepub(new Date());
		em.merge(p);
	}

	@Override
	public void deletePost(long id) {
		// TODO Auto-generated method stub
		em.remove(findById(id));
	}

	@Override
	public Post findById(long id) {
		// TODO Auto-generated method stub
		return em.find(Post.class, id);
	}

	@Override
	public List<Post> archiverPost() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT p FROM Post p WHERE p.state = 1");
		try {
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			System.out.println("NOT FOUND");
		}
		return null;

	}

	@Override
	public List<Post> getNonArchivedPosts() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT p FROM Post p WHERE p.state = 0 ORDER BY p.datepub DESC");
		try {
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			System.out.println("NOT FOUND");
		}
		return null;
	}

	@Override
	public List<Post> getMostRatedPosts() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT p FROM Post p JOIN p.lRatings r WHERE p.state = 0 GROUP BY (p.idPost) ");
		try {

			return q.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			System.out.println("NOT FOUND");
		}
		return null;
	}

	@Override
	public double getAverageRating(long postid) {
		try {
			return (double) (em.createQuery("SELECT AVG(r.value) FROM Rating r WHERE r.post.idPost= :postid ")
					.setParameter("postid", postid)).getSingleResult();
		} catch (Exception e) {
			return 0;
		}
	}

}
