/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ALPHA OMEGA
 */
public class UsuarioBean {
    
    private String nome;
    private String login;
    private String senha;
    
    public UsuarioBean(){
        
    }
    public UsuarioBean(String nome, String login, String senha){
        this.nome   = nome;
        this.login  = login;
        this.senha  = senha;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }
    
}
