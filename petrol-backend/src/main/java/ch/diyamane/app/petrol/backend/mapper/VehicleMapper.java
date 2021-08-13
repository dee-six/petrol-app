package ch.diyamane.app.petrol.backend.mapper;

import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;
import ch.diyamane.app.petrol.backend.dto.VehicleDto;

public class VehicleMapper {

  public static VehicleDto toDto(Vehicle vehicle) {

    if (vehicle == null) {
      return null;
    }
    return VehicleDto.builder().model(vehicle.getModel()).id(vehicle.getId().intValue()).build();
  }

}
