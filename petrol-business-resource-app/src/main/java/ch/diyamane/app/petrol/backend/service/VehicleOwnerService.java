package ch.diyamane.app.petrol.backend.service;

import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.mapper.VehicleOwnerMapper;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleOwnerRepository;
import ch.diyamane.app.petrol.business.dto.StatusEnum;
import ch.diyamane.app.petrol.business.dto.VehicleOwnerDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleOwnerService {

  VehicleOwnerRepository vehicleOwnerRepository;

  public VehicleOwnerDto addVehicleOwner(VehicleOwnerDto dto) {

    VehicleOwner vo = vehicleOwnerRepository.save(VehicleOwnerMapper.to(dto));

    dto.setId(vo.getId().intValue());

    return dto;
  }

  public List<VehicleOwnerDto> findAll() {

    List<VehicleOwner> vehicleOwners = vehicleOwnerRepository.findAll();

    List<VehicleOwnerDto> vehicleOwnerDtos = vehicleOwners.stream()
        .map(VehicleOwnerMapper::toDto)
        .collect(Collectors.toList());

    return vehicleOwnerDtos;
  }

  public List<VehicleOwnerDto> findAllByStatus(StatusEnum status) {

    List<VehicleOwner> vehicleOwners = vehicleOwnerRepository.findAll();

    List<VehicleOwnerDto> vehicleOwnerDtos = vehicleOwners.stream()
        .filter(vehicleOwner -> vehicleOwner.getStatus().equals(status))
        .map(VehicleOwnerMapper::toDto)
        .collect(Collectors.toList());

    return vehicleOwnerDtos;

  }

  public VehicleOwnerDto updateOwner(VehicleOwnerDto dto) {

    log.debug("Request received !");
    Optional<VehicleOwner> vo = vehicleOwnerRepository.findById(Long.valueOf(dto.getId()));

    if (vo.isPresent()) {
      vo.get().setName(dto.getName());
      vo.get().setAddress1(dto.getAddress1());
      vo.get().setAddress2(dto.getAddress2());
      vo.get().setCity(dto.getCity());
      vo.get().setPinCode(dto.getPinCode());
      vo.get().setCountry(dto.getCountry());
    }

    return dto;
  }

  public VehicleOwnerDto getOwner(Long id) {
    return VehicleOwnerMapper.toDto(vehicleOwnerRepository.getOne(id));
  }
}