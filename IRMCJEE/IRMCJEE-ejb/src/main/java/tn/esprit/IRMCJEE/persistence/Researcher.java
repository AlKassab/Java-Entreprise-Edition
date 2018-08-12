package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Researcher
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Researcher")
public class Researcher extends User implements Serializable {
	@OneToMany(mappedBy = "researcher", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Follow> followers;

	@OneToMany(mappedBy = "user")
	private List<Rating> lRatings;
	@OneToMany(mappedBy = "user")
	private List<Post> lPosts;
	@OneToMany(mappedBy = "user")
	private List<Comment> lComments;

	public List<Follow> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follow> followers) {
		this.followers = followers;
	}

	public List<Rating> getlRatings() {
		return lRatings;
	}

	public void setlRatings(List<Rating> lRatings) {
		this.lRatings = lRatings;
	}

	public List<Post> getlPosts() {
		return lPosts;
	}

	public void setlPosts(List<Post> lPosts) {
		this.lPosts = lPosts;
	}

	public List<Comment> getlComments() {
		return lComments;
	}

	public void setlComments(List<Comment> lComments) {
		this.lComments = lComments;
	}

	private static final long serialVersionUID = 1L;

	public Researcher() {
		super();
	}

}
