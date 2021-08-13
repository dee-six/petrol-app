package ch.diyamane.app.petrol.backend.repository.shop;

import java.io.Serializable;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ch.diyamane.app.petrol.backend.domain.model.shop.Pumping;

/**
 * @author dee
 */
@Repository
public interface PumpingRepository extends JpaRepository<Pumping, Serializable> {

  @Query("FROM Pumping pumpings where pumpings.pumpShop.id = :pumpShopId")
  List<Pumping> findByPumpShop(@Param("pumpShopId") Long id);

}
