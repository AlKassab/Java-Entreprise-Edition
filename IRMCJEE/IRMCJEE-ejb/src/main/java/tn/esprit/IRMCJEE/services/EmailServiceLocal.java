package tn.esprit.IRMCJEE.services;

import javax.ejb.Local;

@Local
public interface EmailServiceLocal {
	
	boolean sendEmail(String email);
}
