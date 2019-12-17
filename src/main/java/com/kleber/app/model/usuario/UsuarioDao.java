package com.kleber.app.model.usuario;

import com.kleber.app.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao extends Dao<Usuario> {
  public UsuarioDao() {
    super(Usuario.class);
  }
}
