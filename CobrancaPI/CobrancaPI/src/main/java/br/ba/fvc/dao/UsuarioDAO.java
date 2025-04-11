/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.dao;

/**
 *
 * @author leand
 */

import br.ba.fvc.mapeamento.Usuario;
import br.ba.fvc.util.Conexao;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.*;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome_usuario, senha, email) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome_usuario = ?, senha = ?, email = ? WHERE codigo = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getEmail());
            stmt.setInt(4, usuario.getCodigo());
            stmt.executeUpdate();

            System.out.println("Usuário alterado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario consultar(int codigo) {
        String sql = "SELECT * FROM usuarios WHERE codigo = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha")); // senha criptografada
                usuario.setEmail(rs.getString("email"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void excluir(int codigo) {
        String sql = "DELETE FROM usuarios WHERE codigo = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.executeUpdate();

            System.out.println("Usuário excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Usuario buscarPorNome(String nome) {
        Usuario u = null;
        try (Connection conn = Conexao.getConnection()) {
        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            u = new Usuario();
            u.setCodigo(rs.getInt("codigo"));
            u.setNome(rs.getString("nome_usuario"));
            u.setSenha(rs.getString("senha"));
            u.setEmail(rs.getString("email"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return u;
}

    public static String criptografar(String senha) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(senha.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}

}


