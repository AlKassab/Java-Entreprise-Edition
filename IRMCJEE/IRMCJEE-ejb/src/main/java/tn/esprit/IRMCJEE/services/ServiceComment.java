package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.IRMCJEE.persistence.Comment;

/**
 * Session Bean implementation class ServiceComment
 */
@Stateless
public class ServiceComment implements ServiceCommentRemote, ServiceCommentLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ServiceComment() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public List<Comment> getListCommentByIdPost(long id) {
		// TODO Auto-generated method stub
		TypedQuery<Comment> lQuery = em.createQuery("SELECT c FROM Comment c WHERE c.post.idPost = :i", Comment.class)
				.setParameter("i", id);
		try {

			return lQuery.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exceptio
			System.out.println("no results");
		}
		return null;
	}

	@Override
	public List<Comment> getListCommentByIdResearcher(int id) {
		// TODO Auto-generated method stub
		TypedQuery<Comment> lQuery = em.createQuery("SELECT c FROM Comment c WHERE c.user.id = :i", Comment.class)
				.setParameter("i", id);
		try {

			return lQuery.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exceptio
			System.out.println("no results");
		}
		return null;
	}

	@Override
	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		em.persist(c);

	}

	@Override
	public void updateComment(Comment c) {
		// TODO Auto-generated method stub
		em.merge(c);

	}

	@Override
	public void deleteComment(long id) {
		// TODO Auto-generated method stub
		em.remove(findById(id));

	}

	@Override
	public Comment findById(long id) {
		// TODO Auto-generated method stub
		return em.find(Comment.class, id);
	}

}
