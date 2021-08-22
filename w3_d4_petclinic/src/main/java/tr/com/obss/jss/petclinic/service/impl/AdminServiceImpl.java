package tr.com.obss.jss.petclinic.service.impl;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tr.com.obss.jss.petclinic.model.Admin;
import tr.com.obss.jss.petclinic.repository.AdminRepository;
import tr.com.obss.jss.petclinic.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

  private AdminRepository adminRepository;

  @Autowired
  public AdminServiceImpl(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @Override
  public Admin createNewAdmin(Admin admin) {
    return null;
  }

  @Override
  public List<Admin> searchAdminsByName(String name) {
    return null;
  }

  @Override
  public Admin findById(Long adminId) {
    return null;
  }

  @Override
  public List<Admin> getAdmins(Integer page, Integer maxResult) {
    Objects.requireNonNull(page, "page cannot be null");
    Objects.requireNonNull(maxResult, "max_resut cannot be null");
    return adminRepository.findAll(PageRequest.of(page, maxResult)).getContent();
  }
}
