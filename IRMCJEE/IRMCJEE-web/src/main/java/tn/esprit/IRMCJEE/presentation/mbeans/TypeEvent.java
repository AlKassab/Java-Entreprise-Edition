package tn.esprit.IRMCJEE.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.IRMCJEE.persistence.CategoryEvent;



@ManagedBean
@ApplicationScoped
public class TypeEvent {
	public CategoryEvent[] getCategoryEvent(){
		return CategoryEvent.values();
}
}
