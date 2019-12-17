package com.kleber.app.model.autorizacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("autorizacao")
public class AutorizacaoController extends com.kleber.app.model.Controller<Autorizacao> {
  public AutorizacaoController() {
    super(Autorizacao.class);
  }
}
