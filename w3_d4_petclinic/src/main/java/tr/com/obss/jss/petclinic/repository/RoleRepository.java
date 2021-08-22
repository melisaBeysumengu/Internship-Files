package tr.com.obss.jss.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import tr.com.obss.jss.petclinic.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {}
