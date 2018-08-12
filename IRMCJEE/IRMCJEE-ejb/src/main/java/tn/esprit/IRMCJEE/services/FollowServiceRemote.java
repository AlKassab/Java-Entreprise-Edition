package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.IRMCJEE.persistence.Follow;
import tn.esprit.IRMCJEE.persistence.Researcher;
import tn.esprit.IRMCJEE.persistence.User;

@Remote
public interface FollowServiceRemote {
void follow(int researcherId,int userId);
	
	void unfollow(int researcherId,int userId);
	
	long countFollowers(int researcherId);
	
	long countFollowings(int userId);
	
	List<User> getFollowers(int researcherId);
	
	List<Researcher> getFollowings(int userId);
	
	Follow findFollow(int userId, int researcherId);
}
