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

public class Banco implements Serializable {
    
    private int codigo;
    private String codigoDoBanco;
    private String nomeDoBanco;
    private String nomeDaAgencia;
    private String numeroDaAgencia;
    private String numeroDaConta;

    // Construtor vazio
    public Banco() {
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodigoDoBanco() {
        return codigoDoBanco;
    }

    public void setCodigoDoBanco(String codigoDoBanco) {
        this.codigoDoBanco = codigoDoBanco;
    }

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public String getNomeDaAgencia() {
        return nomeDaAgencia;
    }

    public void setNomeDaAgencia(String nomeDaAgencia) {
        this.nomeDaAgencia = nomeDaAgencia;
    }

    public String getNumeroDaAgencia() {
        return numeroDaAgencia;
    }

    public void setNumeroDaAgencia(String numeroDaAgencia) {
        this.numeroDaAgencia = numeroDaAgencia;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }
}
