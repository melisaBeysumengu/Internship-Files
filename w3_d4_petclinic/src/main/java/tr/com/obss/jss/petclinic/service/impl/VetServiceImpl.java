package tr.com.obss.jss.petclinic.service.impl;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.obss.jss.petclinic.model.Vet;
import tr.com.obss.jss.petclinic.repository.VetRepository;
import tr.com.obss.jss.petclinic.service.AdminService;
import tr.com.obss.jss.petclinic.service.VetService;

@Service
public class VetServiceImpl implements VetService {

  private VetRepository vetRepository;

  private AdminService adminService;

  @Autowired
  public VetServiceImpl(VetRepository vetRepository, AdminService adminService) {
    this.vetRepository = vetRepository;
    this.adminService = adminService;
  }

  @Override
  public Vet createNewVet(Vet vet) {
    Objects.requireNonNull(vet, "vet cannot be null");
    Objects.requireNonNull(vet.getName(), "vet name cannot be null");
    return vetRepository.save(vet);
  }

  @Override
  public List<Vet> searchVetsByName(String name) {
    return null;
  }

  @Override
  public Vet findById(Long vetId) {
    return null;
  }
}
