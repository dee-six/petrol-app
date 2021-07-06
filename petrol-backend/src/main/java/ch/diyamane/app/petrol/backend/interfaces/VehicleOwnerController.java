package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.dto.StatusEnum;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import ch.diyamane.app.petrol.backend.api.VehicleOwnerApi;
import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.dto.VehicleOwnerDto;
import ch.diyamane.app.petrol.backend.mapper.VehicleOwnerMapper;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleOwnerRespository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class VehicleOwnerController implements VehicleOwnerApi {

    VehicleOwnerRespository vehicleOwnerRespository;

    @Override
    public ResponseEntity<VehicleOwnerDto> addVehicleOwner(VehicleOwnerDto dto) {

        VehicleOwner vo = vehicleOwnerRespository.save(VehicleOwner.builder()
            .name(dto.getName()).address1(dto.getAddress1())
            .address2(dto.getAddress2()).city(dto.getCity())
            .pinCode(dto.getPinCode()).country(dto.getCountry()).build());

        dto.setId(vo.getId().toString());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<VehicleOwnerDto>> findAll() {

        List<VehicleOwner> vos = vehicleOwnerRespository.findAll();

        List<VehicleOwnerDto> l = vos.stream()
            .map(VehicleOwnerMapper::toDto)
            .collect(Collectors.toList());

        return new ResponseEntity<>(l, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<VehicleOwnerDto>> findAllByStatus(StatusEnum status) {

        List<VehicleOwner> vos = vehicleOwnerRespository.findAll();

        List<VehicleOwnerDto> l = vos.stream()
            .filter(vehicleOwner -> vehicleOwner.getStatus().equals(status))
            .map(VehicleOwnerMapper::toDto)
            .collect(Collectors.toList());

        return new ResponseEntity<>(l, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<VehicleOwnerDto> updateOwner(VehicleOwnerDto dto) {

        log.debug("Request received !");
        Optional<VehicleOwner> vo = vehicleOwnerRespository.findById(Long.valueOf(dto.getId()));

        if (vo.isPresent()) {
            vo.get().setName(dto.getName());
            vo.get().setAddress1(dto.getAddress1());
            vo.get().setAddress2(dto.getAddress2());
            vo.get().setCity(dto.getCity());
            vo.get().setPinCode(dto.getPinCode());
            vo.get().setCountry(dto.getCountry());
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VehicleOwnerDto> getOwner(Long id) {
        return new ResponseEntity<>(
            VehicleOwnerMapper.toDto(vehicleOwnerRespository.getOne(id)),
            HttpStatus.OK);
    }

}
