package tr.com.obss.jss.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.jss.petclinic.model.Vet;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {}
