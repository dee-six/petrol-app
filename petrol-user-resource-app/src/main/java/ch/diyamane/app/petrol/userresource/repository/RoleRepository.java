package ch.diyamane.app.petrol.userresource.repository;

import ch.diyamane.app.petrol.user.dto.RoleEnum;
import ch.diyamane.app.petrol.userresource.domain.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(RoleEnum name);
}