/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.beans;

/**
 *
 * @author leand
 */

import br.ba.fvc.dao.UsuarioDAO;
import br.ba.fvc.mapeamento.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
    private Usuario usuario = new Usuario();

    public void salvar() {
        usuario.setSenha(criptografarSenha(usuario.getSenha()));
        UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(usuario);
        usuario = new Usuario(); // Limpa o formulário
    }

    public void alterar() {
        usuario.setSenha(criptografarSenha(usuario.getSenha()));
        UsuarioDAO dao = new UsuarioDAO();
        dao.alterar(usuario);
        usuario = new Usuario();
    }

    public void consultar() {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario resultado = dao.consultar(usuario.getCodigo());
        if (resultado != null) {
            this.usuario = resultado;
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void excluir() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.excluir(usuario.getCodigo());
        usuario = new Usuario();
    }

    private String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash)
                sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
