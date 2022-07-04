package ch.diyamane.app.petrol.auth.authentication.service;

import ch.diyamane.app.petrol.auth.authentication.domain.UserData;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsBuilderService {

  UserDetails build(UserData userData);

}
