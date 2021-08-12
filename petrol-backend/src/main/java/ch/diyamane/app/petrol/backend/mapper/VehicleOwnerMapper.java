package ch.diyamane.app.petrol.backend.mapper;

import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;
import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.dto.VehicleDto;
import ch.diyamane.app.petrol.backend.dto.VehicleOwnerDto;
import com.google.common.collect.Lists;
import java.util.List;


public class VehicleOwnerMapper {

  private VehicleOwnerMapper() {
  }

  public static VehicleOwnerDto toDto(VehicleOwner vo) {

    VehicleOwnerDto dto = VehicleOwnerDto.builder().id(vo.getId().toString()).name(vo.getName())
        .address1(vo.getAddress1()).address2(vo.getAddress2())
        .city(vo.getCity()).pinCode(vo.getPinCode())
        .country(vo.getCountry()).build();

    List<VehicleDto> vehicleDtos = Lists.newArrayList();
    vo.getVehicleList().forEach(
        vehicle -> vehicleDtos.add(VehicleDto.builder().model(vehicle.getModel()).id(vehicle.getId().toString()).build()));

    dto.setOwnedVehicles(vehicleDtos);
    return dto;
  }

  public static VehicleOwner to(VehicleOwnerDto vehicleOwnerDto) {

    VehicleOwner vo = VehicleOwner.builder().name(vehicleOwnerDto.getName())
        .address1(vehicleOwnerDto.getAddress1()).address2(vehicleOwnerDto.getAddress2())
        .city(vehicleOwnerDto.getCity()).pinCode(vehicleOwnerDto.getPinCode())
        .country(vehicleOwnerDto.getCountry()).build();

    List<Vehicle> vehicles = Lists.newArrayList();

    if (!vehicleOwnerDto.getOwnedVehicles().isEmpty()) {
      vehicleOwnerDto.getOwnedVehicles()
          .forEach(vehicle -> vo.addVehicle(Vehicle.builder().model(vehicle.getModel()).build()));
    }

    return vo;
  }
}
