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
public class CompraBean {
    
    private int codigo;
    private String nomeProduto;
    private String precoCompra;
    private int quantidade;
    
    public CompraBean(){
        
    }
    public CompraBean(int codigo, String nomeProduto, String precoCompra, int quantidade){
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.precoCompra = precoCompra;
        this.quantidade = quantidade;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }
    public String getNomeProduto(){
        return nomeProduto;
    }
    public void setPrecoCompra(String precoCompra){
        this.precoCompra = precoCompra;
    }
    public String getPrecoCompra(){
        return precoCompra;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public int getQuantidade(){
        return quantidade;
    }
}
