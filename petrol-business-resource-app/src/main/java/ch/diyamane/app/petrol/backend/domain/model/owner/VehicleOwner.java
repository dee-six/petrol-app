package ch.diyamane.app.petrol.backend.domain.model.owner;

import ch.diyamane.app.petrol.backend.domain.base.BaseEntity;
import ch.diyamane.app.petrol.business.dto.StatusEnum;
import com.google.common.collect.Sets;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Optional;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "VEHICLE_OWNER")
@Data
@SuperBuilder
@NoArgsConstructor
public class VehicleOwner extends BaseEntity<VehicleOwner> {

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false)
  private String address1;

  private String address2;

  @Column(nullable = false, length = 35)
  private String city;

  @Column(nullable = false, length = 10)
  private String pinCode;

  @Column(nullable = false, length = 35)
  private String country;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private StatusEnum status;

  @OneToMany(mappedBy = "vehicleOwner", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
  @Builder.Default
  private Set<Vehicle> vehicleList = Sets.newConcurrentHashSet();

  public void addVehicle(Vehicle vehicle) {
    this.vehicleList.add(vehicle);
    vehicle.setVehicleOwner(this);
  }

  public void removeVehicle(Vehicle vehicle) {

    Optional<Vehicle> who = this.vehicleList.stream()
        .filter(vehicleToFind -> vehicleToFind.equals(vehicle)).findAny();

    who.ifPresent(value -> this.vehicleList.remove(value));

    vehicle.setVehicleOwner(null);
  }

  @Override
  public String toString() {
    return "Id : " + this.getId() + ", Name: " + name + ", Address1: " + address1 + ", " + address2 + ", City: "
        + city + ", PinCode: " + pinCode + ", Country: " + country;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }

    if (obj instanceof VehicleOwner other) {
      return StringUtils.equals(other.getName(), this.getName());
    } else {
      return false;
    }

  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

}
