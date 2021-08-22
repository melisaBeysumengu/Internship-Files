package tr.com.obss.jss.jwtdemo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.obss.jss.jwtdemo.model.Role;
import tr.com.obss.jss.jwtdemo.model.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(RoleType name);
}
