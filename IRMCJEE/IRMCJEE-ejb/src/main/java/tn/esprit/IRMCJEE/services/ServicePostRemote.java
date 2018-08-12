package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.IRMCJEE.persistence.Post;

@Remote
public interface ServicePostRemote {

	public void addPost(Post p);

	public void updatePost(Post p);

	public void deletePost(long id);

	public Post findById(long id);

	public List<Post> getListPostByUser(int id);

	public List<Post> archiverPost();

	public List<Post> getNonArchivedPosts();

	public List<Post> getMostRatedPosts();
	
	public double getAverageRating(long postid);

}
