/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KALANGO'S
 */
public class CompraDao {
    
    private DataSource dataSource;
    
    public CompraDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public void salvarCompra(String nomeProduto, String precoCompra, int quantidade){
        
        String sql = ("INSERT INTO compra (nomeProduto, precoCompra, quantidade)"
                + "VALUES (?,?,?)");
        
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
            
            ps.setString(1, nomeProduto);
            ps.setString(2, precoCompra);
            ps.setInt(3, quantidade);
            
            ps.execute();
            if (ps!=null){
                System.out.println("Produto Cadastrado com Sucesso!");
                ps.close();
             }else{
                System.out.println("Produto não cadastrado!");
                ps.close();
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro ao colocar no banco!..." +ex);
        }
        finally{
            dataSource.closeDataSource();
        }
    }
    public boolean excluirCompra(String nomeProduto){
        boolean excluir = false;
        String sql = ("DELETE FROM compra WHERE nomeProduto=?;");
        
        PreparedStatement ps;
        try {
            ps = dataSource.getConnection().prepareStatement(sql);
            ps.setString(1, nomeProduto);
            
            int rs = ps.executeUpdate();
            
            if (rs!=0){
                
                System.out.println("Produto Excluído!");
                ps.close();
                excluir = true;
            }else{
                System.out.println("Produto não Excluído!");
                ps.close();
                excluir =false;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao Excluir!..." +ex);
        }
        finally{
            dataSource.closeDataSource();
        }
    return excluir;
    }
    public boolean alterarCompra(int quantidade, String precoCompra, String nomeProduto){
        boolean alterar = false;
        
        String sql = ("UPDATE compra SET quantidade=?, precoCompra=? WHERE nomeProduto=?;");
        
        PreparedStatement ps;
        
        try {
            ps = dataSource.getConnection().prepareStatement(sql);
            
            ps.setInt(1, quantidade);
            ps.setString(2, precoCompra);
            ps.setString(3, nomeProduto);
            
            int rs = ps.executeUpdate();
            if(rs!=0){
                System.err.println("Alterado com Sucesso!");
                ps.close();
                alterar =true;
            }else{
                System.err.println("Nada foi alterado!");
                ps.close();
                alterar=false;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir do banco!..." +ex);
        }
        finally{
            dataSource.closeDataSource();
        }
        return alterar;
    }
}
