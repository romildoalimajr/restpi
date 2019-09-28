/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author KALANGO'S
 */
public class MenuBean {
    private int codigo;
    private String descricao;
    private String precoVenda;
    
    public MenuBean(){
        
    }
    public MenuBean(int codigo, String descricao, String precoVenda){
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setPrecoVenda(String precoVenda){
        this.precoVenda = precoVenda;
    }
    public String getPrecoVenda(){
        return precoVenda;
    }
}
