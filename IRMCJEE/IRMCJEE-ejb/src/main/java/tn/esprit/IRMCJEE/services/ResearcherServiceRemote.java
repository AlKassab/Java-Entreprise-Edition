package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.IRMCJEE.persistence.Researcher;
@Remote
public interface ResearcherServiceRemote {
	Researcher CreateResearcher(Researcher u);
	void UpdateResearcher(Researcher u);
	void DeleteResearcher(int id);
	Researcher FindResearcherById(int id);
	Researcher FindUserByResearchername(String username);
	List<Researcher> GetAllResearchers();
	boolean loginCheck(String UserName , String Password);
}
