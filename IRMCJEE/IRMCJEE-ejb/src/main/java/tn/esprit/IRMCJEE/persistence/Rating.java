package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rating
 *
 */
@Entity

public class Rating implements Serializable {

	@EmbeddedId
	private RatingPk ratingPk;
	@ManyToOne
	@JoinColumn(name = "idsearcher", referencedColumnName = "id", insertable = false, updatable = false)
	private Researcher user;
	@ManyToOne
	@JoinColumn(name = "idPost", referencedColumnName = "idPost", insertable = false, updatable = false)
	private Post post;
	private Integer value;
	@Temporal(TemporalType.TIMESTAMP)
	private Date daterating;

	public Date getDaterating() {
		return daterating;
	}

	public void setDaterating(Date daterating) {
		this.daterating = daterating;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public RatingPk getRatingPk() {
		return ratingPk;
	}

	public void setRatingPk(RatingPk ratingPk) {
		this.ratingPk = ratingPk;
	}

	private static final long serialVersionUID = 1L;

	public Rating() {
		super();
	}

	public Researcher getUser() {
		return user;
	}

	public void setUser(Researcher user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
