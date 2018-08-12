package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.IRMCJEE.persistence.Post;

@Local
public interface ServicePostLocal {

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
