/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author ultra
 */
@Entity
public class PessoaEndereco {
    @Id
    @GeneratedValue
    private int id;
    
    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    
    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "id_endereco")
    private Endereco ender;
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEnder() {
        return ender;
    }

    public void setEnder(Endereco ender) {
        this.ender = ender;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
