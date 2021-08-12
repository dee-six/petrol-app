package ch.diyamane.app.petrol.backend.repository.shop;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.diyamane.app.petrol.backend.domain.model.shop.Pumping;

/**
 * @author dee
 *
 */
@Repository
public interface PumpingRepository extends JpaRepository<Pumping, Serializable>{

}
