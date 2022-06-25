package ch.diyamane.app.petrol.auth.authorization.controller;

import ch.diyamane.app.petrol.auth.authorization.domain.Client;
import ch.diyamane.app.petrol.auth.authorization.repository.ClientRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {

  public final ClientRepository clientRepository;

  @GetMapping("/api/client")
  public ResponseEntity<List<Client>> getClients() {
    return ResponseEntity.ok().body(clientRepository.findAll());
  }


}
