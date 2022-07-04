package ch.diyamane.app.petrol.backend.interfaces;

import ch.diyamane.app.petrol.backend.service.VehicleOwnerService;
import ch.diyamane.app.petrol.business.api.VehicleOwnerApi;
import ch.diyamane.app.petrol.business.dto.StatusEnum;
import ch.diyamane.app.petrol.business.dto.VehicleOwnerDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@PreAuthorize("hasAuthority('SCOPE_petrol.read')")
public class VehicleOwnerController implements VehicleOwnerApi {

  VehicleOwnerService vehicleOwnerService;

  @Override
  public ResponseEntity<VehicleOwnerDto> addVehicleOwner(VehicleOwnerDto dto) {
    return new ResponseEntity<>(vehicleOwnerService.addVehicleOwner(dto), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<VehicleOwnerDto>> findAll() {
    return new ResponseEntity<>(vehicleOwnerService.findAll(), HttpStatus.OK);
  }


  @Override
  public ResponseEntity<List<VehicleOwnerDto>> findAllByStatus(StatusEnum status) {
    return new ResponseEntity<>(vehicleOwnerService.findAllByStatus(status), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<VehicleOwnerDto> updateOwner(VehicleOwnerDto dto) {
    return new ResponseEntity<>(vehicleOwnerService.updateOwner(dto), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<VehicleOwnerDto> getOwner(Long id) {
    return new ResponseEntity<>(vehicleOwnerService.getOwner(id), HttpStatus.OK);

  }

}
