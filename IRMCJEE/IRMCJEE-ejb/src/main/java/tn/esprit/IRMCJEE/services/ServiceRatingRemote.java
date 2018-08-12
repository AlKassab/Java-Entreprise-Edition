package tn.esprit.IRMCJEE.services;

import javax.ejb.Remote;

import tn.esprit.IRMCJEE.persistence.Rating;

@Remote
public interface ServiceRatingRemote {

	public void addRating(int researcherid, long idpost, Integer value);

	public Rating findRatingByResearcherPost(long idpost, int id);
}
