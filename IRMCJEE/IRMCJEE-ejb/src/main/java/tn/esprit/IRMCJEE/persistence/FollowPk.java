package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FollowPk
 *
 */
@Embeddable

public class FollowPk implements Serializable {

	private int userId;
	private int researcherId;
	
	private static final long serialVersionUID = 1L;

	public FollowPk() {
		super();
	}

	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getResearcherId() {
		return researcherId;
	}


	public void setResearcherId(int researcherId) {
		this.researcherId = researcherId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + researcherId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FollowPk other = (FollowPk) obj;
		if (researcherId != other.researcherId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
   
}
