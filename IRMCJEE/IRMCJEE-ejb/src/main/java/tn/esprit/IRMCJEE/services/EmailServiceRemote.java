package tn.esprit.IRMCJEE.services;

import javax.ejb.Remote;

@Remote
public interface EmailServiceRemote {
	
	boolean sendEmail(String email);
}
