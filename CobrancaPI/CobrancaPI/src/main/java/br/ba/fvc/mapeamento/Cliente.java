/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.mapeamento;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int codigo;
    private String nome;
    private String endereco;
    private String numero;
    private String cpf;
    private String cep;
    private Categoria codigoCat;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String endereco, String numero, String cpf, String cep) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.cpf = cpf;
        this.cep = cep;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Categoria getCodigoCat() {
        return codigoCat;
    }

    public void setCodigoCat(Categoria codigoCat) {
        this.codigoCat = codigoCat;
    }
}
