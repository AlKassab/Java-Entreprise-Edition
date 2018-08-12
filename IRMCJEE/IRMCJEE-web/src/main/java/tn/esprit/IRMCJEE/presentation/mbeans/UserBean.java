package tn.esprit.IRMCJEE.presentation.mbeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.primefaces.model.UploadedFile;

import tn.esprit.IRMCJEE.persistence.Admin;
import tn.esprit.IRMCJEE.persistence.Researcher;
import tn.esprit.IRMCJEE.persistence.User;

import tn.esprit.IRMCJEE.services.AdminServiceLocal;
import tn.esprit.IRMCJEE.services.ResearcherServiceLocal;
import tn.esprit.IRMCJEE.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class UserBean {

	@EJB
	AdminServiceLocal adminServiceLocal;
	@EJB
	ResearcherServiceLocal researcherServiceLocal;
	@EJB
	UserServiceLocal userServiceLocal;
	private User u;
	private Admin a;
	private Researcher r;
	private List<String> lst = new ArrayList<>();
	private List<String> lst1 = new ArrayList<>();
	private UploadedFile file;
	static public String s = "";
	public String confirm;

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public static String getS() {
		return s;
	}

	public static void setS(String s) {
		UserBean.s = s;
	}

	@PostConstruct
	public void init() {
		u = new User();
		remplirList();
		gender();
		countries();
		a = new Admin();
		r = new Researcher();

		// Researcher r = new Researcher() ;

	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public Admin getA() {
		return a;
	}

	public void setA(Admin a) {
		this.a = a;
	}

	public Researcher getR() {
		return r;
	}

	public void setR(Researcher r) {
		this.r = r;
	}

	public List<String> getLst1() {
		return lst1;
	}

	public void setLst1(List<String> lst1) {
		this.lst1 = lst1;
	}

	public List<String> getLst() {
		return lst;
	}

	public void setLst(List<String> lst) {
		this.lst = lst;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String createProfile() {
		if (u.getPassword().equals(u.getConfirmPassword())) {
			if (userServiceLocal.FindUserByUsername(u.getUsername()) == null) {
				try {
					sendMail(u.getEmail(), "Confirm registration to IRMC", random());
					return "/Confirm?faces-redirect=true";
				} catch (MessagingException ex) {
				
				}
			
			} else {
				FacesContext.getCurrentInstance().addMessage("form:btn",
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "username exist already"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "reconfirm your password"));
		}
		


		System.out.println(s);
		System.out.println(u.getEmail());
		return null;
		
		// try {
		// ImageUtil.saveImage(u.getId(), file.getContents());
		// DocumentUtil.saveDoc(event, getIdEvent(), doc.getContents());
		// } catch (IOException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
	
	public String random(){
		Random rand = new Random();
		for (int i = 0; i < 8; i++) {
			char c = (char) (rand.nextInt(26) + 'a');
			s += c;
		}
		return s;
	}

	public void remplirList() {
		lst.add("Researcher");
		lst.add("Other");
	}

	public void gender() {
		lst1.add("Male");
		lst1.add("Female");
		lst1.add("Rather not to say");
		lst1.add("Other");
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage("form:btn",
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "username exist already"));
	}

	public void error2() {
		FacesContext.getCurrentInstance().addMessage("form:btn",
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "reconfirm your password"));
	}

	public Locale[] countries() {
		return Locale.getAvailableLocales();
	}

	public void upload(String usertId) {
		if (file != null) {
			FacesMessage message = new FacesMessage("mawaher frer", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println(file);

		}

	}

	public static void sendMail(String to, String sujet, String contenu) throws MessagingException {

		String host = "smtp.gmail.com";
		final String user = "irmc.pidev@gmail.com";// change accordingly
		final String password = "esprit2018";// change accordingly

		// Get the session object
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.from", user);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		props.setProperty("mail.debug", "true");

		Session session = Session.getInstance(props, null);
		MimeMessage msg = new MimeMessage(session);

		msg.setRecipients(Message.RecipientType.TO, to);
		msg.setSubject(sujet);
		msg.setSentDate(new Date());
		msg.setText(contenu);

		Transport transport = session.getTransport("smtp");

		transport.connect(user, password);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();

	}
	 public void register(){
		 if (u.getRole().equals("Researcher")) {
				System.out.println("here !");

				r.setAddress(u.getAddress());
				r.setConfirmPassword(u.getConfirmPassword());
				r.setEmail(u.getEmail());
				r.setFirstName(u.getFirstName());
				r.setImagePath(u.getImagePath());
				r.setLastName(u.getLastName());
				r.setPassword(u.getPassword());
				r.setUsername(u.getUsername());
				r.setGender(u.getGender());
				r.setPhoneNumber(u.getPhoneNumber());
			
				researcherServiceLocal.CreateResearcher(r);
				r = new Researcher();

			}

			else if (u.getRole().equals("Admin")) {

				a.setAddress(u.getAddress());
				a.setConfirmPassword(u.getConfirmPassword());
				a.setEmail(u.getEmail());
				a.setFirstName(u.getFirstName());
				a.setImagePath(u.getImagePath());
				a.setLastName(u.getLastName());
				a.setPassword(u.getPassword());
				a.setUsername(u.getUsername());
				a.setGender(u.getGender());
				a.setPhoneNumber(u.getPhoneNumber());
				
				adminServiceLocal.CreateAdmin(a);
				a = new Admin();

			} else {
				
				userServiceLocal.addUser(u);
				
				u = new User();
			}
	 }
	 
	 public  String confirmcode(){
		 if(confirm.equals(s)){
			 register();
				return "/user1/Profile?faces-redirect=true";
			 
		 }
		 else{
			 FacesContext.getCurrentInstance().addMessage("form:btn",
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Confirmation code invalide")); 
		 }
		 return null;
	 }
	
	
}
