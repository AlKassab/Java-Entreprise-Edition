package tn.esprit.IRMCJEE.services;


import java.util.List;

import javax.ejb.Local;

import tn.esprit.IRMCJEE.persistence.Event;



@Local
public interface EventServiceLocal {
	Event createEvent(Event event);
	List<Event> readEvent();
	void updateEvent(Event event);
	void deleteEvent(int id);
	Event findById(int id);
	boolean FindEventExist(int id);
	List<Event> findByTerm(String term);
  // User findUserbyid(int id);
}
