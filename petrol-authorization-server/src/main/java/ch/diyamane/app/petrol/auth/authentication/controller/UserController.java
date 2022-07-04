package ch.diyamane.app.petrol.auth.authentication.controller;

import ch.diyamane.app.petrol.auth.authentication.service.UserManagerService;
import ch.diyamane.app.petrol.user.dto.UserDetailsDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserManagerService userManagerService;

  @GetMapping("/api/petrol/auth/user/all")
  public ResponseEntity<List<UserDetailsDto>> findAll() {
    return ResponseEntity.ok(userManagerService.listAll());
  }

  @GetMapping("/api/petrol/auth/user/")
  public ResponseEntity<UserDetailsDto> getUser(String userName) {
    return ResponseEntity.ok(userManagerService.getUserDataByUserName(userName));
  }
}
