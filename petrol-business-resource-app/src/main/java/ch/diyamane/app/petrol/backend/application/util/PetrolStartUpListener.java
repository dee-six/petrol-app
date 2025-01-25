package ch.diyamane.app.petrol.backend.application.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ch.diyamane.app.petrol.backend.application.service.PetrolStartUpService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * @author rampoore
 *
 */
@Slf4j
@Transactional
@Service
public class PetrolStartUpListener {

  @Autowired
  private PetrolStartUpService petrolStartUpService;

  @EventListener
  public void contextInitialized(ContextRefreshedEvent event) {

    petrolStartUpService.initSchema();

  }

}
