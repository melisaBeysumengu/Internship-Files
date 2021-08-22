package tr.com.obss.jss.jwtdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.obss.jss.jwtdemo.model.User;
import tr.com.obss.jss.jwtdemo.security.MyUserDetails;
import tr.com.obss.jss.jwtdemo.service.UserService;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserService userService;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userService.findByUsername(username);

    return MyUserDetails.build(user);
  }
}
