package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.IRMCJEE.persistence.Event;
@Remote
public interface EventServiceRemote {
	Event createEvent(Event event);
	List<Event> readEvent();
	void updateEvent(Event event);
	void deleteEvent(int id);
	Event findById(int id);
	boolean FindEventExist(int id);
	List<Event> findByTerm(String term);
}
