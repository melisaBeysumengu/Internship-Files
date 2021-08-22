package tr.com.obss.jss.petclinic.service;

import java.util.List;
import tr.com.obss.jss.petclinic.model.Vet;

public interface VetService {

  Vet createNewVet(Vet admin);

  List<Vet> searchVetsByName(String name);

  Vet findById(Long vetId);
}
