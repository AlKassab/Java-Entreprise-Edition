package tn.esprit.IRMCJEE.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.IRMCJEE.persistence.Researcher;
import tn.esprit.IRMCJEE.persistence.User;
import tn.esprit.IRMCJEE.services.FollowServiceLocal;
import tn.esprit.IRMCJEE.services.ResearcherServiceLocal;

@ManagedBean
@ViewScoped
public class researcherBean {
	@EJB
	ResearcherServiceLocal researcherServiceLocal;
	@EJB
	FollowServiceLocal followservice;

	@ManagedProperty("#{loginBean.u}")
	private User u;
	private boolean follow;
	private boolean unfollow;
	private List<Researcher> lst = new ArrayList<>();
	private long count;

	public boolean isFollow() {
		return follow;
	}

	public void setFollow(boolean follow) {
		this.follow = follow;
	}

	public boolean isUnfollow() {
		return unfollow;
	}

	public void setUnfollow(boolean unfollow) {
		this.unfollow = unfollow;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public List<Researcher> getLst() {
		return lst;
	}

	public void setLst(List<Researcher> lst) {
		this.lst = lst;
	}

	@PostConstruct
	public void init() {
		lst = researcherServiceLocal.GetAllResearchers();
	}

	public long countFollowers(Researcher r) {
		return count = followservice.countFollowers(r.getId());
	}

	public void follow(Researcher r) {
		followservice.follow(r.getId(), u.getId());

	}

	public Boolean veriffollow(Researcher r) {
		if (followservice.findFollow(u.getId(), r.getId()) != null) {
			return false;
		} else {
			return true;

		}
	}

	public void unfollow(Researcher r) {

		followservice.unfollow(r.getId(), u.getId());
	}
}
