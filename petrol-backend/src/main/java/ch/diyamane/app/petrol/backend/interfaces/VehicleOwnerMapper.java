package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.dto.VehicleDto;
import ch.diyamane.app.petrol.backend.dto.VehicleOwnerDto;
import com.google.common.collect.Lists;
import java.util.List;


public class VehicleOwnerMapper {

    private VehicleOwnerMapper() {
    }

    public static VehicleOwnerDto toDto(VehicleOwner vo) {

        VehicleOwnerDto dto = VehicleOwnerDto.builder().name(vo.getName())
            .address1(vo.getAddress1()).address2(vo.getAddress2())
            .city(vo.getCity()).pinCode(vo.getPinCode())
            .country(vo.getCountry()).build();

        List<VehicleDto> vehicleDtos = Lists.newArrayList();
        vo.getVehicleList().forEach(vehicle -> vehicleDtos.add(VehicleDto.builder().model(vehicle.getModel()).id(vehicle.getId().toString()).build()));

        dto.setOwnedVehicles(vehicleDtos);
        return dto;
    }
}
