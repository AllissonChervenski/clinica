package com.myapp.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.myapp.model.Prontuario;
import com.myapp.view.CadastroProntuario;

public class SalvarProntuarioController implements ActionListener{

	private CadastroProntuario cadastroProntuario;
	private Prontuario prontuario;
	
	public SalvarProntuarioController(CadastroProntuario cadastroProntuario, Prontuario prontuario) 
        {
		this.prontuario = prontuario;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
//		this.cadastroProntuario.bindProntuario();
//		if(prontuario.getObjetivo() != null && !prontuario.getObjetivo().trim().equals("")) {
//			System.out.println("Gravando dados da prontuario " + prontuario.getObjetivo());
//		}
////		
//		cadastroProntuario.notifyCadastroSucesso();
	}
}
