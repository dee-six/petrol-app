package ch.diyamane.app.petrol.backend.application.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Sets;

import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;
import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.domain.model.shop.PumpShop;
import ch.diyamane.app.petrol.backend.domain.model.shop.Pumping;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleOwnerRespository;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleRepository;
import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import ch.diyamane.app.petrol.backend.repository.shop.PumpingRepository;

@Service
@Transactional
public class PetrolStartUpService {

    @Autowired
    PumpShopRepository _pumpShopRepository;

    @Autowired
    VehicleOwnerRespository _vehicleOwnerRespository;

    @Autowired
    VehicleRepository repository;

    @Autowired
    PumpingRepository pumpingRepository;

    public void initSchema() {

	PumpShop shop = PumpShop.builder().address1("Funny-Strasse1").address2("")
		.city("Dietikon").country("Switzerland").name("Tamoil")
		.description("Tamoil - description").zipCode(8953).build();

	_pumpShopRepository.save(shop);

	shop = PumpShop.builder().address1("Funny-Strasse1").address2("")
		.city("Dietikon").country("Switzerland").name("Coop")
		.description("Coop - description").zipCode(8953).build();
	_pumpShopRepository.save(shop);

	Vehicle bmw = Vehicle.builder().model("BMW X Xrive").build();
	repository.save(bmw);

	Vehicle mini = Vehicle.builder().model("Mini").build();
	repository.save(mini);

	VehicleOwner deepak = VehicleOwner.builder().name("Deepak")
		.address1("Funny-Strasse1").address2("Funny-Strasse2")
		.city("Dietikon").pinCode("8953").country("Switzerland")
		.build();
	deepak.setVehicleList(Sets.newHashSet(mini, bmw));
	_vehicleOwnerRespository.save(deepak);

	VehicleOwner archana = VehicleOwner.builder().name("Archana")
		.address1("Funny-Strasse1").address2("Funny-Strasse2")
		.city("Dietikon").pinCode("8953").country("Switzerland")
		.build();
	_vehicleOwnerRespository.save(archana);

	VehicleOwner diya = VehicleOwner.builder().name("Diya")
		.address1("Funny-Strasse1").address2("Funny-Strasse2")
		.city("Dietikon").pinCode("8953").country("Switzerland")
		.build();
	diya.setVehicleList(Sets.newHashSet(mini, bmw));
	_vehicleOwnerRespository.save(diya);

	Pumping pump = Pumping.builder().milage(100).billPaid(65.60)
		.startReading(3456).endReading(3556).distance(3556 - 3456)
		.milagePer100Unit(7).petrolPricePerLiter(1.31)
		.petrolPumpedInLitres(50.34).pumpDate(LocalDate.now()).build();
	pump.setPumpShop(shop);

	pumpingRepository.save(pump);
    }
}
