package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity

public class Post implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPost;
	private String object;
	private int state;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date datepub = new Date();
	@OneToMany(mappedBy = "post")
	private List<Comment> lsComments;
	@ManyToOne(cascade = { CascadeType.MERGE })
	private Researcher user;
	@OneToMany(mappedBy = "post")
	private List<Rating> lRatings;

	public Date getDatepub() {
		return datepub;
	}

	public void setDatepub(Date datepub) {
		this.datepub = datepub;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Rating> getlRatings() {
		return lRatings;
	}

	public void setlRatings(List<Rating> lRatings) {
		this.lRatings = lRatings;
	}

	public Researcher getUser() {
		return user;
	}

	public void setUser(Researcher user) {
		this.user = user;
	}

	public List<Comment> getLsComments() {
		return lsComments;
	}

	public void setLsComments(List<Comment> lsComments) {
		this.lsComments = lsComments;
	}

	public long getIdPost() {
		return idPost;
	}

	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	}

}
