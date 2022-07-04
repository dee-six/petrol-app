package ch.diyamane.app.petrol.backend.application.service;

import ch.diyamane.app.petrol.backend.repository.owner.VehicleRepository;
import ch.diyamane.app.petrol.backend.repository.shop.PumpingRepository;
import ch.diyamane.app.petrol.backend.service.PumpShopService;
import ch.diyamane.app.petrol.backend.service.VehicleOwnerService;
import ch.diyamane.app.petrol.business.dto.PumpShopDto;
import ch.diyamane.app.petrol.business.dto.PumpingsDto;
import ch.diyamane.app.petrol.business.dto.StatusEnum;
import ch.diyamane.app.petrol.business.dto.VehicleDto;
import ch.diyamane.app.petrol.business.dto.VehicleOwnerDto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@NoArgsConstructor
@Slf4j
public class PetrolStartUpService {

  @Value("${ch.diyamane.app.petrol.initData:false}")
  private String initData;

  @Autowired
  PumpShopService pumpShopService;

  @Autowired
  VehicleOwnerService vehicleOwnerService;

  @Autowired
  VehicleRepository repository;

  @Autowired
  PumpingRepository pumpingRepository;

  public void initSchema() {

    if (initData.equals("false")) {
      log.info("Petrol initial data creation ignored.");
      return;
    }

    PumpShopDto pumpShopDto = pumpShopService.save(PumpShopDto.builder().address1("Funny-Strasse1").address2("")
        .city("Dietikon").country("Switzerland").name("Tamoil")
        .description("Tamoil - description").zipCode("8953").build());

    pumpShopService.save(PumpShopDto.builder().address1("Funny-Strasse1").address2("")
        .city("Dietikon").country("Switzerland").name("Coop")
        .description("Coop - description").zipCode("8953").build());

    // Vehicle
    VehicleOwnerDto deepakVehicleOwnerDto = VehicleOwnerDto.builder().name("Deepak")
        .address1("Funny-Strasse1").address2("Funny-Strasse2")
        .city("Dietikon").pinCode("8953").country("Switzerland").status(StatusEnum.ACTIVE)
        .build();

    VehicleDto bmw = VehicleDto.builder().model("BMW X Xrive").build();
    deepakVehicleOwnerDto.addOwnedVehiclesItem(bmw);

    VehicleDto mini = VehicleDto.builder().model("Mini").build();
    deepakVehicleOwnerDto.addOwnedVehiclesItem(mini);

    vehicleOwnerService.addVehicleOwner(deepakVehicleOwnerDto);

    VehicleOwnerDto archanaVehicleOwnerDto = VehicleOwnerDto.builder().name("Archana")
        .address1("Funny-Strasse1").address2("Funny-Strasse2")
        .city("Dietikon").pinCode("8953").country("Switzerland").status(StatusEnum.ACTIVE)
        .build();

    archanaVehicleOwnerDto.setOwnedVehicles(new ArrayList<VehicleDto>());
    vehicleOwnerService.addVehicleOwner(archanaVehicleOwnerDto);

    VehicleOwnerDto diyaVehicleOwnerDto = VehicleOwnerDto.builder().name("Diya")
        .address1("Funny-Strasse1").address2("Funny-Strasse2")
        .city("Dietikon").pinCode("8953").country("Switzerland").status(StatusEnum.ACTIVE)
        .build();
    diyaVehicleOwnerDto.setOwnedVehicles(new ArrayList<VehicleDto>());
    vehicleOwnerService.addVehicleOwner(diyaVehicleOwnerDto);

    PumpingsDto pump = PumpingsDto.builder().milage(BigDecimal.valueOf(100)).billPaid(BigDecimal.valueOf(65.60))
        .startReading(BigDecimal.valueOf(3456)).endReading(3556.0).distance(BigDecimal.valueOf(3556 - 3456))
        .milagePer100Unit(BigDecimal.valueOf(7)).petrolPricePerLiter(BigDecimal.valueOf(1.31))
        .petrolPumpedInLitres(BigDecimal.valueOf(50.34)).pumpDate(LocalDate.now()).build();

    pumpShopDto.addPumpingsItem(pump);

    pumpShopService.save(pumpShopDto);

    log.info("Petrol initial data created");
  }
}
