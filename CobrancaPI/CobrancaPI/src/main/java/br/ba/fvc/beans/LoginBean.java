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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String usuario;
    private String senha;

    private Usuario usuarioLogado;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public String logar() {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.buscarPorNome(usuario);

        if (u != null && u.getSenha().equals(UsuarioDAO.criptografar(senha))) {
            usuarioLogado = u;
            return "/Telas/home.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário ou senha inválidos!"));
            return null;
        }
    }

    public String sair() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/Telas/login.xhtml?faces-redirect=true";
    }
}
