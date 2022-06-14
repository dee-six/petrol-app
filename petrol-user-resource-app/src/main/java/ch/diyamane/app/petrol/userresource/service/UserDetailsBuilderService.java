package ch.diyamane.app.petrol.userresource.service;

import ch.diyamane.app.petrol.userresource.domain.UserData;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsBuilderService {

  UserDetails build(UserData userData);

}
