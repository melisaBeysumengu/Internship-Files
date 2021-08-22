package tr.com.obss.jss.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

  @NotNull
  private String name;

  @NotNull
  private String surname;

  @Column(length = 500)
  private String address;

  private String city;
}
