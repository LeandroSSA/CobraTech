/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.dao;

/**
 *
 * @author leand
 */


import br.ba.fvc.mapeamento.Banco;
import br.ba.fvc.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

    public void inserir(Banco banco) {
        String sql = "INSERT INTO banco (codigodobanco, nomedobanco, nomedaagencia, numerodaagencia, numerodaconta) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, banco.getCodigoDoBanco());
            stmt.setString(2, banco.getNomeDoBanco());
            stmt.setString(3, banco.getNomeDaAgencia());
            stmt.setString(4, banco.getNumeroDaAgencia());
            stmt.setString(5, banco.getNumeroDaConta());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Banco> listar() {
        List<Banco> lista = new ArrayList<>();
        String sql = "SELECT * FROM banco";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setCodigo(rs.getInt("codigo"));
                banco.setCodigoDoBanco(rs.getString("codigodobanco"));
                banco.setNomeDoBanco(rs.getString("nomedobanco"));
                banco.setNomeDaAgencia(rs.getString("nomedaagencia"));
                banco.setNumeroDaAgencia(rs.getString("numerodaagencia"));
                banco.setNumeroDaConta(rs.getString("numerodaconta"));
                lista.add(banco);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void excluir(int codigo) {
        String sql = "DELETE FROM banco WHERE codigo = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Banco banco) {
        String sql = "UPDATE banco SET codigodobanco=?, nomedobanco=?, nomedaagencia=?, numerodaagencia=?, numerodaconta=? WHERE codigo=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, banco.getCodigoDoBanco());
            stmt.setString(2, banco.getNomeDoBanco());
            stmt.setString(3, banco.getNomeDaAgencia());
            stmt.setString(4, banco.getNumeroDaAgencia());
            stmt.setString(5, banco.getNumeroDaConta());
            stmt.setInt(6, banco.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
