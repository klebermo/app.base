package com.kleber.app.model.usuario;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends com.kleber.app.model.Service<Usuario> {
  public UsuarioService() {
    super(Usuario.class);
  }
}
