package tr.com.obss.jss.petclinic.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.obss.jss.petclinic.model.Vet;
import tr.com.obss.jss.petclinic.service.VetService;

@RestController
@RequestMapping("/api/vet")
public class VetController {

  private VetService vetService;

  @Autowired
  public VetController(VetService vetService) {
    this.vetService = vetService;
  }

  @PostMapping
  public Vet createNewVet(@RequestBody @Valid Vet vet) {
    return vetService.createNewVet(vet);
  }
}
