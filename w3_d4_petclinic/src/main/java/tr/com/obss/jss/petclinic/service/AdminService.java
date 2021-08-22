package tr.com.obss.jss.petclinic.service;

import java.util.List;
import tr.com.obss.jss.petclinic.model.Admin;

public interface AdminService {

  Admin createNewAdmin(Admin admin);

  List<Admin> searchAdminsByName(String name);

  Admin findById(Long adminId);

  List<Admin> getAdmins(Integer page, Integer maxResult);
}
