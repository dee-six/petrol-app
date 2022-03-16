package ch.diyamane.app.petrol.backend.service;

import ch.diyamane.app.petrol.backend.domain.model.shop.PumpShop;
import ch.diyamane.app.petrol.backend.dto.PumpShopDto;
import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@Slf4j
class PumpShopServiceTest {

  @InjectMocks
  PumpShopService pumpShopService;

  @Mock
  PumpShopRepository  pumpShopRepository;

  @BeforeEach
  void setUp() {

    pumpShopService = Mockito.mock(PumpShopService.class, Mockito.withSettings().lenient());

    PumpShopDto pumpShopDto = PumpShopDto.builder().address1("Funny-Strasse1").address2("")
        .city("Dietikon").country("Switzerland").name("Tamoil")
        .description("Tamoil - description").zipCode("8953").build();

    PumpShop pumpShop = PumpShop.builder().address1("Funny-Strasse1").address2("")
        .city("Dietikon").country("Switzerland").name("Tamoil")
        .description("Tamoil - description").zipCode("8953").build();

    Mockito.lenient().when(pumpShopRepository.findAll()).thenReturn(Collections.singletonList(pumpShop));

    Mockito.lenient().when(pumpShopService.findAll()).thenReturn(Collections.singletonList(pumpShopDto));
  }

  @Test
  public void givenPumpServiceWhenGetAllThenReturnsPumpShops() {

    List<PumpShopDto> pumpsShops = pumpShopService.findAll();

    Assertions.assertThat(pumpsShops.size()).isEqualTo(1);

    Assertions.assertThat(pumpsShops.get(0).getCountry()).isEqualTo("Switzerland");
  }

}