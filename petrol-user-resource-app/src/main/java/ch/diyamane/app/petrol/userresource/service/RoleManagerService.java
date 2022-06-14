package ch.diyamane.app.petrol.userresource.service;

import ch.diyamane.app.petrol.user.dto.RoleEnum;
import ch.diyamane.app.petrol.userresource.domain.Role;
import ch.diyamane.app.petrol.userresource.repository.RoleRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleManagerService {

  @Autowired
  RoleRepository roleRepository;

  public void createRoles() {
    Arrays.stream(RoleEnum.values()).forEach(roleEnum ->  {
      roleRepository.save(Role.builder().name(roleEnum).build());
    });
  }

  public List<Role> getRoles() {
    return roleRepository.findAll();
  }

  public Role getRoleByName(String roleName) {
    return roleRepository.findByName(RoleEnum.valueOf(roleName)).orElseThrow();
  }
}
