package tn.esprit.IRMCJEE.presentation.mbeans;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import tn.esprit.IRMCJEE.persistence.User;

import tn.esprit.IRMCJEE.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class ProfileBean {

	@EJB
	UserServiceLocal userServiceLocal;
	@ManagedProperty("#{loginBean.u}")
	private User u;
	private UploadedFile file;

	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public void update() {
		if (u.getPassword().equals(u.getConfirmPassword())) {
			userServiceLocal.UpdateUser(u);
			//try {
				//ImageUtil.saveImage(u.getId(), file.getContents());
			  ////DocumentUtil.saveDoc(event, getIdEvent(), doc.getContents());
			//} catch (IOException e) {
				//// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
		
		}
		else
			error2();

	}

	public String redirect() {
		return "/user1/updateProfle?faces-redirect=true";
	}
	public String redirect1() {
		return "/user1/Profile?faces-redirect=true";
	}

	public void error2() {
		FacesContext.getCurrentInstance().addMessage("form:btn",
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "reconfirm your password"));
	}
	
public String logOut(){
		System.out.println("dtytuiuoipo");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login?faces-redirect=true";
		
		
	}

public void deleteProfile(int id) {
	userServiceLocal.deleteUser(id);

}

public void upload(String usertId) {
	if (file != null) {
		FacesMessage message = new FacesMessage("mawaher frer", file.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		System.out.println(file);

	}
}


}
