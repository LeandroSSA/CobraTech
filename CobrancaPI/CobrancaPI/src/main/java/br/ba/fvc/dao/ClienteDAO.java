/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.dao;

/**
 *
 * @author leand
 */

import br.ba.fvc.mapeamento.Cliente;
import br.ba.fvc.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, endereco, cpf, cep, numero) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getCep());
            stmt.setString(5, cliente.getNumero());
            stmt.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome=?, endereco=?, cep=?, numero=? WHERE cpf=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getNumero());
            stmt.setString(5, cliente.getCpf());
            stmt.executeUpdate();

            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.executeUpdate();

            System.out.println("Cliente excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNumero(rs.getString("numero"));
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cliente> listarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNumero(rs.getString("numero"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
} 
