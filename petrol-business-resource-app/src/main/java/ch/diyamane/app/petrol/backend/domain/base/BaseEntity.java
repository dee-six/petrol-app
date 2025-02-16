/**
 * 
 */
package ch.diyamane.app.petrol.backend.domain.base;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author The Boss
 * @param <T>
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@MappedSuperclass
@SuperBuilder
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
