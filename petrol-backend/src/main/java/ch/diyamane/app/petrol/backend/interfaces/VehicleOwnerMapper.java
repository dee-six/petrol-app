package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.dto.owner.VehicleDto;
import ch.diyamane.app.petrol.backend.dto.owner.VehicleOwnerDto;

public class VehicleOwnerMapper {

    public static VehicleOwnerDto toDto(VehicleOwner vo) {
	
	VehicleOwnerDto dto = VehicleOwnerDto.builder().name(vo.getName())
		.address1(vo.getAddress1()).address2(vo.getAddress2())
		.city(vo.getCity()).pinCode(vo.getPinCode())
		.country(vo.getCountry()).build();
	
	vo.getVehicleList().stream().forEach(vehicle -> {
	    dto.addVehicle(VehicleDto.builder().model(vehicle.getModel()).id(vehicle.getId().toString()).build());
	});
	
	return dto;
    }

}
