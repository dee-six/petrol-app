/**
 * 
 */
package ch.diyamane.app.petrol.backend.repository.owner;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;

/**
 * @author The Boss
 * @param <T>
 *
 */
@Repository
public interface  VehicleOwnerRespository extends JpaRepository<VehicleOwner, Serializable> {

}
