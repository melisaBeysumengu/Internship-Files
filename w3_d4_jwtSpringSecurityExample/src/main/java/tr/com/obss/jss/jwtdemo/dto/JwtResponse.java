package tr.com.obss.jss.jwtdemo.dto;

import java.util.List;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class JwtResponse {

  private String token;

  @Default
  private String type = "Bearer";

  private Long id;

  private String username;

  private String email;

  private List<String> roles;
}
