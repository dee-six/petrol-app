/**
 *
 */
package ch.diyamane.app.petrol.backend.domain.model.owner;

import ch.diyamane.app.petrol.backend.domain.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

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
  @JoinColumn(name = "VEHICLE_OWNER_ID", foreignKey = @ForeignKey(name = "VEHICLE_OWNER_ID_FK"))
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

    if (obj instanceof Vehicle other) {
      return (other.getId() == this.getId() && StringUtils.equals(other.model, this.model));
    } else {
      return false;
    }

  }


}
