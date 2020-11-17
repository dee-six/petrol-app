/**
 * 
 */
package ch.diyamane.app.petrol.backend.domain.base;

/**
 * @author The Boss
 *
 */
public interface Entity<T> {

	/**
	 * Entities compare by identity, not by attributes.
	 *
	 * @param other
	 *            The other entity.
	 * @return true if the identities are the same, regardless of other attributes.
	 */
	boolean sameObjectAsOther(T other);

}
