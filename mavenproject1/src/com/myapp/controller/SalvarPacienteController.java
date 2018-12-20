package com.myapp.controller;

import com.myapp.model.Paciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.myapp.model.Pessoa;
import com.myapp.view.CadastroPaciente;

public class SalvarPacienteController implements ActionListener{

	
	private CadastroPaciente cadastroPaciente;
	
	private Paciente paciente;
	
	public SalvarPacienteController(CadastroPaciente cadastroPaciente, Paciente paciente) {
		this.paciente = paciente;
		this.cadastroPaciente = cadastroPaciente;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//Passo 1: recuperar dados da tela/view
		//Passo 2: passar os dados para dentro de paciente
		
		this.cadastroPaciente.bindPaciente();
		
		if(paciente.getNome() != null && !paciente.getNome().trim().equals("") ) {
			//Passo 3: salva essa p....
			System.out.println("Gravando dados do paciente " + paciente.getNome());
                        if(paciente.getEndereco() != null) {
                            System.out.println("Gravando dados do endereco do paciente " + paciente.getEndereco().getRua());
		
                        }
                        }
		
		
		cadastroPaciente.notifyCadastroSucesso();
	}

}
