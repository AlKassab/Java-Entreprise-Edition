package tn.esprit.IRMCJEE.presentation.mbeans.blog;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import org.omnifaces.util.Faces;

import tn.esprit.IRMCJEE.persistence.Post;
import tn.esprit.IRMCJEE.persistence.Researcher;
import tn.esprit.IRMCJEE.services.ServicePostLocal;

@ManagedBean(name = "blogbean")
@ViewScoped
public class BlogBean {

	private Post post;
	@ManagedProperty("#{loginBean.u}")
	private Researcher r;
	@EJB
	private ServicePostLocal servicePostLocal;
	private List<Post> lPosts;
	private List<Post> lastestPosts;
	public boolean render;
	

	 
	

	

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public List<Post> getLastestPosts() {
		return lastestPosts;
	}

	public void setLastestPosts(List<Post> lastestPosts) {
		this.lastestPosts = lastestPosts;
	}

	public List<Post> getlPosts() {
		return lPosts;
	}

	public void setlPosts(List<Post> lPosts) {
		this.lPosts = lPosts;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Researcher getR() {
		return r;
	}

	public void setR(Researcher r) {
		this.r = r;
	}

	@PostConstruct
	private void init() {
		post = new Post();
		lPosts = servicePostLocal.getNonArchivedPosts();
		lastestPosts = servicePostLocal.getMostRatedPosts();
		for (Post post : lPosts) {
			if (post.getUser().getId() != r.getId()) {
				render = false;
			} else
				render = true;
		}
	}

	public String AddPost() {
		post.setUser(r);
		servicePostLocal.addPost(post);
		post = new Post();
		return "/user1/blog/allPosts?faces-redirect=true";
	}

	public String getSpeceficPost(Post p) {
		if (p != null) {
			Faces.setFlashAttribute("post", servicePostLocal.findById(p.getIdPost()));
			return "/user1/blog/speceficPost?faces-redirect=true";
		}
		return null;
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage("form:btn",
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", ""));
	}

	public String goToaddBlog() {
		return "/user1/blog/addPost?faces-redirect=true";
	}

	public String goToallBlog() {
		return "/user1/blog/allPosts?faces-redirect=true";
	}

	public void ArchivePost(Post p) {
		post = servicePostLocal.findById(p.getIdPost());
		post.setState(1);
		servicePostLocal.updatePost(post);
		lPosts = servicePostLocal.getNonArchivedPosts();

	}
	
	

}
