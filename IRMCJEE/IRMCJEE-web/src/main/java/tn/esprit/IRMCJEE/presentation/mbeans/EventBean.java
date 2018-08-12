package tn.esprit.IRMCJEE.presentation.mbeans;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import tn.esprit.IRMCJEE.persistence.CategoryEvent;
import tn.esprit.IRMCJEE.persistence.Event;
import tn.esprit.IRMCJEE.services.EventService;

@ManagedBean
@RequestScoped
public class EventBean {
@EJB
EventService es;
private int id_Ev;
private String title;
private String description;
private Date creationDate;
private Date startDate;
private Date endDate;
private int capacity;
private CategoryEvent cat;
private int idUser;
private List<Event> commentaires;





public int getIdUser() {
	return idUser;
}


public void setIdUser(int idUser) {
	this.idUser = idUser;
}


public List<Event> getCommentaires() {
	return commentaires;
}


public void setCommentaires(List<Event> commentaires) {
	this.commentaires = commentaires;
}


public void ajouterContrat() throws ParseException{
	 
	 Event contrat = new Event(title,description,cat,creationDate,startDate,endDate,capacity);
	
	 //User  user=commentService.findUserbyid(3);
	 //contrat.setUser(selectedEmploye);
	// employeService.AddProjet(contrat);
	 es.createEvent(contrat);
	 
}


	public int getId_Ev() {
	return id_Ev;
}



public void setId_Ev(int id_Ev) {
	this.id_Ev = id_Ev;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public Date getCreationDate() {
	return creationDate;
}



public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}



public Date getStartDate() {
	return startDate;
}



public void setStartDate(Date startDate) {
	this.startDate = startDate;
}



public Date getEndDate() {
	return endDate;
}



public void setEndDate(Date endDate) {
	this.endDate = endDate;
}



public int getCapacity() {
	return capacity;
}



public void setCapacity(int capacity) {
	this.capacity = capacity;
}



public CategoryEvent getCat() {
	return cat;
}



public void setCat(CategoryEvent cat) {
	this.cat = cat;
}



	public EventBean() {
		// TODO Auto-generated constructor stub
	}

}
