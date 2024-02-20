package com.howtodoinjava.demo.web;

import com.howtodoinjava.demo.security.basicauth.AppBasicAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @Autowired
  private AppBasicAuthenticationEntryPoint logoutHandler;

  @GetMapping("/hello")
  public String home(){
    return "Hello World !!";
  }

  @GetMapping("/public")
  public String publicResource(){
    return "Access allowed to all !!";
  }
}
