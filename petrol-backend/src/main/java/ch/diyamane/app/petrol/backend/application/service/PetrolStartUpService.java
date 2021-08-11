package ch.diyamane.app.petrol.backend.application.service;

import ch.diyamane.app.petrol.backend.domain.model.owner.Vehicle;
import ch.diyamane.app.petrol.backend.domain.model.owner.VehicleOwner;
import ch.diyamane.app.petrol.backend.domain.model.shop.PumpShop;
import ch.diyamane.app.petrol.backend.domain.model.shop.Pumping;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleOwnerRespository;
import ch.diyamane.app.petrol.backend.repository.owner.VehicleRepository;
import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import ch.diyamane.app.petrol.backend.repository.shop.PumpingRepository;
import java.time.LocalDate;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PetrolStartUpService {

  @Value("${ch.diyamane.app.petrol.initData:false}")
  private String initData;

  PumpShopRepository pumpShopRepository;
  VehicleOwnerRespository vehicleOwnerRespository;
  VehicleRepository repository;
  PumpingRepository pumpingRepository;

  public void initSchema() {

    if (initData.equals("false")) {
      log.info("Petrol initial data created");
      return;
    }

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

    log.info("Petrol initial data created");
  }
}
