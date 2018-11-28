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

import com.myapp.controller.SalvarProntuarioController;
import com.myapp.model.Empregado;
import com.myapp.model.Endereco;
import com.myapp.model.Pessoa;
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
    private JLabel labelDta;
    private JButton btSalvar;
    private JTextField objetivoTextField;
    private JTextField subjetivoTextField;
    private JTextField avaliacaoTextField;
    private JTextField dtaTextField;
    private JButton novoProntuario;

    public CadastroProntuario(Pessoa pessoa)
    {
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

        painelPrincipal.add(painelConteudo);

        objetivoTextField = new JTextField();
        objetivoTextField.setSize(400, 20);
        objetivoTextField.setLocation(110, 20);
        painelConteudo.add(objetivoTextField);

        labelSubjetivo = new JLabel("Subjetivo:");
        labelSubjetivo.setSize(100, 20);
        labelSubjetivo.setLocation(10, 50);
        painelConteudo.add(labelSubjetivo);

        subjetivoTextField = new JTextField();
        subjetivoTextField.setSize(400, 20);
        subjetivoTextField.setLocation(110, 50);
        painelConteudo.add(subjetivoTextField);

        labelAvaliacao = new JLabel("Avaliação:");
        labelAvaliacao.setSize(100, 20);
        labelAvaliacao.setLocation(10, 80);
        painelConteudo.add(labelAvaliacao);

        avaliacaoTextField = new JTextField();
        avaliacaoTextField.setSize(400, 20);
        avaliacaoTextField.setLocation(110, 80);
        painelConteudo.add(avaliacaoTextField);

        labelDta = new JLabel("Data:");
        labelDta.setSize(100, 20);
        labelDta.setLocation(10, 110);
        painelConteudo.add(labelDta);

        dtaTextField = new JTextField();
        dtaTextField.setSize(400, 20);
        dtaTextField.setLocation(110, 110);
        painelConteudo.add(dtaTextField);

        ActionListener al = new SalvarProntuarioController(this, prontuario);

        btSalvar.addActionListener(al);

        novoProntuario = new JButton("Nova");
        jp.add(novoProntuario);

        novoProntuario.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                novoProntuario();
            }
        });

    }

    public static void main(String args[])
    {
        Prontuario p = new Prontuario();
        p.setObjetivo("Braço deslocado");
        p.setSubjetivo("Fratura no antebraço");
        p.setAvaliacao("Geso urgente para o braço");
    }

    public JPanel getPainelPrincipal()
    {
        return painelPrincipal;
    }

    public void setPainelPrincipal(JPanel painelPrincipal)
    {
        this.painelPrincipal = painelPrincipal;
    }

    public JPanel getPainelConteudo()
    {
        return painelConteudo;
    }

    public void setPainelConteudo(JPanel painelConteudo)
    {
        this.painelConteudo = painelConteudo;
    }

    public JLabel getLabelObjetivo()
    {
        return labelObjetivo;
    }

    public void setLabelObjetivo(JLabel labelObjetivo)
    {
        this.labelObjetivo = labelObjetivo;
    }

    public JTextField getObjetivoTextField()
    {
        return objetivoTextField;
    }

    public void setObjetivoTextField(JTextField objetivoTextField)
    {
        this.objetivoTextField = objetivoTextField;
    }

    public JTextField getSubjetivoTextField()
    {
        return subjetivoTextField;
    }

    public void setSubjetivoTextField(JTextField subjetivoTextField)
    {
        this.subjetivoTextField = subjetivoTextField;
    }

    public JTextField getAvaliacaoTextField()
    {
        return avaliacaoTextField;
    }

    public void setAvaliacaoTextField(JTextField avaliacaoTextField)
    {
        this.avaliacaoTextField = avaliacaoTextField;
    }

    public JLabel getLabelSubjetivo()
    {
        return labelSubjetivo;
    }

    public void setLabelSubjetivo(JLabel labelSubjetivo)
    {
        this.labelSubjetivo = labelSubjetivo;
    }

    public JLabel getLabelAvaliacao()
    {
        return labelAvaliacao;
    }

    public void setLabelAvaliacao(JLabel labelAvaliacao)
    {
        this.labelAvaliacao = labelAvaliacao;
    }

    public JLabel getLabelDta()
    {
        return labelDta;
    }

    public void setLabelDta(JLabel labelDta)
    {
        this.labelDta = labelDta;
    }

    public JButton getBtSalvar()
    {
        return btSalvar;
    }

    public void setBtSalvar(JButton btSalvar)
    {
        this.btSalvar = btSalvar;
    }

    public JTextField getNomeTextField()
    {
        return objetivoTextField;
    }

    public void setNomeTextField(JTextField nomeTextField)
    {
        this.objetivoTextField = nomeTextField;
    }

    public JTextField getEnderecoTextField()
    {
        return subjetivoTextField;
    }

    public void setEnderecoTextField(JTextField enderecoTextField)
    {
        this.subjetivoTextField = enderecoTextField;
    }

    public void notifyCadastroSucesso()
    {
        JOptionPane.showMessageDialog(this, "Prontuario " + "" + prontuario.getObjetivo() + " " + "cadastrado com sucesso");
        setTitle("Edicao de Prontuario");
        btSalvar.setText("Atualizar");
    }

    public void novoProntuario()
    {
        prontuario.setId(0);
        prontuario.setObjetivo("");
        prontuario.setSubjetivo("");
        prontuario.setAvaliacao("");
        editProntuario();
    }

    public void editProntuario()
    {
        getObjetivoTextField().setText(prontuario.getObjetivo());
        getSubjetivoTextField().setText(prontuario.getSubjetivo());
        getAvaliacaoTextField().setText(prontuario.getAvaliacao());

        if (prontuario.getObjetivo() == null || prontuario.getObjetivo().trim().equals("")) {
            btSalvar.setText("Salvar");
        } else {
            btSalvar.setText("Atualizar");
        }
    }

    public void bindProntuario()
    {
        prontuario.setObjetivo(this.getObjetivoTextField().getText());
        prontuario.setSubjetivo(this.getSubjetivoTextField().getText());
        prontuario.setAvaliacao(this.getAvaliacaoTextField().getText());
    }
}
