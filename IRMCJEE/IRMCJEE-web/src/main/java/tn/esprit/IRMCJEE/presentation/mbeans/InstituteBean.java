package tn.esprit.IRMCJEE.presentation.mbeans;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.map.DefaultMapModel;

import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import tn.esprit.IRMCJEE.persistence.Institute;
import tn.esprit.IRMCJEE.persistence.TypeInst;
import tn.esprit.IRMCJEE.services.InstituteServiceLocal;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@SessionScoped
public class InstituteBean {
	private Institute ins = new Institute();;

	private String name;
	private String mail;
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

	private Part imaje;

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

	private int id_inst;

	public int getId_inst() {
		return id_inst;
	}

	public void setId_inst(int id_inst) {
		this.id_inst = id_inst;
	}
	
	

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
			.getRequest();

	String id = request.getParameter("id");

	private List<Institute> listIns;

	public List<Institute> getListIns() {
		return listIns;
	}

	public void setListIns(List<Institute> listIns) {
		this.listIns = listIns;
	}

	@EJB
	private InstituteServiceLocal serviceInst;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getAddress() {
		return address;
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

	public InstituteServiceLocal getServiceInst() {
		return serviceInst;
	}

	public void setServiceInst(InstituteServiceLocal serviceInst) {
		this.serviceInst = serviceInst;
	}

	public Institute getIns() {
		return ins;
	}

	public void setIns(Institute ins) {
		this.ins = ins;
	}

	public String AddInstitute() throws ParseException, IOException {
		String url = "C:/Pidev/IRMCJEE/IRMCJEE-web/src/main/webapp/ressources/images/img/";
		InputStream is = imaje.getInputStream();
		OutputStream os = new FileOutputStream(url+imaje.getSubmittedFileName());
		byte buffer[] = new byte[1024];
		int nbLecture ;
		while ((nbLecture = is.read(buffer)) != -1){
			os.write(buffer);
		}
		os.close();
		Institute ins = new Institute(name, mail, sigle, code_postale, address, longitude, latitude, website, type,
				type_acces,imaje.getSubmittedFileName() , description);
		serviceInst.addInstitute(ins);

		return "/Institute/viewInstitute?faces-redirect=true";
	}

	Institute modifInst = new Institute();

	public String modifierInstitute(Institute modifInst) {

		this.setId_inst(modifInst.getId_inst());
		this.setAddress(modifInst.getAddress());
		this.setCode_postale(modifInst.getCode_postale());
		this.setDescription(modifInst.getDescription());
		this.setImage(modifInst.getImage());
		this.setLatitude(modifInst.getLatitude());
		this.setLongitude(modifInst.getLongitude());
		this.setName(modifInst.getName());
		this.setWebsite(modifInst.getWebsite());
		this.setType(modifInst.getType());
		this.setType_acces(modifInst.getType_acces());
		this.setSigle(modifInst.getSigle());

		return "/Institute/ModifierInstitute?faces-redirect=true";
	}
	Institute detailInst = new Institute();
	public String goToDetailInst(Institute detailInst) {

		this.setId_inst(detailInst.getId_inst());
		this.setAddress(detailInst.getAddress());
		this.setCode_postale(detailInst.getCode_postale());
		this.setDescription(detailInst.getDescription());
		this.setImage(detailInst.getImage());
		this.setLatitude(detailInst.getLatitude());
		this.setLongitude(detailInst.getLongitude());
		this.setName(detailInst.getName());
		this.setWebsite(detailInst.getWebsite());
		this.setType(detailInst.getType());
		this.setType_acces(detailInst.getType_acces());
		this.setSigle(detailInst.getSigle());

		return "/Institute/detailInstitute?faces-redirect=true";
	}

	

	public String updateInstitute() throws ParseException {

		Institute ins = new Institute();
		ins.setId_inst(id_inst);
		ins.setName(name);
		ins.setSigle(sigle);
		ins.setCode_postale(code_postale);
		ins.setAddress(address);
		ins.setLongitude(longitude);
		ins.setLatitude(latitude);
		ins.setWebsite(website);
		ins.setType(type);
		ins.setType_acces(type_acces);
		ins.setImage(image);
		ins.setDescription(description);
		serviceInst.updateInstitute(ins);
		;

		return "/Institute/viewInstitute?faces-redirect=true";
	}

	public String deleteInstitute(int id) throws ParseException {
		serviceInst.deleteInstitute(id);

		return "/Institute/viewInstitute?faces-redirect=true";
	}

	public String goToDetail(Institute in) {
		this.ins = in;
		String urlId = String.valueOf(ins.getId_inst());

		return "/Institute/detailInstitute?faces-redirect=true";
	}

	public String updateIns() {
		Institute instUp = serviceInst.findInstituteById(Integer.valueOf(id));

		serviceInst.toString();

		serviceInst.updateInstitute(instUp);

		return "/Institute/viewInstitute?faces-redirect=true";
	}

	List<Institute> list = new ArrayList<>();

	public List<Institute> viewInstitutes() {
		list = serviceInst.getAllInstitutes();
		return list;
		

	}


	public InstituteBean() {
		// TODO Auto-generated constructor stub
	}

	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled",
				"Visibility:" + event.getVisibility());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// map
	/*
	 * private MapModel simpleModel;
	 * 
	 * public MapModel viewMarkers(){ simpleModel = new DefaultMapModel();
	 * 
	 * for(Institute institute : serviceInst.getAllInstitutes()){ LatLng coord1
	 * = new LatLng(institute.getLatitude(), institute.getLongitude());
	 * simpleModel.addOverlay(new Marker(coord1, institute.getName()));
	 * 
	 * } return simpleModel;
	 * 
	 * }
	 */

	// map2
	private MapModel simpleModel;

	public MapModel map() {
		simpleModel = new DefaultMapModel();

		// Shared coordinates
		for (Institute institute : serviceInst.getAllInstitutes()) {
			LatLng coord1 = new LatLng(institute.getLatitude(), institute.getLongitude());
			simpleModel.addOverlay(new Marker(coord1, institute.getName()));

		}

		return simpleModel;
		// Basic marker

	}

	public MapModel getSimpleModel() {
		simpleModel = map();
		return simpleModel;
	}

	public List<Institute> webSite() {
		List<Institute> list = new ArrayList<>();
		for (Institute institute : serviceInst.getAllInstitutes())

			list.add(institute);

		return list;

	}
	

	public void setImaje(Part imaje) {
		this.imaje = imaje;
	}
	public Part getImaje() {
		return imaje;
	}
	
	
	
	//stat
	
	private PieChartModel pieModel2;
	
	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	public PieChartModel createPieModel2() {
        pieModel2 = new PieChartModel();
         int nbrMed=Integer.valueOf(serviceInst.nbrMed());
         int nbrArch=Integer.valueOf(serviceInst.nbrarch());
         int nbrBib=Integer.valueOf(serviceInst.nbrbib());
         int nbrCen=Integer.valueOf(serviceInst.nbrcentre());
        pieModel2.set("Mediatheque", nbrMed);
        pieModel2.set("Archive", nbrArch);
        pieModel2.set("Bibliotheque", nbrBib);
        pieModel2.set("centre de recherche", nbrCen);
         
        pieModel2.setTitle("Stat type institue");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        
        return pieModel2;
    }
}
