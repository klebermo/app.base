package com.kleber.app.model.credencial;

import com.kleber.app.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class CredencialDao extends Dao<Credencial> {
  public CredencialDao() {
    super(Credencial.class);
  }
}
