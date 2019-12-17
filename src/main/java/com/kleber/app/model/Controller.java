package com.kleber.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public abstract class Controller<E> {
  protected Class<E> clazz;

  @Autowired
  protected Service<E> serv;

  public Controller(Class<E> clazz) {
    this.clazz = clazz;
  }

  @RequestMapping(value="/", method=RequestMethod.GET)
  @PreAuthorize("hasPermission(#user, 'consulta_'+#this.this.name)")
  public String index(Model model) {
    return "admin/index";
  }

  @RequestMapping(value = "/insert", method=RequestMethod.GET)
  @PreAuthorize("hasPermission(#user, 'cadastra_'+#this.this.name)")
  public String insert(Model model) throws InstantiationException, IllegalAccessException {
    model.addAttribute("command", serv.newObject());
    model.addAttribute("action", "insert");
    return "admin/form";
  }

  @RequestMapping(value = "/insert", method=RequestMethod.POST)
  @ResponseBody
  @PreAuthorize("hasPermission(#user, 'cadastra_'+#this.this.name)")
  public void insert(@Valid E object, BindingResult result) {
    serv.insert(object);
  }

  @RequestMapping(value = "/update", method=RequestMethod.GET)
  @PreAuthorize("hasPermission(#user, 'atualiza_'+#this.this.name)")
  public String update(Model model, @RequestParam(value="id") String id) {
    model.addAttribute("command", serv.findBy("id", new Integer(id)));
    model.addAttribute("action", "update");
    return "admin/form";
  }

  @RequestMapping(value = "/update", method=RequestMethod.POST)
  @ResponseBody
  @PreAuthorize("hasPermission(#user, 'atualiza_'+#this.this.name)")
  public void update(@Valid E object, BindingResult result) {
    serv.update(object);
  }

  @RequestMapping(value = "/delete", method=RequestMethod.GET)
  @PreAuthorize("hasPermission(#user, 'remove_'+#this.this.name)")
  public String delete(Model model, @RequestParam(value="id") String id) {
    model.addAttribute("command", serv.findBy("id", new Integer(id)));
    model.addAttribute("action", "delete");
    return "admin/delete";
  }

  @RequestMapping(value = "/delete", method=RequestMethod.POST)
  @ResponseBody
  @PreAuthorize("hasPermission(#user, 'remove_'+#this.this.name)")
  public void delete(@Valid E object, BindingResult result) {
    serv.delete(object);
  }

  @RequestMapping(value="/list.json", method=RequestMethod.GET)
  @ResponseBody
  public String list() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(serv.select());
  }

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(com.kleber.app.model.autorizacao.Autorizacao.class, new com.kleber.app.model.autorizacao.AutorizacaoEditor());
    binder.registerCustomEditor(com.kleber.app.model.credencial.Credencial.class, new com.kleber.app.model.credencial.CredencialEditor());
    binder.registerCustomEditor(com.kleber.app.model.usuario.Usuario.class, new com.kleber.app.model.usuario.UsuarioEditor());

    binder.registerCustomEditor(java.util.Date.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) {
        if (!text.equals("")) {
          try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date data = df.parse(text);
            setValue(data);
          } catch (ParseException e) {
            setValue(null);
          }
        } else {
          setValue(null);
        }
      }
    });

    binder.registerCustomEditor(java.lang.Float.class, new PropertyEditorSupport() {
      @Override
      public void setAsText(String text) {
        if (!text.equals("")) {
          Float number = Float.parseFloat(text);
          setValue(number);
        } else {
          setValue(null);
        }
      }
    });
  }
}
