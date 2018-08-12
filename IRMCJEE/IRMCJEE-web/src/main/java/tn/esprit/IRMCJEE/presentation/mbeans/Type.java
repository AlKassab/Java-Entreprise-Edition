package tn.esprit.IRMCJEE.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.IRMCJEE.persistence.TypeInst;

@ManagedBean
@ApplicationScoped
public class Type {
	public TypeInst[] getTypeInst(){
		return TypeInst.values();
}
}