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
public class MenuDao {
    
    private DataSource dataSource;
    
    public MenuDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public void incluirMenu(String descricao, String precoVenda){
        
        String sql = ("INSERT INTO menu (descricao, valorVenda)"
                + "VALUES (?,?)");
        
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
            
            ps.setString(1, descricao);
            ps.setString(2, precoVenda);
            
            ps.execute();
            
            if(ps!=null){
                System.out.println("Ítem salvo no menu!");
                ps.close();
            }else{
                System.out.println("Ítem não cadastrado!");
                ps.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao cadastrar no banco!..." + ex);
        }
        finally{
            dataSource.closeDataSource();
        }
    }
    public boolean alterarMenu(String descricao, String valorVenda, int codigo){
        
        boolean alterar =false;
        String sql = ("UPDATE menu SET descricao=?, valorVenda=? WHERE codigo=?;");
        
        PreparedStatement ps;
        try {
            ps = dataSource.getConnection().prepareStatement(sql);
            
            ps.setString(1, descricao);
            ps.setString(2, valorVenda);
            ps.setInt(3, codigo);
            
            int rs = ps.executeUpdate();
            
            if (rs != 0){
                System.out.println("Alterado com Sucesso!");
                ps.close();
                alterar = true;
            }else{
                System.out.println("Nada foi alterado!");
                ps.close();
                alterar = false;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar no banco!..."+ex);
        }
    return alterar;
    }
    public boolean excluirMenu(int codigo){
        
        boolean excluir = false;
        String sql = ("DELETE FROM usuario WHERE codigo=?;");
        
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
            
            ps.setInt(1, codigo);
            
            int rs = ps.executeUpdate();
            
            if (rs!=0){
                System.out.println("Item excluído com Sucesso!");
                ps.close();
                excluir = true;
            }else{
                System.out.println("item não excluído!");
                ps.close();
                excluir = false;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir no banco!..." +ex);
        }
        finally{
            dataSource.closeDataSource();
        }
        return excluir;
    }
}
