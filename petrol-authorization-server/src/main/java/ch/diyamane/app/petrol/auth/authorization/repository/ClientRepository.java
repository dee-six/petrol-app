package ch.diyamane.app.petrol.auth.authorization.repository;

import ch.diyamane.app.petrol.auth.authorization.domain.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
  Optional<Client> findByClientId(String clientId);
}
