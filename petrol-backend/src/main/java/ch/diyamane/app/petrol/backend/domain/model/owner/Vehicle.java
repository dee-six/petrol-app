/**
 * 
 */
package ch.diyamane.app.petrol.backend.domain.model.owner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.diyamane.app.petrol.backend.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author The Boss
 *
 */
@Entity
@Table(name = "VEHICLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Vehicle extends BaseEntity<Vehicle> {

	@Column(name = "MODEL")
	private String model;
	
	@ManyToOne
	@JoinColumn(name="VEHICLE_OWNER_ID", foreignKey = @ForeignKey(name = "VEHICLE_OWNER_ID_FK"))
	private VehicleOwner vehicleOwner;
	
	@Override
	public String toString() {
		return "Id: " + this.getId() + ", Model: " + this.model + " belongs to: " + vehicleOwner.toString();
	}

	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
					
		if (getClass() != obj.getClass())
			return false;
		
		Vehicle other = (Vehicle) obj;		
		if (other != null ) {
			if (other.getId() == this.getId() && other.model == this.model) {
				return true;
			}
		}
		return false;
	}



}
