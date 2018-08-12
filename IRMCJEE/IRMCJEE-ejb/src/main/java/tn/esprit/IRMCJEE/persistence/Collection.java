package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Collection
 *
 */
@Entity

public class Collection implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Col;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="collection")
	private List<Journal> journals;

	public List<Journal> getJournals() {
		return journals;
	}
	public void setJournals(List<Journal> journals) {
		this.journals = journals;
	}
	public Collection() {
		super();
	}   
	public int getId_Col() {
		return this.id_Col;
	}

	public void setId_Col(int id_Col) {
		this.id_Col = id_Col;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
