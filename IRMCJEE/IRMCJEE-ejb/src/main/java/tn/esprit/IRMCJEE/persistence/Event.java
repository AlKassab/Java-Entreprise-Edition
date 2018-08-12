package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Ev;
	private String title;
	private String description;
	
	public Event() {
		super();
	}
	public Event(int id_Ev, String title, String description, CategoryEvent cat, Date creationDate, Date startDate,
			Date endDate, int capacity, User user, Set<TicketEvent> tickets) {
		super();
		this.id_Ev = id_Ev;
		this.title = title;
		this.description = description;
		this.cat = cat;
		this.creationDate = creationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.capacity = capacity;
		this.user = user;
		this.tickets = tickets;
	}
	
	public Event(String title, String description, CategoryEvent cat, Date creationDate, Date startDate, Date endDate,
			int capacity) {
		super();
		this.title = title;
		this.description = description;
		this.cat = cat;
		this.creationDate = creationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.capacity = capacity;
	}

	@Enumerated(EnumType.STRING)
	private CategoryEvent cat;
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private int capacity;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	

	public CategoryEvent getCat() {
		return cat;
	}
	public void setCat(CategoryEvent cat) {
		this.cat = cat;
	}
	@OneToMany(mappedBy="event",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<TicketEvent> tickets;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
  
	@Override
	public String toString() {
		return "Event [id_Ev=" + id_Ev + ", title=" + title + ", description=" + description + ", cat=" + cat
				+ ", creationDate=" + creationDate + ", startDate=" + startDate + ", endDate=" + endDate + ", capacity="
				+ capacity + ", user=" + user + ", tickets=" + tickets + "]";
	}
	public int getId_Ev() {
		return this.id_Ev;
	}

	public void setId_Ev(int id_Ev) {
		this.id_Ev = id_Ev;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Event(int id_Ev, String title, String description, CategoryEvent cat, Date creationDate, Date startDate,
			Date endDate, int capacity) {
		super();
		this.id_Ev = id_Ev;
		this.title = title;
		this.description = description;
		this.cat = cat;
		this.creationDate = creationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.capacity = capacity;
	}

   
}
