/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.dao;

/**
 *
 * @author leand
 */

import br.ba.fvc.mapeamento.Credor;
import br.ba.fvc.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredorDAO {

    public void inserir(Credor credor) {
        String sql = "INSERT INTO credores (nome, cpf, cnpj, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, credor.getNome());
            stmt.setString(2, credor.getCpf());
            stmt.setString(3, credor.getCnpj());
            stmt.setString(4, credor.getTelefone());
            stmt.setString(5, credor.getEmail());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Credor> listar() {
        List<Credor> lista = new ArrayList<>();
        String sql = "SELECT * FROM credores";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Credor credor = new Credor();
                credor.setCodigo(rs.getInt("codigo"));
                credor.setNome(rs.getString("nome"));
                credor.setCpf(rs.getString("cpf"));
                credor.setCnpj(rs.getString("cnpj"));
                credor.setTelefone(rs.getString("telefone"));
                credor.setEmail(rs.getString("email"));
                lista.add(credor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void excluir(int codigo) {
        String sql = "DELETE FROM credores WHERE codigo = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Credor credor) {
        String sql = "UPDATE credores SET nome=?, cpf=?, cnpj=?, telefone=?, email=? WHERE codigo=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, credor.getNome());
            stmt.setString(2, credor.getCpf());
            stmt.setString(3, credor.getCnpj());
            stmt.setString(4, credor.getTelefone());
            stmt.setString(5, credor.getEmail());
            stmt.setInt(6, credor.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
