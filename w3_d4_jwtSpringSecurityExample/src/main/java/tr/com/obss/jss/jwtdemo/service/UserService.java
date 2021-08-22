package tr.com.obss.jss.jwtdemo.service;

import tr.com.obss.jss.jwtdemo.model.User;

public interface UserService {

  User createNewUser(User user);

  User findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
