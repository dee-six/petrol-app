package ch.diyamane.app.petrol.backend.domain.model.owner;

import ch.diyamane.app.petrol.backend.dto.StatusEnum;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.diyamane.app.petrol.backend.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VEHICLE_OWNER")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleOwner extends BaseEntity<VehicleOwner> {

	private String name;
	private String address1;
	private String address2;
	private String city;
	private String pinCode;
	private String country;

	@Enumerated(EnumType.STRING)
	private StatusEnum status;


	@Builder.Default
	@OneToMany(mappedBy = "vehicleOwner")
	private Set<Vehicle> vehicleList = new LinkedHashSet<Vehicle>();

	public Set<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(Set<Vehicle> vehicleList) {
		this.vehicleList.addAll(vehicleList);
	}

	@Override
	public String toString() {
		return "Id : " + this.getId() + ", Name: " + name + ", Address1: " + address1 + ", " + address2 + ", City: "
				+ city + ", PinCode: " + pinCode + ", Country: " + country;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleOwner other = (VehicleOwner) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
