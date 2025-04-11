/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.mapeamento;

/**
 *
 * @author leand
 */

import java.io.Serializable;

public class Usuario implements Serializable {
    private int codigo;
    private String nome;
    private String senha;
    private String email;

    public Usuario() {
    }

    public Usuario(int codigo, String nome, String senha, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
