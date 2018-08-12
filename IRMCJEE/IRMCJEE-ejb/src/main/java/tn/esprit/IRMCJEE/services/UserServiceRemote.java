package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.IRMCJEE.persistence.User;
@Remote
public interface UserServiceRemote {
	public User addUser(User u);
	
	public List<User> getAllUsers();
	
	public void deleteUser(int id);
	
	public void UpdateUser(User u);
	
	public User FindUserById(int i);
	
	public User FindUserByUsername(String username);
	
	User loginCheck(String UserName , String Password);
}
