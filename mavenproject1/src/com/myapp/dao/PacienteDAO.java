package com.myapp.dao;

import com.myapp.model.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public boolean insertPaciente(Paciente item) {
<<<<<<< Updated upstream
        String sql = "INSERT INTO `paciente` (`id_pessoa`, `nascimento`, `email`,`telefone`) VALUES( 1 , ? , ? ,?)";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDate(1, (Date) item.getNascimento());
            ps.setString(2, item.getEmail());
            ps.setString(3, item.getTelefone());
=======
        String sql = "INSERT INTO `paciente` ( `email`,`telefone`) VALUES( ? , ? ,?)";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, item.getEmail());
            ps.setString(2, item.getTelefone());
>>>>>>> Stashed changes
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<String[]> selectAll() {
        String sql = "SELECT * FROM paciente";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        Statement stmt = null;

        List<String[]> listDados = new ArrayList();

        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String[] dados = new String[2];
                dados[0] = rs.getString("email");
                dados[1] = rs.getString("telefone");
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

    public boolean updatePaciente(Paciente item) {
        String sql = "UPDATE `paciente` SET  `email` = ? , `telefone` = ? WHERE `paciente`.`id` = ? ";
        java.sql.Connection conexao = ConnectDataBase.getConexao();
        try {
            java.sql.PreparedStatement ps = conexao.prepareStatement(sql);
<<<<<<< Updated upstream
            ps.setDate(1, (Date) item.getNascimento());
            ps.setString(2, item.getEmail());
            ps.setString(3, item.getTelefone());
=======
            ps.setString(1, item.getEmail());
            ps.setString(2, item.getTelefone());
>>>>>>> Stashed changes
            ps.execute();
            ConnectDataBase.fecharConexao();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deletePaciente(Paciente item) {
        String sql = "DELETE FROM `paciente` WHERE `paciente`.`id` = ? ";
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
