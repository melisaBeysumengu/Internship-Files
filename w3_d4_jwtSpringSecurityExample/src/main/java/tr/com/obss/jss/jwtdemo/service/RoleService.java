package tr.com.obss.jss.jwtdemo.service;

import tr.com.obss.jss.jwtdemo.model.Role;
import tr.com.obss.jss.jwtdemo.model.RoleType;

public interface RoleService {

  Role findByName(RoleType name);
}