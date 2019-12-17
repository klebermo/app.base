package com.kleber.app.model.autorizacao;

import java.beans.PropertyEditorSupport;
import com.kleber.app.AppContextHolder;

public class AutorizacaoEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) {
    if (!text.equals("")) {
      Integer id = Integer.parseInt(text);
      AutorizacaoService serv = new AutorizacaoService();
      AppContextHolder.getContext().getAutowireCapableBeanFactory().autowireBean(serv);
      Autorizacao usuario = (Autorizacao) serv.findBy("id", id);
      setValue(usuario);
    } else {
      setValue(null);
    }
  }
}
