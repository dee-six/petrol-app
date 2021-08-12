package ch.diyamane.app.petrol.backend.repository.owner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import ch.diyamane.app.petrol.backend.configuration.PetrolBackendConfiguration;
import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;
import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.dto.StatusEnum;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleOwnerRespository;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.TestPropertySource;

/**
 * @author dee
 *
 */
@SpringBootTest(classes = VehicleOwnerRepositoryIntegrationTest.class)
@Import({ PetrolBackendConfiguration.class})
@Transactional
@Slf4j
@TestPropertySource(properties = {"ch.diyamane.app.petrol.initData=false"})
public class VehicleOwnerRepositoryIntegrationTest {

	@Autowired
	private VehicleOwnerRespository vehicleOwnerRepo;

	@Autowired
	private VehicleRepository vehicleRepo;

	@Test
	public void testInsertVehicleOwner() {

		log.info("Executing testInsertVehicleOwner");

		vehicleOwnerRepo.save(VehicleOwner.builder().name("Deepak").address1("Alfred Comtre-Str 01").address2("")
				.city("Dietikon").country("Switzerland").status(StatusEnum.ACTIVE).build());

		vehicleOwnerRepo.save(VehicleOwner.builder().name("Diya").address1("Alfred Comtre-Str 01").address2("")
				.city("Dietikon").country("Switzerland").status(StatusEnum.ACTIVE).build());

		vehicleOwnerRepo.save(VehicleOwner.builder().name("Archana").address1("Alfred Comtre-Str 01").address2("")
				.city("Dietikon").country("Switzerland").status(StatusEnum.ACTIVE).build());

		// 4 Object created

		Assertions.assertEquals(3, vehicleOwnerRepo.findAll().size());

	}

	@Test
	public void givenVehicleOwner_WhenCreateVehicle_ThenVehicleCreated() {

		// Create a new Car and a add a new Owner
		// 5 Owner created

		VehicleOwner vehicleOwnerDeepak = VehicleOwner.builder().name("Deepak").address1("Alfred Comtre-Str 01")
				.address2("").city("Dietikon").country("Switzerland").status(StatusEnum.ACTIVE).build();
		
		vehicleOwnerDeepak.addVehicle(Vehicle.builder().model("Ford").build());
		vehicleOwnerDeepak.addVehicle(Vehicle.builder().model("BMW").build());
		vehicleOwnerDeepak.addVehicle(Vehicle.builder().model("BENZ").build());

		vehicleOwnerRepo.saveAndFlush(vehicleOwnerDeepak);

		// Get first car
		List<Vehicle> vechicles = vehicleRepo.findAll();

		Assertions.assertEquals(vehicleRepo.findAll().size(), 3);

		Optional<VehicleOwner> deepak = vehicleOwnerRepo.findById(vehicleOwnerDeepak.getId());

		assertAll("Verify Associated Cars", () -> assertTrue(deepak.isPresent()),
				() -> assertEquals(3, deepak.get().getVehicleList().size()),
				() -> assertTrue(deepak.get().getVehicleList().stream().filter(vehi -> vehi.getModel().equals("Ford"))
						.findAny().isPresent()));

	}
}
