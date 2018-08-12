package tn.esprit.IRMCJEE.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.IRMCJEE.persistence.Institute;
import tn.esprit.IRMCJEE.persistence.TypeInst;
import tn.esprit.IRMCJEE.services.InstituteServiceLocal;
@ManagedBean
@ViewScoped
public class detailInstituteBean {
	private Institute ins = new Institute();;
	 
	private String name;
	private String sigle;
	private String code_postale;
	private String address;
	private float longitude;
	private float latitude;
	private String website;
	private TypeInst type;
	private String type_acces;
	private String image;
    private String description;
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
	        .getRequest();

	String id = request.getParameter("id");
	private List<Institute> listIns;
	@EJB
	private InstituteServiceLocal serviceInst ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getLongitude() {
		return longitude;
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public TypeInst getType() {
		return type;
	}
	public void setType(TypeInst type) {
		this.type = type;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Institute> getListIns() {
		return listIns;
	}
	public void setListIns(List<Institute> listIns) {
		this.listIns = listIns;
	}
	

	



}
