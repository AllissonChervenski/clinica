package com.myapp.dao;

import com.myapp.model.Endereco;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    public boolean insertEndereco(Endereco item, int id) {
        String sql = "INSERT INTO `endereco` (`rua`) VALUES( ? )";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, item.getRua());
            ps.setString(2, item.getBairro());
            ps.setString(3, item.getUf());
            ps.setInt(4, item.getNumero());
            ps.setString(5, item.getCidade());
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<String[]> selectAll() {
        String sql = "SELECT * FROM endereco";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        Statement stmt = null;

        List<String[]> listDados = new ArrayList();

        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("rua");
                dados[1] = rs.getString("bairro");
                dados[2] = rs.getString("uf");
                dados[3] = rs.getString("numero");
                dados[4] = rs.getString("cidade");
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

    public boolean updateEndereco(Endereco item) {
        String sql = "UPDATE `endereco` SET `rua` = ? , `bairro` = ? , `uf` = ? , `numero` = ? , `cidade` = ? WHERE `endereco`.`id` = ? ";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, item.getRua());
            ps.setString(2, item.getBairro());
            ps.setString(3, item.getUf());
            ps.setString(4, item.getCidade());
            ps.setInt(5, item.getNumero());
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteEndereco(Endereco item) {
        String sql = "DELETE FROM `endereco` WHERE `endereco`.`id` = ? ";
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
