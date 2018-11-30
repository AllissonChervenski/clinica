package com.myapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.myapp.model.Prontuario;
import com.myapp.view.CadastroProntuario;

public class SalvarProntuarioController implements ActionListener{

	
	private CadastroProntuario cadastroFuncionario;
	
	private Prontuario prontuario;
	
	public SalvarProntuarioController(
			CadastroProntuario cadastroFuncionario, 
			Prontuario prontuario) {
		
		this.prontuario = prontuario;
		this.cadastroFuncionario = cadastroFuncionario;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//Passo 1: recuperar dados da tela/view
		//Passo 2: passar os dados para dentro de pessoa
		
		this.cadastroFuncionario.bindProntuario();
		
		if(prontuario.getObjetivo() != null && !prontuario.getObjetivo().trim().equals("")) {
			//Passo 3: salva essa p....
			System.out.println("Gravando dados da prontuario " + prontuario.getObjetivo());
		}
		
		cadastroFuncionario.notifyCadastroSucesso();
	}

}
