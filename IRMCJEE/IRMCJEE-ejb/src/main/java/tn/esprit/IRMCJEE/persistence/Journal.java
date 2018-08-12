package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Journal
 *
 */
@Entity

public class Journal implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Journal;
	private String description;
	private Date date;
	private int number;
	private String filePath;
	private static final long serialVersionUID = 1L;
    @ManyToOne
    private Collection collection;
    @OneToMany(mappedBy="journal")
    private List<Article> articles;
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Collection getCollection() {
	return collection;
}
public void setCollection(Collection collection) {
	this.collection = collection;
}
	public Journal() {
		super();
	}   
	public int getId_Journal() {
		return this.id_Journal;
	}

	public void setId_Journal(int id_Journal) {
		this.id_Journal = id_Journal;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}   
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
   
}
