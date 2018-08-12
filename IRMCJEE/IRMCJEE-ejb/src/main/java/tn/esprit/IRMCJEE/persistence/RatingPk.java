package tn.esprit.IRMCJEE.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RatingPk
 *
 */
@Embeddable

public class RatingPk implements Serializable {

	private int idsearcher;
	private long idPost;

	public int getIdsearcher() {
		return idsearcher;
	}

	public void setIdsearcher(int idsearcher) {
		this.idsearcher = idsearcher;
	}

	public long getIdPost() {
		return idPost;
	}

	public void setIdPost(long idPost) {
		this.idPost = idPost;
	}

	private static final long serialVersionUID = 1L;

	public RatingPk() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPost ^ (idPost >>> 32));
		result = prime * result + idsearcher;
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
		RatingPk other = (RatingPk) obj;
		if (idPost != other.idPost)
			return false;
		if (idsearcher != other.idsearcher)
			return false;
		return true;
	}

	

}
