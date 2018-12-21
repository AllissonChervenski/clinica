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
import com.myapp.model.Paciente;
import com.myapp.dao.PacienteDAO;

public class CadastroPaciente extends JFrame
{

    public static final Dimension TAMANHO = new Dimension(600, 400);

    private JPanel painelPrincipal;
    private Paciente paciente;

    private JPanel painelConteudo;
    private JLabel labelEmail;
    private JLabel labelTelefone;
    private JTextField emailTextField;
    private JTextField telefoneTextField;
    private JButton novoPaciente;

    public CadastroPaciente(Paciente paciente) {

        setTitle("Cadastrar Paciente");
        this.paciente = paciente;
        setSize(TAMANHO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painelPrincipal = new JPanel();
        setContentPane(painelPrincipal);
//        btSalvar = new JButton("Salvar/Atualizar");

//		painelPrincipal.setLayout(null);
        painelPrincipal.setLayout(new BorderLayout());
//        btSalvar.setLocation(250, 0);
//        btSalvar.setSize(100, 20);

//		painelPrincipal.add(btSalvar,BorderLayout.SOUTH);
        JButton cancel = new JButton("Cancelar");
//		painelPrincipal.add(cancel,BorderLayout.SOUTH);

        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());

//        jp.add(btSalvar);
        jp.add(cancel);
        painelPrincipal.add(jp, BorderLayout.SOUTH);

        painelConteudo = new JPanel();
        painelConteudo.setSize(400, 400);
        painelConteudo.setLocation(0, 0);
        painelConteudo.setLayout(null);
//		painelConteudo.setLayout(new GridLayout(2,2));

        labelEmail = new JLabel("Email:");
        labelEmail.setSize(100, 20);
        labelEmail.setLocation(10, 20);
        painelConteudo.add(labelEmail);

        emailTextField = new JTextField();
        emailTextField.setSize(400, 20);
        emailTextField.setLocation(150, 20);
        painelConteudo.add(emailTextField);

        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setSize(100, 20);
        labelTelefone.setLocation(10, 50);
        painelConteudo.add(labelTelefone);

        telefoneTextField = new JTextField();
        telefoneTextField.setSize(400, 20);
        telefoneTextField.setLocation(150, 50);
        painelConteudo.add(telefoneTextField);

        painelPrincipal.add(painelConteudo);

        ActionListener al = new SalvarPacienteController(this, paciente);

//        btSalvar.addActionListener(al);
        novoPaciente = new JButton("Salvar");
        novoPaciente.setLocation(250, 0);
        novoPaciente.setSize(100, 20);
        jp.add(novoPaciente);

//        btSalvar.addActionListener(new ActionListener()
//        {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ProntuarioDAO dao = new ProntuarioDAO();
//                Prontuario prontuarios = new Prontuario();
//
//                prontuarios.setAvaliacao(avaliacaoTextField.getText());
//                prontuarios.setObjetivo(objetivoTextField.getText());
//                prontuarios.setSubjetivo(subjetivoTextField.getText());
//
//                dao.insertProntuario(prontuarios);
////                novoProntuario();
//            }
//        });
        novoPaciente.addActionListener(al);

        novoPaciente.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteDAO dao = new PacienteDAO();
                Paciente pacientes = new Paciente();
                
                pacientes.setEmail(emailTextField.getText());
                pacientes.setTelefone(telefoneTextField.getText());

                dao.insertPaciente(pacientes);
//                novoProntuario();
            }
        });

    }

    public static void main(String args[]) {
        Paciente p = new Paciente();
//        p.setObjetivo("braço");

        CadastroPaciente cf = new CadastroPaciente(p);
//        cf.editProntuario();
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

//    public JButton getBtSalvar() {
//        return btSalvar;
//    }
//    public void setBtSalvar(JButton btSalvar) {
//        this.btSalvar = btSalvar;
//    }
    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JTextField getTelefoneTextField() {
        return telefoneTextField;
    }

    public void setTelefoneTextField(JTextField telefoneTextField) {
        this.telefoneTextField = telefoneTextField;
    }

    public void notifyCadastroSucesso() {
        JOptionPane.showMessageDialog(this, "Paciente " + "" + paciente.getEmail() + " " + "cadastrada com sucesso");
        setTitle("Edição de Paciente");
//        btSalvar.setText("Atualizar");
    }

    public void novoPaciente() {
        paciente.setEmail("");
        paciente.setTelefone("");

//        editProntuario();
    }

//    public void editProntuario() {
//        getObjetivoTextField().setText(prontuario.getObjetivo());
//        if (prontuario.getObjetivo() == null || prontuario.getObjetivo().trim().equals("")) {
//            btSalvar.setText("Salvar");
//        } else {
//            btSalvar.setText("Atualizar");
//        }
//    }
    public void bindPaciente() {
        paciente.setEmail(this.getEmailTextField().getText());
        paciente.setTelefone(this.getTelefoneTextField().getText());

    }
}
