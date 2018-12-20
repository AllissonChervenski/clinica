/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.model.Endereco;
import com.myapp.view.CadastroEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ultra
 */
public class SalvarEnderecoController implements ActionListener{
private CadastroEndereco cadastroEndereco;
private Endereco endereco;

public SalvarEnderecoController(CadastroEndereco cadastroEndereco, Endereco endereco){
    this.endereco = endereco;
    this.cadastroEndereco = cadastroEndereco;
}
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.cadastroEndereco.bindEndereco();
        if(endereco.getRua() != null && !endereco.getRua().trim().equals("") ) {
			//Passo 3: salva essa p....
			System.out.println("Gravando dados do endereco " + endereco.getRua());
                        if(endereco.getBairro() != null) {
                            System.out.println("Gravando dados do endereco do endereco " + endereco.getBairro());
                        }
    }
    }
}
    

