package tn.esprit.IRMCJEE.presentation.mbeans.blog;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.primefaces.event.RateEvent;

import tn.esprit.IRMCJEE.persistence.Comment;
import tn.esprit.IRMCJEE.persistence.Post;
import tn.esprit.IRMCJEE.persistence.Rating;
import tn.esprit.IRMCJEE.persistence.Researcher;
import tn.esprit.IRMCJEE.services.ServiceCommentLocal;
import tn.esprit.IRMCJEE.services.ServicePostLocal;
import tn.esprit.IRMCJEE.services.ServiceRatingLocal;

@ManagedBean(name = "specblog")
@ViewScoped
public class SpeceficBlogBean {
	private Post post;
	private Comment comment;
	@EJB
	private ServiceCommentLocal serviceCommentLocal;
	@ManagedProperty("#{loginBean.u}")
	private Researcher r;
	private List<Comment> lComments;
	private boolean render;
	private boolean ratingrender;
	@EJB
	private ServiceRatingLocal serviceRatingLocal;
	@EJB
	private ServicePostLocal servicePostLocal;
	private Rating rating;
	private Integer a;
	private boolean z=false;

	public boolean isZ() {
		return z;
	}

	public void setZ(boolean z) {
		this.z = z;
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Rating getRating() {
		return rating;
	}

	public boolean isRatingrender() {
		return ratingrender;
	}

	public void setRatingrender(boolean ratingrender) {
		this.ratingrender = ratingrender;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public List<Comment> getlComments() {
		return lComments;
	}

	public void setlComments(List<Comment> lComments) {
		this.lComments = lComments;
	}

	public Researcher getR() {
		return r;
	}

	public void setR(Researcher r) {
		this.r = r;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@PostConstruct
	private void init() {
		rating = new Rating();
		render = false;
		comment = new Comment();
		post = Faces.getFlashAttribute("post");
		lComments = serviceCommentLocal.getListCommentByIdPost(post.getIdPost());
		avgRaiting();
		for (Comment comment : lComments) {
			if (comment.getUser().getId() == r.getId()) {
				render = true;
			}
		}
		existRating();
	}

	public void addComment() {
		comment.setUser(r);
		comment.setPost(post);
		serviceCommentLocal.updateComment(comment);
		comment = new Comment();
		lComments = serviceCommentLocal.getListCommentByIdPost(post.getIdPost());

	}

	public void deleteComment(Comment c) {
		serviceCommentLocal.deleteComment(c.getIdCom());
		lComments = serviceCommentLocal.getListCommentByIdPost(post.getIdPost());

	}

	public void preUpdate(Comment c) {
		comment = serviceCommentLocal.findById(c.getIdCom());
		comment.setField(c.getField());
		comment.setPost(post);
		comment.setUser(r);
	}

	public void onrate(RateEvent rateEvent) {
		a = ((Integer) rateEvent.getRating()).intValue();
		System.out.println(a);
		serviceRatingLocal.addRating(r.getId(), post.getIdPost(), a);
		z=true;
	}

	public Boolean existRating() {
		rating = serviceRatingLocal.findRatingByResearcherPost(post.getIdPost(), r.getId());
		if (rating != null) {
			ratingrender = false;
			return ratingrender;
		} else {
			ratingrender = true;
			return ratingrender;
		}

	}
	public Integer avgRaiting(){
		Double d = servicePostLocal.getAverageRating(post.getIdPost());
		return d.intValue();
	}
	
	
}
