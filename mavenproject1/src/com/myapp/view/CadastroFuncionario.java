package com.myapp.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.myapp.controller.SalvarFuncionarioController;
import com.myapp.model.Empregado;
import com.myapp.model.Endereco;
import com.myapp.model.Pessoa;

public class CadastroFuncionario extends JFrame{

	public static final Dimension TAMANHO = new Dimension(600,400);
	
	private JPanel painelPrincipal;
	private Pessoa pessoa;

	private JPanel painelConteudo;
	private JLabel labelNome;
	private JLabel labelEndereco;
	private JButton btSalvar;
	private JTextField nomeTextField;
	private JTextField enderecoTextField;
	private JButton novaPessoa;
	
	
	public CadastroFuncionario(Pessoa pessoa) {
		setTitle("Cadastrar Funcion�rio");
		this.pessoa = pessoa;
		setSize(TAMANHO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painelPrincipal = new JPanel();
		setContentPane(painelPrincipal);
		btSalvar = new JButton("Salvar/Atualizar");
		
//		painelPrincipal.setLayout(null);
		painelPrincipal.setLayout(new BorderLayout());
		btSalvar.setLocation(250, 0);
		btSalvar.setSize(100,20);
		
//		painelPrincipal.add(btSalvar,BorderLayout.SOUTH);
		
		JButton cancel = new JButton("Cancelar");
//		painelPrincipal.add(cancel,BorderLayout.SOUTH);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		jp.add(btSalvar);
		jp.add(cancel);
		painelPrincipal.add(jp,BorderLayout.SOUTH);
		
		painelConteudo = new JPanel();
		painelConteudo.setSize(400,400);
		painelConteudo.setLocation(0, 0);
		painelConteudo.setLayout(null);
//		painelConteudo.setLayout(new GridLayout(2,2));
		labelNome = new JLabel("Nome:");
		labelNome.setSize(100,20);
		labelNome.setLocation(10, 10);
		painelConteudo.add(labelNome);
		
		painelPrincipal.add(painelConteudo);
		
		nomeTextField = new JTextField();
		nomeTextField.setSize(100,20);
		nomeTextField.setLocation(110, 50);
		painelConteudo.add(nomeTextField);
		
		labelEndereco = new JLabel("Endere�o");
		painelConteudo.add(labelEndereco );
				
		
		
		enderecoTextField = new JTextField();
                enderecoTextField.setSize(100,20);
		enderecoTextField.setLocation(110, 20);
		painelConteudo.add(enderecoTextField);
		
		ActionListener al = new SalvarFuncionarioController(this,pessoa);
		
		btSalvar.addActionListener(al);
		
		
		novaPessoa = new JButton("Nova");
		jp.add(novaPessoa);
		
		novaPessoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				novaPessoa();
			}});
		
	}
	
	public static void main(String args[]) {
		Pessoa p = new Empregado();
		p.setNome("Fabio");
		
		Endereco end = new Endereco();
		end.setRua("Joz� Bonif�cio");
		
		p.setEndereco(end);
		
		CadastroFuncionario cf = new CadastroFuncionario(p);
		cf.editPessoa();
		cf.setVisible(true);
	}
	
	
	
	public JPanel getPainelPrincipal() {
		return painelPrincipal;
	}

	public void setPainelPrincipal(JPanel painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}

	public JPanel getPainelConteudo() {
		return painelConteudo;
	}

	public void setPainelConteudo(JPanel painelConteudo) {
		this.painelConteudo = painelConteudo;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public void setLabelNome(JLabel labelNome) {
		this.labelNome = labelNome;
	}

	public JLabel getLabelEndereco() {
		return labelEndereco;
	}

	public void setLabelEndereco(JLabel labelEndereco) {
		this.labelEndereco = labelEndereco;
	}

	public JButton getBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(JButton btSalvar) {
		this.btSalvar = btSalvar;
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public void setNomeTextField(JTextField nomeTextField) {
		this.nomeTextField = nomeTextField;
	}

	public JTextField getEnderecoTextField() {
		return enderecoTextField;
	}

	public void setEnderecoTextField(JTextField enderecoTextField) {
		this.enderecoTextField = enderecoTextField;
	}

	public void notifyCadastroSucesso() {
		JOptionPane.showMessageDialog(this,"Pessoa " + "" + pessoa.getNome()+ " " + "cadastrada com sucesso");
		setTitle("Edi��o de Funcion�rio");
		btSalvar.setText("Atualizar");
	}
	
	public void novaPessoa() {
		pessoa.setId(0);
		pessoa.setNome("");
		pessoa.getEndereco().setId(0);
		pessoa.getEndereco().setRua("");
		editPessoa();
	}
	
	public void editPessoa() {
		getNomeTextField().setText(pessoa.getNome());
		getEnderecoTextField().setText(pessoa.getEndereco().getRua());
		if(pessoa.getNome() == null || pessoa.getNome().trim().equals("")) {
			btSalvar.setText("Salvar");
		}else {
			btSalvar.setText("Atualizar");
		}
	}
	
	public void bindPessoa() {
		pessoa.setNome(this.getNomeTextField().getText());
		pessoa.getEndereco().setRua(this.getEnderecoTextField().getText());
	}
}
