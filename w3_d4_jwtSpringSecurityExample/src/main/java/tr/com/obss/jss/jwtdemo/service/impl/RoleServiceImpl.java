package tr.com.obss.jss.jwtdemo.service.impl;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.obss.jss.jwtdemo.exception.RoleNotFoundException;
import tr.com.obss.jss.jwtdemo.model.Role;
import tr.com.obss.jss.jwtdemo.model.RoleType;
import tr.com.obss.jss.jwtdemo.repository.RoleRepository;
import tr.com.obss.jss.jwtdemo.service.RoleService;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  @Override
  public Role findByName(RoleType name) {
    Objects.requireNonNull(name, "role name cannot be null");
    return roleRepository.findByName(name).orElseThrow(RoleNotFoundException::new);
  }
}
