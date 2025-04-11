/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.beans;

/**
 *
 * @author leand
 */

import br.ba.fvc.dao.BancoDAO;
import br.ba.fvc.mapeamento.Banco;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BancoBean implements Serializable {

    private Banco banco = new Banco();
    private List<Banco> lista = new ArrayList<>();

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public List<Banco> getLista() {
        if (lista == null || lista.isEmpty()) {
            carregarLista();
        }
        return lista;
    }

    public void setLista(List<Banco> lista) {
        this.lista = lista;
    }

    public void carregarLista() {
        BancoDAO dao = new BancoDAO();
        lista = dao.listar();
    }
    
    public void cadastrar() {
    BancoDAO dao = new BancoDAO();
    dao.inserir(banco);
    banco = new Banco();
    carregarLista(); // Recarrega a lista atualizada
    }


    public void salvar() {
        BancoDAO dao = new BancoDAO();
        dao.inserir(banco);
        banco = new Banco(); // limpa o formulário
        carregarLista();
    }

   public void excluir() {
    BancoDAO dao = new BancoDAO();
    dao.excluir(banco.getCodigo());
    banco = new Banco();
    carregarLista();
}


    public void alterar() {
        BancoDAO dao = new BancoDAO();
        dao.alterar(banco);
        banco = new Banco();
        carregarLista();
    }

    public void selecionar(Banco b) {
        this.banco = b;
    }
}
