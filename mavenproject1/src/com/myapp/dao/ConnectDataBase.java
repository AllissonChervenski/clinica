/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

/**
 *
 * @author Mauricio Escobar
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDataBase {

    private static java.sql.Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost/clinica";
    private static final String USUARIO = "root";
    private static final String SENHA = "";  

    public static java.sql.Connection getConexao() {
        if (conexao == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("deu ruim class not found");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("deu ruim SQLException");
            }

        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException e) {
                Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, e);
            }

        }
    }

}
