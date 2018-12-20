package com.myapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.myapp.model.Pessoa;
import com.myapp.view.CadastroEmpregado;

public class SalvarEmpregadoController implements ActionListener
{

    private CadastroEmpregado cadastroEmpregado;

    private Pessoa empregado;

    public SalvarEmpregadoController(CadastroEmpregado cadastroEmpregado, Pessoa empregado) {

        this.empregado = empregado;
        this.cadastroEmpregado = cadastroEmpregado;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        //Passo 1: recuperar dados da tela/view
        //Passo 2: passar os dados para dentro de empregado

        this.cadastroEmpregado.bindPessoa();

        if (empregado.getNome()!= null && !empregado.getNome().trim().equals("")) {
            //Passo 3: salva essa p....
            System.out.println("Gravando dados da paciente " + empregado.getNome());
            if (empregado.getEndereco() != null) {
                System.out.println("Gravando dados do endereco da paciente " + empregado.getEndereco().getRua());
            }
        }

        cadastroEmpregado.notifyCadastroSucesso();
    }

}
