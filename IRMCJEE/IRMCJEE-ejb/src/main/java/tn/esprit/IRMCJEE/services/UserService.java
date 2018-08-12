package tn.esprit.IRMCJEE.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.IRMCJEE.persistence.User;

@Stateless
public class UserService implements UserServiceLocal, UserServiceRemote {
	@PersistenceContext
	EntityManager em;

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		u.setPassword(MD5It(u.getPassword()));
		em.persist(u);
		em.flush();
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (em.createQuery("SELECT u FROM User u")).getResultList();
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);
		em.remove(user);
	}

	@Override
	public void UpdateUser(User u) {
		// TODO Auto-generated method stub
		if (u.getPassword() != null) {
			u.setPassword(UserService.MD5It(u.getPassword()));
		} else {
			u.setPassword(FindUserById(u.getId()).getPassword());
		}
		em.merge(u);

	}

	@Override
	public User FindUserById(int id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);
		return user;
	}

	public User FindUserByUsername(String username) {
		// TODO Auto-generated method stub
		List<User> lu = (em.createQuery("SELECT u FROM User u WHERE u.username = :UName").setParameter("UName",
				username)).getResultList();
		if (lu.isEmpty()) {
			return null;
		}
		return lu.get(0);
	}

	public static String MD5It(String pass) {
		String generatedPassword = "";
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest

			md.update(pass.getBytes(), 0, pass.length());
			generatedPassword = new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	@Override
	public User loginCheck(String UserName, String Password) {
		User u = null;
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username Like :UserName", User.class)
				.setParameter("UserName", UserName);
		try {
			u = query.getSingleResult();
			if (u.getPassword().equals(MD5It(Password))) {
				return u;
			} else {
				System.out.println("Error pwd");
			}
		} catch (NoResultException e) {
			// TODO: handle exception
			System.out.println("No result found");
		}
		return null;
	}

}
