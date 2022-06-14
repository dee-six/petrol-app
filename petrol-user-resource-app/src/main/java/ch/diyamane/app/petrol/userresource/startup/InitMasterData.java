package ch.diyamane.app.petrol.userresource.startup;

import ch.diyamane.app.petrol.userresource.service.RoleManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitMasterData implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  RoleManagerService roleManagerService;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    roleManagerService.createRoles();

    log.info("Roles master data is created successfully{}", roleManagerService.getRoles());

  }
}
