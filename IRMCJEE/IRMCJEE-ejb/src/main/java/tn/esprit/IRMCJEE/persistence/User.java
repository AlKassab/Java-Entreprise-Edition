package tn.esprit.IRMCJEE.persistence;

import java.lang.String;
import java.util.List;

import javax.persistence.*;


import tn.esprit.Bone.EntityBone;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@DiscriminatorValue("User")
@DiscriminatorColumn(name="role")
public class User  extends EntityBone {

	


	private String firstName;
	private String lastName;
	private String email;
	@Column(unique=true)
	private String username;
	private String confirmPassword;
	private String password;
	private String gender;
	private String imagePath;
	private String address;
	private String country;
	private int phoneNumber;
	@Column(name="role",insertable=false,updatable=false,nullable=false)
	private String role;
	@Transient
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Follow> followings;
	
	public User() {
		super();
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}   
	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
   
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Follow> getFollowings() {
		return followings;
	}
	public void setFollowings(List<Follow> followings) {
		this.followings = followings;
	}
	
	
	
}
