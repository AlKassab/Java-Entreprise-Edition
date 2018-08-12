package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Application
 *
 */
@Entity

public class Application implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_App;
	private String title;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	@ManyToOne
	private Announcement annoucement;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Application() {
		super();
	}   
	public int getId_App() {
		return this.id_App;
	}

	public void setId_App(int id_App) {
		this.id_App = id_App;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
   
}
