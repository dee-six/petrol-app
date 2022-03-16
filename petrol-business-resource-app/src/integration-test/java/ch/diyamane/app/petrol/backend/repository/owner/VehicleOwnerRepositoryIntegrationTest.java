package ch.diyamane.app.petrol.backend.repository.owner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ch.diyamane.app.petrol.backend.configuration.PetrolBackendConfiguration;
import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;
import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.dto.StatusEnum;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author dee
 */
@SpringBootTest(classes = VehicleOwnerRepositoryIntegrationTest.class)
@Import({PetrolBackendConfiguration.class})
@EnableConfigurationProperties
@Transactional
@Slf4j
@ActiveProfiles(value = "test")
public final class VehicleOwnerRepositoryIntegrationTest {

  @Autowired
  private VehicleOwnerRepository vehicleOwnerRepo;

  @Autowired
  private VehicleRepository vehicleRepo;

  VehicleOwner vehicleOwnerDeepak;

  public VehicleOwnerRepositoryIntegrationTest() {
  }

  @BeforeEach
  void setUp() {


    VehicleOwner vehicleOwnerDeepakToSave = VehicleOwner.builder().name("Deepak").address1("Alfred Comtre-Str 01")
        .address2("").city("Dietikon").pinCode("8953").country("Switzerland").status(StatusEnum.ACTIVE).build();

    vehicleOwnerDeepakToSave.addVehicle(Vehicle.builder().model("Ford").build());
    vehicleOwnerDeepakToSave.addVehicle(Vehicle.builder().model("BMW").build());
    vehicleOwnerDeepakToSave.addVehicle(Vehicle.builder().model("BENZ").build());

    vehicleOwnerDeepak = vehicleOwnerRepo.saveAndFlush(vehicleOwnerDeepakToSave);
  }

  @Test
  public void givenVehicleOwner_WhenCreateVehicle_ThenVehicleCreated() {

    // Get first car
    List<Vehicle> vechicles = vehicleRepo.findAll();

    Assertions.assertEquals(vehicleRepo.findAll().size(), 3);

    Optional<VehicleOwner> deepak = vehicleOwnerRepo.findById(vehicleOwnerDeepak.getId());

    assertAll("Verify Associated Cars", () -> assertTrue(deepak.isPresent()),
        () -> assertEquals(3, deepak.get().getVehicleList().size()),
        () -> assertTrue(deepak.get().getVehicleList().stream().anyMatch(vehi -> vehi.getModel().equals("Ford"))));

  }
}
