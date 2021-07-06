package ch.diyamane.app.petrol.backend.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PetrolStartUpService {

	/*
    PumpShopRepository pumpShopRepository;
    VehicleOwnerRespository vehicleOwnerRespository;
    VehicleRepository repository;
    PumpingRepository pumpingRepository;

    public void initSchema() {

        PumpShop shop = PumpShop.builder().address1("Funny-Strasse1").address2("")
            .city("Dietikon").country("Switzerland").name("Tamoil")
            .description("Tamoil - description").zipCode("8953").build();

        pumpShopRepository.save(shop);

        shop = PumpShop.builder().address1("Funny-Strasse1").address2("")
            .city("Dietikon").country("Switzerland").name("Coop")
            .description("Coop - description").zipCode("8953").build();
        pumpShopRepository.save(shop);

        // Vehicle


        VehicleOwner deepak = VehicleOwner.builder().name("Deepak")
            .address1("Funny-Strasse1").address2("Funny-Strasse2")
            .city("Dietikon").pinCode("8953").country("Switzerland")
            .build();
        vehicleOwnerRespository.save(deepak);

        Vehicle bmw = Vehicle.builder().model("BMW X Xrive").build();
        bmw.setVehicleOwner(deepak);
        repository.save(bmw);

        Vehicle mini = Vehicle.builder().model("Mini").build();
        mini.setVehicleOwner(deepak);
        repository.save(mini);


        VehicleOwner archana = VehicleOwner.builder().name("Archana")
            .address1("Funny-Strasse1").address2("Funny-Strasse2")
            .city("Dietikon").pinCode("8953").country("Switzerland")
            .build();
        vehicleOwnerRespository.save(archana);

        VehicleOwner diya = VehicleOwner.builder().name("Diya")
            .address1("Funny-Strasse1").address2("Funny-Strasse2")
            .city("Dietikon").pinCode("8953").country("Switzerland")
            .build();
        vehicleOwnerRespository.save(diya);

        Pumping pump = Pumping.builder().milage(100).billPaid(65.60)
            .startReading(3456).endReading(3556).distance(3556 - 3456)
            .milagePer100Unit(7).petrolPricePerLiter(1.31)
            .petrolPumpedInLitres(50.34).pumpDate(LocalDate.now()).build();
        pump.setPumpShop(shop);

        pumpingRepository.save(pump);
    }
    */
}
