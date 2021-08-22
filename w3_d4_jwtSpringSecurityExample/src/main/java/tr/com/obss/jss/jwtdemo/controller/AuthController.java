package tr.com.obss.jss.jwtdemo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.obss.jss.jwtdemo.dto.JwtResponse;
import tr.com.obss.jss.jwtdemo.dto.LoginRequest;
import tr.com.obss.jss.jwtdemo.dto.MessageResponse;
import tr.com.obss.jss.jwtdemo.dto.SignupRequest;
import tr.com.obss.jss.jwtdemo.model.Role;
import tr.com.obss.jss.jwtdemo.model.RoleType;
import tr.com.obss.jss.jwtdemo.model.User;
import tr.com.obss.jss.jwtdemo.security.JwtUtils;
import tr.com.obss.jss.jwtdemo.security.MyUserDetails;
import tr.com.obss.jss.jwtdemo.service.RoleService;
import tr.com.obss.jss.jwtdemo.service.UserService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;

  private final UserService userService;

  private final RoleService roleService;

  private final PasswordEncoder encoder;

  private final JwtUtils jwtUtils;

  @PostMapping("/signin")
  public JwtResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                                                                                                               loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
    return JwtResponse
        .builder()
        .token(jwt)
        .id(userDetails.getId())
        .username(userDetails.getUsername())
        .email(userDetails.getEmail())
        .roles(roles)
        .build();
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userService.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userService.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account

    User user = User
        .builder()
        .username(signUpRequest.getUsername())
        .email(signUpRequest.getEmail())
        .password(encoder.encode(signUpRequest.getPassword()))
        .build();

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleService.findByName(RoleType.ROLE_USER);
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "admin":
            Role adminRole = roleService.findByName(RoleType.ROLE_ADMIN);
            roles.add(adminRole);

            break;

          default:
            Role userRole = roleService.findByName(RoleType.ROLE_USER);
            roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userService.createNewUser(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
