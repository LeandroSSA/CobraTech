/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.beans;

/**
 *
 * @author leand
 */

import br.ba.fvc.dao.CredorDAO;
import br.ba.fvc.mapeamento.Credor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "credorBean")
@ViewScoped
public class CredorBean {
    private Credor credor = new Credor();
    private List<Credor> lista;

    public Credor getCredor() {
        return credor;
    }

    public void setCredor(Credor credor) {
        this.credor = credor;
    }

    public List<Credor> getLista() {
        if (lista == null) {
            carregarLista();
        }
        return lista;
    }

    public void carregarLista() {
        CredorDAO dao = new CredorDAO();
        lista = dao.listar();
    }

    public void cadastrar() {
        CredorDAO dao = new CredorDAO();
        dao.inserir(credor);
        credor = new Credor();
        carregarLista();
    }

    public void alterar() {
        CredorDAO dao = new CredorDAO();
        dao.alterar(credor);
        credor = new Credor();
        carregarLista();
    }

    public void excluir() {
        CredorDAO dao = new CredorDAO();
        dao.excluir(credor.getCodigo());
        credor = new Credor();
        carregarLista();
    }

    public void selecionar(Credor c) {
        this.credor = c;
    }
}
