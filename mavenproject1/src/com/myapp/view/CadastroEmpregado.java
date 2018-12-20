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

import com.myapp.controller.SalvarEmpregadoController;
import com.myapp.dao.EmpregadoDAO;
import com.myapp.model.Empregado;
import com.myapp.model.Pessoa;

public class CadastroEmpregado extends JFrame
{

    public static final Dimension TAMANHO = new Dimension(600, 400);

    private JPanel painelPrincipal;
    private Pessoa pessoa;
    private JPanel painelConteudo;
    private JLabel labelNome;
    private JLabel labelSalarioBase;
//    private JButton btSalvar;
    private JTextField salarioBaseTextField;

    private JButton novaPessoa;

    public CadastroEmpregado(Pessoa pessoa) {
        setTitle("Cadastrar Empregado");
        this.pessoa = pessoa;
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
        //painelConteudo.setLayout(new GridLayout(2,2));

        labelSalarioBase = new JLabel("Salario Base:");
        labelSalarioBase.setSize(100, 20);
        labelSalarioBase.setLocation(10, 50);
        painelConteudo.add(labelSalarioBase);

        salarioBaseTextField = new JTextField();
        salarioBaseTextField.setSize(400, 20);
        salarioBaseTextField.setLocation(150, 50);
        painelConteudo.add(salarioBaseTextField);

        painelPrincipal.add(painelConteudo);

        ActionListener al = new SalvarEmpregadoController(this, pessoa);

        

        novaPessoa = new JButton("Salvar");
        jp.add(novaPessoa);
        
        novaPessoa.addActionListener(al);

        novaPessoa.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                EmpregadoDAO dao = new EmpregadoDAO();
                Empregado empregados = new Empregado();
                float salarioBase = Float.parseFloat(salarioBaseTextField.getText());
                empregados.setSalarioBase(salarioBase);

                dao.insertEmpregado(empregados);
                novaPessoa();
            }
        });

    }

    public static void main(String args[]) {
        Empregado emp = new Empregado();
//        p.setNome("Fabio");
//
//        Endereco end = new Endereco();
//        end.setRua("Joz� Bonif�cio");

//        p.setEndereco(end);

        CadastroEmpregado ce = new CadastroEmpregado(emp);
//        ce.editPessoa();
        ce.setVisible(true);
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

    public JLabel getLabelSalarioBase() {
        return labelSalarioBase;
    }

    public void setLabelEndereco(JLabel labelEndereco) {
        this.labelSalarioBase = labelEndereco;
    }

//    public JButton getBtSalvar() {
//        return btSalvar;
//    }
//
//    public void setBtSalvar(JButton btSalvar) {
//        this.btSalvar = btSalvar;
//    }

    public JTextField getSalarioBaseTextField() {
        return salarioBaseTextField;
    }

    public void setNomeTextField(JTextField nomeTextField) {
        this.salarioBaseTextField = nomeTextField;
    }

    public void notifyCadastroSucesso() {
        JOptionPane.showMessageDialog(this, "Pessoa " + "" + pessoa.getNome() + " " + "cadastrada com sucesso");
        setTitle("Edi��o de Funcion�rio");
//        btSalvar.setText("Atualizar");
    }

    public void novaPessoa() {
        pessoa.setId(0);
        pessoa.setNome("");
        pessoa.getEndereco().setRua("");
//        editPessoa();
    }

//    public void editPessoa() {
//        getSalarioBaseTextField().setText(pessoa.getNome());
//        getSalarioBaseTextField().setText(pessoa.getEndereco().getRua());
//        if (pessoa.getNome() == null || pessoa.getNome().trim().equals("")) {
//            btSalvar.setText("Salvar");
//        } else {
//            btSalvar.setText("Atualizar");
//        }
//    }

    public void bindPessoa() {
        pessoa.setNome(this.getSalarioBaseTextField().getText());
        pessoa.getEndereco().setRua(this.getSalarioBaseTextField().getText());
    }
}
