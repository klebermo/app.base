package com.kleber.app.model.credencial;

import java.beans.PropertyEditorSupport;
import com.kleber.app.AppContextHolder;

public class CredencialEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) {
    if (!text.equals("")) {
      Integer id = Integer.parseInt(text);
      CredencialService serv = new CredencialService();
      AppContextHolder.getContext().getAutowireCapableBeanFactory().autowireBean(serv);
      Credencial usuario = (Credencial) serv.findBy("id", id);
      setValue(usuario);
    } else {
      setValue(null);
    }
  }
}
