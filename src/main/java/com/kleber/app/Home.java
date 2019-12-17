package com.kleber.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class Home {
  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/login")
  public String login() {
    return "index";
  }
}
