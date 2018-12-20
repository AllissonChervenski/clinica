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

import com.myapp.controller.SalvarProntuarioController;
import com.myapp.model.Prontuario;

public class CadastroProntuario extends JFrame
{

    public static final Dimension TAMANHO = new Dimension(600, 400);

    private JPanel painelPrincipal;
    private Prontuario prontuario;

    private JPanel painelConteudo;
    private JLabel labelObjetivo;
    private JLabel labelSubjetivo;
    private JLabel labelAvaliacao;
    private JButton btSalvar;
    private JTextField objetivoTextField;
    private JTextField subjetivoTextField;
    private JTextField avaliacaoTextField;
    private JButton novoProntuario;

    public CadastroProntuario(Prontuario prontuario) {
        setTitle("Cadastrar Prontuario");
        this.prontuario = prontuario;
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
//		painelConteudo.setLayout(new GridLayout(2,2));

        labelObjetivo = new JLabel("Objetivo:");
        labelObjetivo.setSize(100, 20);
        labelObjetivo.setLocation(10, 20);
        painelConteudo.add(labelObjetivo);

        objetivoTextField = new JTextField();
        objetivoTextField.setSize(400, 20);
        objetivoTextField.setLocation(150, 20);
        painelConteudo.add(objetivoTextField);

        labelSubjetivo = new JLabel("Subjetivo:");
        labelSubjetivo.setSize(100, 20);
        labelSubjetivo.setLocation(10, 50);
        painelConteudo.add(labelSubjetivo);

        subjetivoTextField = new JTextField();
        subjetivoTextField.setSize(400, 20);
        subjetivoTextField.setLocation(150, 50);
        painelConteudo.add(subjetivoTextField);

        labelAvaliacao = new JLabel("Avaliacao:");
        labelAvaliacao.setSize(100, 20);
        labelAvaliacao.setLocation(10, 80);
        painelConteudo.add(labelAvaliacao);

        avaliacaoTextField = new JTextField();
        avaliacaoTextField.setSize(400, 20);
        avaliacaoTextField.setLocation(150, 80);
        painelConteudo.add(avaliacaoTextField);

        painelPrincipal.add(painelConteudo);

        ActionListener al = new SalvarProntuarioController(this, prontuario);

        btSalvar.addActionListener(al);

        novoProntuario = new JButton("Novo");
        jp.add(novoProntuario);

        novoProntuario.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                novoProntuario();
            }
        });

    }

    public static void main(String args[]) {
        Prontuario p = new Prontuario();
//        p.setObjetivo("braço");

        CadastroProntuario cf = new CadastroProntuario(p);
        cf.editProntuario();
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

    public JButton getBtSalvar() {
        return btSalvar;
    }

    public void setBtSalvar(JButton btSalvar) {
        this.btSalvar = btSalvar;
    }

    public JTextField getObjetivoTextField() {
        return objetivoTextField;
    }

    public void setObjetivoTextField(JTextField objetivoTextField) {
        this.objetivoTextField = objetivoTextField;
    }

    public JTextField getSubjetivoTextField() {
        return subjetivoTextField;
    }

    public void setSubjetivoTextField(JTextField subjetivoTextField) {
        this.subjetivoTextField = subjetivoTextField;
    }

    public JTextField getAvaliacaoTextField() {
        return avaliacaoTextField;
    }

    public void setAvaliacaoTextField(JTextField avaliacaoTextField) {
        this.avaliacaoTextField = avaliacaoTextField;
    }

    public void notifyCadastroSucesso() {
        JOptionPane.showMessageDialog(this, "Prontuario " + "" + prontuario.getAvaliacao() + " " + "cadastrada com sucesso");
        setTitle("Edição de Prontuario");
        btSalvar.setText("Atualizar");
    }

    public void novoProntuario() {
        prontuario.setId(0);
        prontuario.setObjetivo("");
        prontuario.setAvaliacao("");
        prontuario.setSubjetivo("");

        editProntuario();
    }

    public void editProntuario() {
        getObjetivoTextField().setText(prontuario.getObjetivo());
        if (prontuario.getObjetivo() == null || prontuario.getObjetivo().trim().equals("")) {
            btSalvar.setText("Salvar");
        } else {
            btSalvar.setText("Atualizar");
        }
    }

    public void bindProntuario() {
        prontuario.setObjetivo(this.getObjetivoTextField().getText());
    }
}
