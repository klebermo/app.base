package com.kleber.app.model.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario")
public class UsuarioController extends com.kleber.app.model.Controller<Usuario> {
  public UsuarioController() {
    super(Usuario.class);
  }
}
