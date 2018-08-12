package tn.esprit.IRMCJEE.presentation.mbeans;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.IRMCJEE.persistence.User;
import tn.esprit.IRMCJEE.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	@EJB
	UserServiceLocal userServiceLocal;
	private User u;
	private String login;
	private String pwd;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String authentification() {

		u = userServiceLocal.loginCheck(login, pwd);
		if (u != null && u.getRole()=="Admin") {
			System.out.println(u.getUsername() + u.getPassword());
			return "/user1/addInstitute?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Error", " the username you’ve entered doesn’t match any account."));
		}
		return null;

	}
	
	
	
	

}
