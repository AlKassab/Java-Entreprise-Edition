package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TicketEvent
 *
 */
@Entity

public class TicketEvent implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Ticket;
	private String title;
	private String note;
	private Date orderDate;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Event event ;
	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public TicketEvent() {
		super();
	}   
	public int getId_Ticket() {
		return this.id_Ticket;
	}

	public void setId_Ticket(int id_Ticket) {
		this.id_Ticket = id_Ticket;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}   
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
   
}
