package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Announcement
 *
 */
@Entity

public class Announcement implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_An;
	private Date startDate;
	private Date endDate;
	private float funding;
	private CategoryAnnouncement cat;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy ="annoucement",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Application> applications;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CategoryAnnouncement getCat() {
		return cat;
	}
	public void setCat(CategoryAnnouncement cat) {
		this.cat = cat;
	}

	private static final long serialVersionUID = 1L;

	public Announcement() {
		super();
	}   
	public int getId_An() {
		return this.id_An;
	}

	public void setId_An(int id_An) {
		this.id_An = id_An;
	}   
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}   
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}   
	public float getFunding() {
		return this.funding;
	}

	public void setFunding(float funding) {
		this.funding = funding;
	}
   
}
