/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.beans;

/**
 *
 * @author leand
 */

import br.ba.fvc.dao.ClienteDAO;
import br.ba.fvc.mapeamento.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

    private Cliente cliente = new Cliente();
    private List<Cliente> clientes; // Lista de clientes para consultas

    public ClienteBean() {
        listarClientes();
    }

    // Salvar novo cliente
    public void salvar() {
        ClienteDAO dao = new ClienteDAO();
        dao.salvar(cliente);
        System.out.println("Cliente salvo: " + cliente.getNome());
        cliente = new Cliente(); // Limpar formulário
        listarClientes();
    }

    // Alterar cliente existente
    public void alterar() {
        ClienteDAO dao = new ClienteDAO();
        dao.alterar(cliente);
        System.out.println("Cliente alterado: " + cliente.getNome());
        cliente = new Cliente();
        listarClientes();
    }

    // Consultar cliente por CPF (ou outro critério)
    public void consultar() {
        ClienteDAO dao = new ClienteDAO();
        Cliente resultado = dao.buscarPorCpf(cliente.getCpf()); // Você pode adaptar aqui para nome, código, etc.
        if (resultado != null) {
            this.cliente = resultado;
            System.out.println("Cliente encontrado: " + cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado");
        }
    }

    // Excluir cliente
    public void excluir() {
        ClienteDAO dao = new ClienteDAO();
        dao.excluir(cliente);
        System.out.println("Cliente excluído: " + cliente.getNome());
        cliente = new Cliente();
        listarClientes();
    }

    // Listar todos os clientes (opcional, útil em tabelas)
    public void listarClientes() {
        ClienteDAO dao = new ClienteDAO();
        clientes = dao.listarTodos();
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
