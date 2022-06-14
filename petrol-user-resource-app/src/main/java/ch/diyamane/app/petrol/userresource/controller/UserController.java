package ch.diyamane.app.petrol.userresource.controller;

import ch.diyamane.app.petrol.user.api.UserDetailsApi;
import ch.diyamane.app.petrol.user.dto.UserDetailsDto;
import ch.diyamane.app.petrol.userresource.service.UserManagerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserDetailsApi {

  @Autowired
  UserManagerService userManagerService;

  @Override
  public ResponseEntity<List<UserDetailsDto>> findAll() {
    return ResponseEntity.ok(userManagerService.listAll());
  }

  @Override
  public ResponseEntity<UserDetailsDto> getUser(String userName) {
    return ResponseEntity.ok(userManagerService.getUserDataByUserName(userName));
  }
}
