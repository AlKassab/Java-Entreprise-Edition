package tn.esprit.IRMCJEE.presentation.JAX;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tn.esprit.IRMCJEE.persistence.Institute;
import tn.esprit.IRMCJEE.services.InstituteService;
import tn.esprit.IRMCJEE.services.InstituteServiceLocal;
import tn.esprit.IRMCJEE.services.InstituteServiceRemote;



@Path("institute")
@RequestScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstituteRessource {
//	
//	@EJB
//	UserService us;
//	
	@EJB
	InstituteServiceLocal is;
	
	@PUT
	@Path("/upadte")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateInstitute(Institute institute){
		
		is.updateInstitute(institute);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddInstitute(Institute institute){
	is.addInstitute(institute);
		return Response.status(Status.CREATED).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getInstitute() {
		return Response.ok(is.getAllInstitutes()).build();
	}
}
