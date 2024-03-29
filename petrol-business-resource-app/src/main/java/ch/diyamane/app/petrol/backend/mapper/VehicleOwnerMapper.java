package ch.diyamane.app.petrol.backend.mapper;

import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;
import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.business.dto.VehicleOwnerDto;
import java.util.stream.Collectors;


public class VehicleOwnerMapper {

  private VehicleOwnerMapper() {
  }

  public static VehicleOwnerDto toDto(VehicleOwner vo) {

    if (vo == null) {
      return null;
    }

    VehicleOwnerDto dto = VehicleOwnerDto.builder().id(vo.getId().intValue()).name(vo.getName())
        .address1(vo.getAddress1()).address2(vo.getAddress2())
        .city(vo.getCity()).pinCode(vo.getPinCode())
        .country(vo.getCountry()).status(vo.getStatus()).build();

    dto.setOwnedVehicles(vo.getVehicleList().stream().map(VehicleMapper::toDto).collect(Collectors.toList()));

    return dto;
  }

  public static VehicleOwner to(VehicleOwnerDto vehicleOwnerDto) {

    if (vehicleOwnerDto == null) {
      return null;
    }

    VehicleOwner vo = VehicleOwner.builder().name(vehicleOwnerDto.getName())
        .address1(vehicleOwnerDto.getAddress1()).address2(vehicleOwnerDto.getAddress2())
        .city(vehicleOwnerDto.getCity()).pinCode(vehicleOwnerDto.getPinCode())
        .country(vehicleOwnerDto.getCountry()).status(vehicleOwnerDto.getStatus())
        .id(vehicleOwnerDto.getId() == null ? null : vehicleOwnerDto.getId().longValue())
        .build();

    if (vehicleOwnerDto.getOwnedVehicles() != null && !vehicleOwnerDto.getOwnedVehicles().isEmpty()) {
      vehicleOwnerDto.getOwnedVehicles()
          .forEach(vehicle -> vo.addVehicle(Vehicle.builder().model(vehicle.getModel()).build()));
    }

    return vo;
  }
}
