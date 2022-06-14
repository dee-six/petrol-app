package ch.diyamane.app.petrol.backend.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ch.diyamane.app.petrol.backend.configuration.PetrolBackendConfiguration;
import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;
import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleOwnerRepository;
import ch.diyamane.app.petrol.business.dto.StatusEnum;
import ch.diyamane.app.petrol.business.dto.VehicleOwnerDto;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = VehicleOwnerServiceIntegrationTest.class)
@Import({PetrolBackendConfiguration.class})
@Transactional
@Slf4j
@ActiveProfiles("test")
public class VehicleOwnerServiceIntegrationTest {

  @Autowired
  VehicleOwnerService vehicleOwnerService;

  @Autowired
  VehicleOwnerRepository vehicleOwnerRespository;

  VehicleOwner vehicleOwnerDeepak;

  @BeforeEach
  void setUp() {

    vehicleOwnerDeepak = VehicleOwner.builder().name("Deepak").address1("Alfred Comtre-Str 01")
        .address2("").city("Dietikon").country("Switzerland").pinCode("8953").status(StatusEnum.ACTIVE).build();

    vehicleOwnerDeepak.addVehicle(Vehicle.builder().model("Ford").build());
    vehicleOwnerDeepak.addVehicle(Vehicle.builder().model("BMW").build());
    vehicleOwnerDeepak.addVehicle(Vehicle.builder().model("BENZ").build());

    vehicleOwnerRespository.saveAndFlush(vehicleOwnerDeepak);

  }

  @Test
  public void givenVehicleOwner_WhenFindAll_ThenOneVehicleOwnerIsFound() {

    List<VehicleOwnerDto> dtos = vehicleOwnerService.findAll();

    Assertions.assertEquals(dtos.size(), 1);

    VehicleOwnerDto vehicleOwnerDeepakDto = dtos.stream().findFirst().orElse(VehicleOwnerDto.builder().name("unknown").build());

    assertAll("Verify Associated Cars", () -> assertEquals(vehicleOwnerDeepak.getName(), vehicleOwnerDeepakDto.getName()),
        () -> assertEquals(3, vehicleOwnerDeepakDto.getOwnedVehicles().size()),
        () -> assertTrue(vehicleOwnerDeepakDto.getOwnedVehicles().stream().filter(vehi -> vehi.getModel().equals("Ford"))
            .findAny().isPresent()));

  }

}