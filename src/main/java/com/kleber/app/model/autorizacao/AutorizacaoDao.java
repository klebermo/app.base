package com.kleber.app.model.autorizacao;

import com.kleber.app.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class AutorizacaoDao extends Dao<Autorizacao> {
  public AutorizacaoDao() {
    super(Autorizacao.class);
  }
}
