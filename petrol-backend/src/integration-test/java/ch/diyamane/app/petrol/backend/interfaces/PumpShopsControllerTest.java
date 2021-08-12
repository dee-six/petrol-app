package ch.diyamane.app.petrol.backend.interfaces;

import static org.junit.jupiter.api.Assertions.*;

import ch.diyamane.app.petrol.backend.configuration.PetrolBackendConfiguration;
import ch.diyamane.app.petrol.backend.service.PumpShopServiceIntegrationTest;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = PumpShopsControllerTest.class)
@Import({PetrolBackendConfiguration.class})
@Transactional
@Slf4j
@TestPropertySource(properties = {"ch.diyamane.app.petrol.initData=false"})
public class PumpShopsControllerTest {

}