package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;



/**
 * Entity implementation class for Entity: Institute
 *
 */
@Entity

public class Institute implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_inst;
	private String name;
	private String mail;
	private String sigle;
	private String code_postale;
	private String address;
	private float longitude;
	private float latitude;
	private String website;
	@Enumerated(EnumType.STRING)
	private TypeInst type;
	private String type_acces;
	private String image;
    private String description;

	public String getSigle() {
		return sigle;
	}
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}
	public String getCode_postale() {
		return code_postale;
	}
	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getType_acces() {
		return type_acces;
	}
	public void setType_acces(String type_acces) {
		this.type_acces = type_acces;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	;
	private static final long serialVersionUID = 1L;
	

	public Institute() {
		super();
	}   
	public int getId_inst() {
		return this.id_inst;
	}

	public void setId_inst(int id_inst) {
		this.id_inst = id_inst;
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
	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}   
	
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public TypeInst getType() {
		return type;
	}
	public void setType(TypeInst type) {
		this.type = type;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Institute(String name, String mail, String sigle, String code_postale, String address, float longitude, float latitude,
			String website, TypeInst type, String type_acces, String image, String description) {
		super();
		this.name = name;
		this.mail = mail;
		this.sigle = sigle;
		this.code_postale = code_postale;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.website = website;
		this.type = type;
		this.type_acces = type_acces;
		this.image = image;
		this.description = description;
	}   
	
	
	
	
	
	
	
   
}
