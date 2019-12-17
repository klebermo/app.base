package com.kleber.app.model.usuario;

import java.beans.PropertyEditorSupport;
import com.kleber.app.AppContextHolder;

public class UsuarioEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) {
    if (!text.equals("")) {
      Integer id = Integer.parseInt(text);
      UsuarioService serv = new UsuarioService();
      AppContextHolder.getContext().getAutowireCapableBeanFactory().autowireBean(serv);
      Usuario usuario = (Usuario) serv.findBy("id", id);
      setValue(usuario);
    } else {
      setValue(null);
    }
  }
}
