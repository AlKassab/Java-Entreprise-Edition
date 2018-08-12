package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.IRMCJEE.persistence.Event;

/**
 * Session Bean implementation class EventService
 */
@Stateless
@LocalBean
public class EventService implements EventServiceLocal, EventServiceRemote {

  
	
	@PersistenceContext
	private EntityManager em;
	
	private Event event = new Event();
	private List<Event> listeEvent;
    public EventService() {
       
    }

	@Override
	public Event  createEvent(Event event) {
		em.persist(event);
		em.flush();
		return event;
		}

	@Override
	public List<Event> readEvent() {
		return (em.createQuery("SELECT e FROM Event e")).getResultList();
	}

	@Override
	public void updateEvent(Event event) {
		em.merge(event);
		
	}

	@Override
	public void deleteEvent(int id) {
		Event event = em.find(Event.class, id);
		em.remove(event);
		
	}

	@Override
	public Event findById(int id) {
		return em.find(Event.class, id);
	}

	@Override
	public boolean FindEventExist(int id) {
		if(em.find(Event.class, id)!=null)
			return true;		
			return false;
	}

	@Override
	public List<Event> findByTerm(String term) {
		return em.createQuery("SELECT e FROM Event e WHERE"
				+ " (e.description LIKE CONCAT('%',:term,'%') OR e.title LIKE CONCAT('%',:term,'%') )")
				.setParameter("term", term).getResultList();
	}
	 
//	 public User findUserbyid(int id){
//		 User u=em.find(User.class, id);
//	    	return u;
//	    	
//	    }

}
