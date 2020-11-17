/**
 * 
 */
package ch.diyamane.app.petrol.backend.domain.model.owner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.common.hash.HashCode;

import ch.diyamane.app.petrol.backend.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author The Boss
 *
 */
@Entity
@Table(name = "VEHICLE")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends BaseEntity<Vehicle> {

	@Column(name = "MODEL")
	private String model;
	
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name="VEHICLE_OWNER_ID")
	private VehicleOwner vehicleOwner;

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: " + this.getId() + ", Model: " + this.model + " belongs to: " + vehicleOwner.toString();
	}

	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (vehicleOwner == null) {
			if (other.vehicleOwner != null)
				return false;
		} else if (!vehicleOwner.equals(other.vehicleOwner))
			return false;
		return true;
	}
}
