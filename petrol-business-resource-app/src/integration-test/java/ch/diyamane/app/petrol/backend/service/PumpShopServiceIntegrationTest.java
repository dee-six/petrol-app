package ch.diyamane.app.petrol.backend.service;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

import ch.diyamane.app.petrol.backend.configuration.PetrolBackendConfiguration;
import ch.diyamane.app.petrol.business.dto.PumpShopDto;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(classes = PumpShopServiceIntegrationTest.class)
@Import({PetrolBackendConfiguration.class})
@Transactional
@Slf4j
@ActiveProfiles("test")
public class PumpShopServiceIntegrationTest {

  @Autowired
  private PumpShopService pumpShopService;

  @Lazy
  @Autowired
  private GenericContainer eurekaServer;

  @Test
  public void givenPumpShop_WhenCreatePumpShop_ThenPumpShopCreated() {

    await().atMost(60, SECONDS).until(() -> eurekaServer != null);

    PumpShopDto pumpShopDto = PumpShopDto.builder().address1("Funny-Strasse1").address2("")
        .city("Dietikon").country("Switzerland").name("Tamoil")
        .description("Tamoil - description").zipCode("8953").build();

    pumpShopService.save(pumpShopDto);

    PumpShopDto unknown = PumpShopDto.builder().address1("unknow").build();

    // Get first car
    List<PumpShopDto> pumpShops = pumpShopService.findAll();

    Assertions.assertEquals(pumpShops.size(), 1);

    PumpShopDto firstPumpShopDto = pumpShops.stream().findFirst().orElse(unknown);

    Assertions.assertEquals(firstPumpShopDto.getAddress1(), pumpShopDto.getAddress1());

    PumpShopDto pumpShop = pumpShopService.findById(firstPumpShopDto.getId().longValue());

    assertAll("Verify Associated Cars", () -> assertNotNull(pumpShop),
        () -> assertEquals(pumpShop.getAddress1(), pumpShopDto.getAddress1())
    );

  }
}