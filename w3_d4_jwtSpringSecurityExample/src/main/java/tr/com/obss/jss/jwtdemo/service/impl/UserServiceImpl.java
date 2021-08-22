package tr.com.obss.jss.jwtdemo.service.impl;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.obss.jss.jwtdemo.exception.UserNotFoundException;
import tr.com.obss.jss.jwtdemo.model.User;
import tr.com.obss.jss.jwtdemo.repository.UserRepository;
import tr.com.obss.jss.jwtdemo.service.UserService;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User createNewUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User findByUsername(String username) {
    Objects.requireNonNull(username, "username cannot be null");
    return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
  }

  @Override
  public Boolean existsByUsername(String username) {
    Objects.requireNonNull(username, "username cannot be null");
    return userRepository.existsByUsername(username);
  }

  @Override
  public Boolean existsByEmail(String email) {
    Objects.requireNonNull(email, "email cannot be null");
    return userRepository.existsByEmail(email);
  }
}
