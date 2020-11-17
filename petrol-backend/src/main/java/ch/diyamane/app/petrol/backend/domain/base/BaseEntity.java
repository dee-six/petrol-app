/**
 * 
 */
package ch.diyamane.app.petrol.backend.domain.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author The Boss
 * @param <T>
 *
 */
@MappedSuperclass
public abstract class BaseEntity<T> implements Entity<T> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public final boolean sameObjectAsOther(final T other) {
		return (this.equals(other));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
