package tn.esprit.IRMCJEE.services;

import javax.ejb.Local;

import tn.esprit.IRMCJEE.persistence.Rating;

@Local
public interface ServiceRatingLocal {

	public void addRating(int researcherid, long idpost, Integer value);

	public Rating findRatingByResearcherPost(long idpost, int id);
}
