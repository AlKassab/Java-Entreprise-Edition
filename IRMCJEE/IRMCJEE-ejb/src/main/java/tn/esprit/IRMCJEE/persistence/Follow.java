package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;





/**
 * Entity implementation class for Entity: Follow
 *
 */
@Entity

public class Follow implements Serializable {

	@EmbeddedId
	private FollowPk followPk;
	private Date followDate;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="researcherId",referencedColumnName="id",insertable=false,updatable=false)
    private Researcher researcher;
	
	@ManyToOne
	@JoinColumn(name="userId",referencedColumnName="id",insertable=false,updatable=false)
	private User user;
	public Follow() {
		super();
	}
	public FollowPk getFollowPk() {
		return followPk;
	}
	public void setFollowPk(FollowPk followPk) {
		this.followPk = followPk;
	}
	public Date getFollowDate() {
		return followDate;
	}
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}
	public Researcher getResearcher() {
		return researcher;
	}
	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
   
}
