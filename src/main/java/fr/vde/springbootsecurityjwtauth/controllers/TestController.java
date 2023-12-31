package fr.vde.springbootsecurityjwtauth.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("test")
public class TestController {

  @GetMapping("all")
  public String allAccess() { return "Contenu public."; }

  @GetMapping("user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() { return "Contenu User"; }

  @GetMapping("admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() { return "Contenu ADMIN"; }

  @GetMapping("mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() { return "Contenu MODERATOR"; }

}
