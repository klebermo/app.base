package com.kleber.app.model.credencial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("credencial")
public class CredencialController extends com.kleber.app.model.Controller<Credencial> {
  public CredencialController() {
    super(Credencial.class);
  }
}
