package tn.esprit.Bone;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EntityBone
 *
 */
@MappedSuperclass
public abstract class EntityBone implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Transient
	private static final long serialVersionUID = 1L;

	public EntityBone() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		EntityBone other = (EntityBone) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
   
}
