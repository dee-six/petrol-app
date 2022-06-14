package ch.diyamane.app.petrol.userresource.repository;

import ch.diyamane.app.petrol.userresource.domain.UserData;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {

    @EntityGraph(value = "UserData.roles")
    Optional<UserData> findByUserNameAndEmail(String userName, String eMail);

    @EntityGraph(value = "UserData.roles")
    Optional<UserData> findByUserName(String userName);

    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUserNameAndEmail(String userName, String eMail);
}
