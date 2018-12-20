package com.myapp.dao;

import com.myapp.model.Prontuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO
{

    public boolean insertProntuario(Prontuario item) {
        String sql = "INSERT INTO `prontuario` (`id_paciente`, `id_medico`, `avaliacao`, `subjetivo`, `objetivo`) VALUES(1, 1, ?, ?, ? )";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, item.getAvaliacao());
            ps.setString(2, item.getObjetivo());
            ps.setString(3, item.getSubjetivo());
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String[]> selectAll() {
        String sql = "SELECT * FROM prontuario";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        Statement stmt = null;

        List<String[]> listDados = new ArrayList();

        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String[] dados = new String[3];
                dados[0] = rs.getString("avaliacao");
                dados[1] = rs.getString("objetivo");
                dados[2] = rs.getString("subjetivo");
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

    public boolean updateProntuario(Prontuario item) {
        String sql = "UPDATE `prontuario` SET `avaliacao` = ?, `objetivo` = ?, `subjetivo` = ? WHERE `prontuario`.`id` = ? ";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, item.getAvaliacao());
            ps.setString(2, item.getObjetivo());
            ps.setString(3, item.getSubjetivo());
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteProntuario(Prontuario item) {
        String sql = "DELETE FROM `prontuario` WHERE `prontuario`.`id` = ? ";
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
