package com.myapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.myapp.model.Pessoa;
import com.myapp.view.CadastroFuncionario;

public class SalvarFuncionarioController implements ActionListener{

	
	private CadastroFuncionario cadastroFuncionario;
	
	private Pessoa pessoa;
	
	public SalvarFuncionarioController(
			CadastroFuncionario cadastroFuncionario, 
			Pessoa pessoa) {
		
		this.pessoa=pessoa;
		this.cadastroFuncionario = cadastroFuncionario;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//Passo 1: recuperar dados da tela/view
		//Passo 2: passar os dados para dentro de pessoa
		
		this.cadastroFuncionario.bindPessoa();
		
		if(pessoa.getNome() != null && !pessoa.getNome().trim().equals("")) {
			//Passo 3: salva essa p....
			System.out.println("Gravando dados da pessoa " + pessoa.getNome());
			if(pessoa.getEndereco() != null) {
				System.out.println("Gravando dados do endereco da pessoa " + pessoa.getEndereco().getRua());
			}
		}
		
		cadastroFuncionario.notifyCadastroSucesso();
	}

}
