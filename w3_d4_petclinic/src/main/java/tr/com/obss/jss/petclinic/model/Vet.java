package tr.com.obss.jss.petclinic.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Vet extends Person {

  @OneToMany(fetch = FetchType.LAZY)
  private List<Specialty> specialties;
}
