package tr.com.obss.jss.petclinic;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import tr.com.obss.jss.petclinic.model.Admin;
import tr.com.obss.jss.petclinic.model.Role;
import tr.com.obss.jss.petclinic.repository.AdminRepository;
import tr.com.obss.jss.petclinic.repository.RoleRepository;

@SpringBootTest
class PetclinicApplicationTests {

  @Autowired
  private AdminRepository adminRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Test
  void contextLoads() {

    final Role adminRole = roleRepository.save(Role.builder().name("ADMIN").build());

    final Role userRole = roleRepository.save(Role.builder().name("USER").build());

    final Role vetRole = roleRepository.save(Role.builder().name("VET").build());

    {
      final Admin admin = Admin.builder().name("mustafa").surname("güney").address("yenişehir").city("istanbul").roles(List.of(adminRole)).build();
      final Admin adminSaved = adminRepository.save(admin);
    }

    {
      final Admin adminEntity = Admin
          .builder()
          .name("şerafettin")
          .surname("kılkuyruk")
          .address("mars")
          .city("derin çukur")
          .roles(List.of(userRole))
          .build();
      final Admin adminEntitySaved = adminRepository.save(adminEntity);
    }

    adminRepository
        .findUserByCityProjection("istanbul", PageRequest.of(0, 12))
        .forEach(fullName -> System.out.println(fullName.getName() + " " + fullName.getSurname()));

    // adminRepository.findById(savedUser.getId());

    adminRepository.findAdminsByNameOrderBySurnameDesc("mustafa", PageRequest.of(0, 12));

    adminRepository.findUserByCity("istanbul", PageRequest.of(0, 12, Sort.by("name")));

    adminRepository.findUserByCityNative("istanbul");

    adminRepository.findAllByNameLike("jss");

    adminRepository.findUserByCityNested("asd");
  }
}
