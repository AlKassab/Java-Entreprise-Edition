package tn.esprit.IRMCJEE.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.IRMCJEE.persistence.Follow;
import tn.esprit.IRMCJEE.persistence.FollowPk;
import tn.esprit.IRMCJEE.persistence.Researcher;
import tn.esprit.IRMCJEE.persistence.User;
@Stateless
public class FollowService implements FollowServiceLocal,FollowServiceRemote
{
	@PersistenceContext
	EntityManager em;
	@Override
	public void follow(int researcherId, int userId) {
		// TODO Auto-generated method stub
		if(findFollow(userId, researcherId) == null) {
			Follow f = new Follow();
			f.setResearcher(em.find(Researcher.class, researcherId));
			f.setUser(em.find(User.class, userId));
			f.setFollowDate(new Date());
			FollowPk fk = new FollowPk();
			fk.setResearcherId(researcherId);
			fk.setUserId(userId);
			f.setFollowPk(fk);
			em.persist(f);
		}
	}

	@Override
	public void unfollow(int researcherId, int userId) {
		// TODO Auto-generated method stub
		em.remove(findFollow(userId, researcherId));
	}

	@Override
	public long countFollowers(int researcherId) {
		return (long) (em.createQuery("SELECT count(*) FROM Follow f WHERE f.researcher.id = :researcherId")
				.setParameter("researcherId", researcherId)).getSingleResult();
	}

	@Override
	public long countFollowings(int userId) {
		return  (long) (em.createQuery("SELECT count(*) FROM Follow f WHERE f.user.id = :userId")
				.setParameter("userId", userId)).getSingleResult();
	}

	@Override
	public List<User> getFollowers(int researcherId) {
		return (List<User>) (em.createQuery("SELECT f.user FROM Follow f WHERE f.researcher.id = :researcherId")
				.setParameter("researcherId", researcherId)).getResultList();
	}

	@Override
	public List<Researcher> getFollowings(int userId) {
		return (List<Researcher>) (em.createQuery("SELECT f.artist FROM Follow f WHERE f.user.id = :userId")
				.setParameter("userId", userId)).getResultList();
	}

	@Override
	public Follow findFollow(int userId, int researcherId) {
		List<Follow> f =(em.createQuery("SELECT f FROM Follow f WHERE f.user.id = :userId AND f.researcher.id = :researcherId")
				.setParameter("researcherId", researcherId)
				.setParameter("userId", userId)).getResultList();
		if(f.isEmpty()){
			return null;
		}else
			return (f.get(0));
	}

}
