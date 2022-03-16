package ch.diyamane.app.petrol.backend.repository.owner;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Serializable> {

}
