package com.myapp.dao;

import com.myapp.model.Empregado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpregadoDAO {

    public boolean insertEmpregado(Empregado item) {
        String sql = "INSERT INTO `empregado` (`id_pessoa`, `salarioBase`) VALUES(1, ? )";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1, item.getSalarioBase());
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<String[]> selectAll() {
        String sql = "SELECT * FROM empregado";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        Statement stmt = null;

        List<String[]> listDados = new ArrayList();

        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String[] dados = new String[1];
                dados[0] = rs.getString("salarioBase");
                listDados.add(dados);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
        return listDados;
    }

    public boolean updateEmpregado(Empregado item) {
        String sql = "UPDATE `empregado` SET `salarioBase` = ? WHERE `empregado`.`id` = ? ";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setFloat(1, item.getSalarioBase());
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteEmpregado(Empregado item) {
        String sql = "DELETE FROM `empregado` WHERE `empregado`.`id` = ? ";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, item.getId());
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
