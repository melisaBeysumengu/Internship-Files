package tr.com.obss.jss.petclinic.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@Entity
public class Admin extends Person {

  @OneToMany(fetch = FetchType.LAZY)
  private List<Role> roles;
}


