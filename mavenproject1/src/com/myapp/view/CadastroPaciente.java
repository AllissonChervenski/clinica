package com.myapp.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.myapp.controller.SalvarPacienteController;
import com.myapp.model.Endereco;
import com.myapp.model.Paciente;
import com.myapp.model.Pessoa;

public class CadastroPaciente extends JFrame {

    public static final Dimension TAMANHO = new Dimension(600, 400);

    private JPanel painelPrincipal;
    private Pessoa pessoa;
    private JPanel painelConteudo;
    private JLabel labelNome;
    private JLabel labelDataNascimento;
    private JLabel labelTelefone;
    private JTextField telefoneTextField;
    private JTextField emailTextField;
    private JLabel labelEndereco;
    private JButton btSalvar;
    private JTextField nomeTextField;
    private JTextField enderecoTextField;
    private JTextField dtnTextField;

    public JTextField getDtnTextField() {
        return dtnTextField;
    }

    public void setDtnTextField(JTextField dtnTextField) {
        this.dtnTextField = dtnTextField;
    }
    private JButton novaPessoa;

    public CadastroPaciente(Pessoa pessoa) {
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

        labelNome = new JLabel("Nome:");
        labelNome.setSize(100, 20);
        labelNome.setLocation(10, 20);
        painelConteudo.add(labelNome);

        nomeTextField = new JTextField();
        nomeTextField.setSize(400, 20);
        nomeTextField.setLocation(150, 20);
        painelConteudo.add(nomeTextField);

        painelPrincipal.add(painelConteudo);

        labelEndereco = new JLabel("Endereco:");
        labelEndereco.setSize(100, 20);
        labelEndereco.setLocation(10, 50);
        painelConteudo.add(labelEndereco);
        // data de nascimento email e telefone

        enderecoTextField = new JTextField();
        enderecoTextField.setSize(400, 20);
        enderecoTextField.setLocation(150, 50);
        painelConteudo.add(enderecoTextField);

        labelDataNascimento = new JLabel("Data de nascimento:");
        labelDataNascimento.setSize(200, 20);
        labelDataNascimento.setLocation(10, 80);
        painelConteudo.add(labelDataNascimento);

        dtnTextField = new JTextField();
        dtnTextField.setSize(400, 20);
        dtnTextField.setLocation(150, 80);
        painelConteudo.add(dtnTextField);

        //email
        labelEmail = new JLabel("Email:");
        labelEmail.setSize(200, 20);
        labelEmail.setLocation(10, 110);
        painelConteudo.add(labelEmail);

        emailTextField = new JTextField();
        emailTextField.setSize(400, 20);
        emailTextField.setLocation(150, 110);
        painelConteudo.add(emailTextField);

        //telefone
        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setSize(200, 20);
        labelTelefone.setLocation(10, 140);
        painelConteudo.add(labelTelefone);

        telefoneTextField = new JTextField();
        telefoneTextField.setSize(400, 20);
        telefoneTextField.setLocation(150, 140);
        painelConteudo.add(telefoneTextField);

        ActionListener al = new SalvarPacienteController(this, pessoa);

        btSalvar.addActionListener(al);

        novaPessoa = new JButton("Nova");
        jp.add(novaPessoa);

        novaPessoa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                novaPessoa();
            }
        });

    }

    public static void main(String args[]) {
        Pessoa p = new Paciente();
        p.setNome("Fabio");

        Endereco end = new Endereco();
        end.setRua("Joz� Bonif�cio");

        p.setEndereco(end);

        CadastroPaciente cf = new CadastroPaciente(p);
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
        JOptionPane.showMessageDialog(this, "Pessoa " + "" + pessoa.getNome() + " " + "cadastrada com sucesso");
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
        if (pessoa.getNome() == null || pessoa.getNome().trim().equals("")) {
            btSalvar.setText("Salvar");
        } else {
            btSalvar.setText("Atualizar");
        }
    }

    public JLabel getLabelEmail() {
        return labelEmail;
    }

    public void setLabelEmail(JLabel labelEmail) {
        this.labelEmail = labelEmail;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }
    private JLabel labelEmail;

    public JLabel getLabelTelefone() {
        return labelTelefone;
    }

    public void setLabelTelefone(JLabel labelTelefone) {
        this.labelTelefone = labelTelefone;
    }

    public JTextField getTelefoneTextField() {
        return telefoneTextField;
    }

    public void setTelefoneTextField(JTextField telefoneTextField) {
        this.telefoneTextField = telefoneTextField;
    }

    public void bindPessoa() {
        pessoa.setNome(this.getNomeTextField().getText());
        pessoa.getEndereco().setRua(this.getEnderecoTextField().getText());
    }

    public JLabel getLabelDataNascimento() {
        return labelDataNascimento;
    }

    public void setLabelDataNascimento(JLabel labelDataNascimento) {
        this.labelDataNascimento = labelDataNascimento;
    }
}
