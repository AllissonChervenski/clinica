
package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Receita
{
    @Id
    @GeneratedValue
    private int id;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "id_prontuario")
    private Prontuario pronturario;

    public Prontuario getPronturario() {
        return pronturario;
    }

    public void setPronturario(Prontuario pronturario) {
        this.pronturario = pronturario;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    
}
