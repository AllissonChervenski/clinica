/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.view;

import com.myapp.controller.SalvarEnderecoController;
import com.myapp.model.Endereco;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ultra
 */
public class CadastroEndereco extends JFrame {
     public static final Dimension TAMANHO = new Dimension(600, 400);
        private JPanel painelPrincipal;
        private JPanel painelConteudo;
        private JLabel labelRua;
        private JLabel labelNumero;
        private JLabel labelBairro;
        private JLabel labelUf;
        private JLabel labelCidade;
        private JTextField ruaJTextField;
        private JTextField numeroJTextField;
        private JTextField bairroJTextField;
        private JTextField ufJTextField;
        private JTextField cidadeJTextField;
        private JButton btSalvar;
        private JButton novoEndereco;
        private Endereco endereco;
        
        public CadastroEndereco(Endereco endereco) {
        setTitle("Cadastrar Endereco");
        this.endereco = endereco;
        setSize(TAMANHO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painelPrincipal = new JPanel();
        setContentPane(painelPrincipal);
        btSalvar = new JButton("Salvar/Atualizar");

//		painelPrincipal.setLayout(null);
        painelPrincipal.setLayout(new BorderLayout());
        btSalvar.setLocation(250, 0);
        btSalvar.setSize(100, 20);

//		painelPrincipal.add(btSalvar,BorderLayout.SOUTH);
        JButton cancel = new JButton("Cancelar");
//		painelPrincipal.add(cancel,BorderLayout.SOUTH);

        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());

        jp.add(btSalvar);
        jp.add(cancel);
        painelPrincipal.add(jp, BorderLayout.SOUTH);

        painelConteudo = new JPanel();
        painelConteudo.setSize(400, 400);
        painelConteudo.setLocation(0, 0);
        painelConteudo.setLayout(null);
        //painelConteudo.setLayout(new GridLayout(2,2));

        labelRua = new JLabel("Rua:");
        labelRua.setSize(100, 20);
        labelRua.setLocation(10, 20);
        painelConteudo.add(labelRua);

        ruaJTextField = new JTextField();
        ruaJTextField.setSize(400, 20);
        ruaJTextField.setLocation(150, 20);
        painelConteudo.add(ruaJTextField);

        painelPrincipal.add(painelConteudo);

        labelNumero = new JLabel("Numero:");
        labelNumero.setSize(100, 20);
        labelNumero.setLocation(10, 50);
        painelConteudo.add(labelNumero);
        // data de nascimento email e telefone

        numeroJTextField = new JTextField();
        numeroJTextField.setSize(400, 20);
        numeroJTextField.setLocation(150, 50);
        painelConteudo.add(numeroJTextField);

        labelBairro = new JLabel("Bairro");
        labelBairro.setSize(200, 20);
        labelBairro.setLocation(10, 80);
        painelConteudo.add(labelBairro);

        bairroJTextField = new JTextField();
        bairroJTextField.setSize(400, 20);
        bairroJTextField.setLocation(150, 80);
        painelConteudo.add(bairroJTextField);

        //email
        labelUf = new JLabel("UF:");
        labelUf.setSize(200, 20);
        labelUf.setLocation(10, 110);
        painelConteudo.add(labelUf);

        ufJTextField = new JTextField();
        ufJTextField.setSize(400, 20);
        ufJTextField.setLocation(150, 110);
        painelConteudo.add(ufJTextField);

        //telefone
        labelCidade = new JLabel("Cidade:");
        labelCidade.setSize(200, 20);
        labelCidade.setLocation(10, 140);
        painelConteudo.add(labelCidade);

        cidadeJTextField = new JTextField();
        cidadeJTextField.setSize(400, 20);
        cidadeJTextField.setLocation(150, 140);
        painelConteudo.add(cidadeJTextField);

        ActionListener al = new SalvarEnderecoController(this, endereco);

        btSalvar.addActionListener(al);

        novoEndereco = new JButton("Novo");
        jp.add(novoEndereco);

        novoEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novoEndereco();
            }
        });

    }
         public static void main(String args[]) {
        Endereco end = new Endereco();
   
        CadastroEndereco ce = new CadastroEndereco(end);
        ce.editEndereco();
        ce.setVisible(true);
    }
          public void notifyCadastroSucesso() {
        JOptionPane.showMessageDialog(this, "Endereco " + "" + endereco.getRua()+ " " + "cadastrado com sucesso");
        setTitle("Edição de endereco");
        btSalvar.setText("Atualizar");
    }

    public void novoEndereco() {
        endereco.setId(0);
        endereco.setRua("");
        endereco.setBairro("");
        endereco.setNumero(0);
        endereco.setUf("");
        endereco.setCidade("");
        editEndereco();
    }

    public void editEndereco() {
        getRuaJTextField().setText(endereco.getRua());
        getBairroJTextField().setText(endereco.getBairro());
        getCidadeJTextField().setText(endereco.getCidade());
        getUfJTextField().setText(endereco.getUf());
        getNumeroJTextField().setText(Integer.toString(endereco.getNumero()));
        if (endereco.getRua() == null || endereco.getRua().trim().equals("")) {
            btSalvar.setText("Salvar");
        } else {
            btSalvar.setText("Atualizar");
        }
    }
    
    public void bindEndereco() {
        endereco.setRua(this.getRuaJTextField().getText());
        endereco.setBairro(this.getBairroJTextField().getText());
        endereco.setCidade(this.getCidadeJTextField().getText());
        endereco.setNumero(Integer.parseInt(this.getNumeroJTextField().getText()));
        endereco.setUf(this.getUfJTextField().getText());
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

    public JLabel getLabelRua() {
        return labelRua;
    }

    public void setLabelRua(JLabel labelRua) {
        this.labelRua = labelRua;
    }

    public JLabel getLabelNumero() {
        return labelNumero;
    }

    public void setLabelNumero(JLabel labelNumero) {
        this.labelNumero = labelNumero;
    }

    public JLabel getLabelBairro() {
        return labelBairro;
    }

    public void setLabelBairro(JLabel labelBairro) {
        this.labelBairro = labelBairro;
    }

    public JLabel getLabelUf() {
        return labelUf;
    }

    public void setLabelUf(JLabel labelUf) {
        this.labelUf = labelUf;
    }

    public JLabel getLabelCidade() {
        return labelCidade;
    }

    public void setLabelCidade(JLabel labelCidade) {
        this.labelCidade = labelCidade;
    }

    public JTextField getRuaJTextField() {
        return ruaJTextField;
    }

    public void setRuaJTextField(JTextField ruaJTextField) {
        this.ruaJTextField = ruaJTextField;
    }

    public JTextField getNumeroJTextField() {
        return numeroJTextField;
    }

    public void setNumeroJTextField(JTextField numeroJTextField) {
        this.numeroJTextField = numeroJTextField;
    }

    public JTextField getBairroJTextField() {
        return bairroJTextField;
    }

    public void setBairroJTextField(JTextField bairroJTextField) {
        this.bairroJTextField = bairroJTextField;
    }

    public JTextField getUfJTextField() {
        return ufJTextField;
    }

    public void setUfJTextField(JTextField ufJTextField) {
        this.ufJTextField = ufJTextField;
    }

    public JTextField getCidadeJTextField() {
        return cidadeJTextField;
    }

    public void setCidadeJTextField(JTextField cidadeJTextField) {
        this.cidadeJTextField = cidadeJTextField;
    }

    public JButton getBtSalvar() {
        return btSalvar;
    }

    public void setBtSalvar(JButton btSalvar) {
        this.btSalvar = btSalvar;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
       
}
