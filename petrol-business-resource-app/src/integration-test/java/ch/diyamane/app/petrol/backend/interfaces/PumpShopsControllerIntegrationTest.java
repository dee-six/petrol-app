package ch.diyamane.app.petrol.backend.interfaces;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ch.diyamane.app.petrol.backend.configuration.PetrolBackendConfiguration;
import ch.diyamane.app.petrol.backend.domain.model.shop.PumpShop;
import ch.diyamane.app.petrol.backend.domain.model.shop.Pumping;
import ch.diyamane.app.petrol.backend.mapper.PumpingsMapper;
import ch.diyamane.app.petrol.backend.repository.shop.PumpShopRepository;
import ch.diyamane.app.petrol.backend.repository.shop.PumpingRepository;
import ch.diyamane.app.petrol.business.dto.PumpingsDto;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = {PumpShopsController.class})
@ExtendWith({SpringExtension.class})
@AutoConfigureMockMvc
@Import({PetrolBackendConfiguration.class})
@Transactional
@Slf4j
@ActiveProfiles("test")
public class PumpShopsControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  PumpShopRepository pumpShopRepository;

  @Autowired
  PumpingRepository pumpingRepository;

  @BeforeEach
  void setUp() {


    PumpShop pumpShop = PumpShop.builder().address1("Funny-Strasse1").address2("")
        .city("Dietikon").country("Switzerland").name("Tamoil")
        .description("Tamoil - description").zipCode("8953").build();
    //PumpShop pumpShopSaved = pumpShopRepository.saveAndFlush(pumpShop);

    PumpingsDto pumpingDto = PumpingsDto.builder().milage(BigDecimal.valueOf(100)).billPaid(BigDecimal.valueOf(65.60))
        .startReading(BigDecimal.valueOf(3456)).endReading(3556.0).distance(BigDecimal.valueOf(3556 - 3456))
        .milagePer100Unit(BigDecimal.valueOf(7)).petrolPricePerLiter(BigDecimal.valueOf(1.31))
        .petrolPumpedInLitres(BigDecimal.valueOf(50.34)).pumpDate(LocalDate.now()).build();

    Pumping pumping = PumpingsMapper.toPumpings(pumpingDto);

    pumpShop.addPumping(pumping);
    pumpShopRepository.saveAndFlush(pumpShop);
    // pumpingRepository.saveAndFlush(pumping);
  }

  @Test
  @WithMockUser(username = "deepak", authorities = { "SCOPE_petrol.read" } )
  public void givenUrl_WhenGetAll_ThenGetsAllPumpShops() throws Exception {

    MockHttpServletResponse response = this.mvc.perform(
            get("/petrol/pumpshop").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse();

    Assertions.assertThat(response.getContentAsString().contains("Funny-Strasse1")).isTrue();
    Assertions.assertThat(response.getContentAsString().contains("Tamoil")).isTrue();
    Assertions.assertThat(response.getContentAsString().contains("Dietikon11")).isFalse();

    Assertions.assertThat(response.getContentAsString().contains("3556")).isTrue();
    Assertions.assertThat(response.getContentAsString().contains("3456")).isTrue();

  }

}