package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.IRMCJEE.persistence.Institute;



@Local
public interface InstituteServiceLocal {
	
	public Institute addInstitute(Institute ins);
	public void deleteInstitute(int id);
	public void updateInstitute(Institute ins);
	public Institute findInstituteById(int id);
	public Institute FindInstituterByName(String name);
	public List<Institute> getAllInstitutes();
	public String nbrMed();
	public String nbrbib();
	public String nbrcentre();
	public String nbrarch();


}
