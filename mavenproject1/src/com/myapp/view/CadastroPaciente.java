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
import com.myapp.dao.PacienteDAO;
import com.myapp.dao.ProntuarioDAO;
import com.myapp.model.Endereco;
import com.myapp.model.Paciente;
import com.myapp.model.Prontuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroPaciente extends JFrame {

    public static final Dimension TAMANHO = new Dimension(600, 400);

    private JPanel painelPrincipal;
    private Paciente paciente;
    private JPanel painelConteudo;
    private JLabel labelNome;
    private JLabel labelTelefone;
    private JTextField telefoneTextField;
    private JTextField emailTextField;
    private JLabel labelEndereco;
    private JButton btSalvar;
    private JTextField nomeTextField;
    private JTextField enderecoTextField;
    private JButton novoPaciente;

    public CadastroPaciente(Paciente paciente) {
        setTitle("Cadastrar Paciente");
        this.paciente = paciente;
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
       

        enderecoTextField = new JTextField();
        enderecoTextField.setSize(400, 20);
        enderecoTextField.setLocation(150, 50);
        painelConteudo.add(enderecoTextField);

        //email
        labelEmail = new JLabel("Email:");
        labelEmail.setSize(200, 20);
        labelEmail.setLocation(10, 80);
        painelConteudo.add(labelEmail);

        emailTextField = new JTextField();
        emailTextField.setSize(400, 20);
        emailTextField.setLocation(150, 80);
        painelConteudo.add(emailTextField);

        //telefone
        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setSize(200, 20);
        labelTelefone.setLocation(10, 110);
        painelConteudo.add(labelTelefone);

        telefoneTextField = new JTextField();
        telefoneTextField.setSize(400, 20);
        telefoneTextField.setLocation(150, 110);
        painelConteudo.add(telefoneTextField);

        ActionListener al = new SalvarPacienteController(this, paciente);

        btSalvar.addActionListener(al);

        novoPaciente = new JButton("Nova");
        jp.add(novoPaciente);

        novoPaciente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    PacienteDAO dao = new PacienteDAO();
                    Paciente paciente = new Paciente();
                    paciente.setTelefone(telefoneTextField.getText());
                    paciente.setEmail(emailTextField.getText());
                    paciente.setNome(nomeTextField.getText());
//                    dao.insertPaciente(paciente);
                    //novoPaciente();
                
            }
        });

    }

    public static void main(String args[]) {
        Paciente p = new Paciente();
        p.setNome("Fabio");

        Endereco end = new Endereco();
        end.setRua("Jose Bonifácio");

        
        p.setEmail("paciente@gmail.com");
        p.setTelefone("99047583");
       
        p.setEndereco(end);

        CadastroPaciente cf = new CadastroPaciente(p);
        cf.editPaciente();
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
        JOptionPane.showMessageDialog(this, "Paciente " + "" + paciente.getNome() + " " + "cadastrado com sucesso");
        setTitle("Edição de paciente");
        btSalvar.setText("Atualizar");
    }

    public void novoPaciente() throws ParseException {
        paciente.setId(0);
        paciente.setNome("");
        paciente.getEndereco().setId(0);
        paciente.getEndereco().setRua("");
        paciente.setEmail("");
        paciente.setTelefone("");
        editPaciente();
    }
     public void bindPaciente() {
        paciente.setNome(this.getNomeTextField().getText());
        paciente.getEndereco().setRua(this.getEnderecoTextField().getText());
    }
    public void editPaciente() {
        getNomeTextField().setText(paciente.getNome());
        getEnderecoTextField().setText(paciente.getEndereco().getRua());
        getEmailTextField().setText(paciente.getEmail());
        getTelefoneTextField().setText(paciente.getTelefone());
        
        if (paciente.getNome() == null || paciente.getNome().trim().equals("")) {
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
}
