package tr.com.obss.jss.petclinic.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.obss.jss.petclinic.model.Admin;
import tr.com.obss.jss.petclinic.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

  private AdminService adminService;

  @Autowired
  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @GetMapping
  public List<Admin> getAdmins(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "max_result", defaultValue = "10") Integer maxResult) {
    return adminService.getAdmins(page, maxResult);
  }
}
