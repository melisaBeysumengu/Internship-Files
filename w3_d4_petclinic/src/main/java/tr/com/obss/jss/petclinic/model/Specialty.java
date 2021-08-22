package tr.com.obss.jss.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Specialty extends BaseEntity {

  @NotNull
  private String name;

  @Column(length = 500)
  private String description;
}
