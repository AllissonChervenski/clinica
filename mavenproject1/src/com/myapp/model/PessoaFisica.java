/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author ultra
 */
@Entity
public class PessoaFisica extends Pessoa{
    private String cpf;
    private String rg;
    @Id
    @GeneratedValue
    private int id;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
