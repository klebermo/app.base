package com.kleber.app.model.credencial;

import javax.persistence.Entity;
import com.kleber.app.model.Model;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.util.List;
import com.kleber.app.model.autorizacao.Autorizacao;

@Entity
public class Credencial extends Model {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String nome;

  @OneToMany(fetch = FetchType.EAGER)
  private List<Autorizacao> autorizacoes;

  @Override
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Autorizacao> getAutorizacoes() {
    return autorizacoes;
  }

  public void setAutorizacoes(List<Autorizacao> autorizacoes) {
    this.autorizacoes = autorizacoes;
  }

  @Override
  public String toString() {
    return nome;
  }
}
