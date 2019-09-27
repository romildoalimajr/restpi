/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ALPHA OMEGA
 */
public class UsuarioDao {
    private DataSource dataSource;
    
    public UsuarioDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public void salvarUsuario(String nome, String login, String senha){
        DataSource dataSource = new DataSource();
        
        String sql = ("INSERT INTO usuario (nome,login,senha) VALUES (?,?,?);");
        
        try {
           
            PreparedStatement ps =dataSource.getConnection().prepareStatement(sql);
            
            ps.setString(1, nome);
            ps.setString(2, login);
            ps.setString(3, senha);
            
            ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario Cadastrado!");
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar! "+ex);
        }
        finally{
            dataSource.closeDataSource();
        }
    }
    public boolean logarUsuario(String login, String senha){
        
        boolean logar = false;
        
        String sql = ("SELECT * FROM usuario WHERE login=? AND senha=?");
        
        PreparedStatement ps;
        
        try {
            ps = dataSource.getConnection().prepareStatement(sql);
            
            ps.setString(1, login);
            ps.setString(2, senha);
            
            ResultSet rs;
            rs = ps.executeQuery();
           
            if (rs.next()){
                logar = true;
                ps.close();
                }else{
                logar=false;
                System.err.println("Usuário ou senha não encontrado");
            }
            return logar;
        } catch (SQLException ex) {
            System.err.println("Deu erro ao logar! "+ex);
        }
        finally{
            dataSource.closeDataSource();
        }
        return logar;
    }
    public boolean excluirUsuario(String login){
        
        boolean excluir = false;
        
        String sql = ("DELETE FROM usuario WHERE login=?");
        
        PreparedStatement ps;
        
        try {
            ps = dataSource.getConnection().prepareStatement(sql);
            
            
            ps.setString(1,login);
            int rs = ps.executeUpdate();
            
            if (rs!=0){
                System.out.println("Usuário excluído!");
                ps.close();
                excluir = true;
            }else{
                System.out.println("Usuário não encontrado!");
            }
            return excluir;
            
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir!..." +ex);
        }
        finally{
            dataSource.closeDataSource();
        }
        return excluir;
    }
    public boolean alterarUsuario(String nome){
        
        boolean alterar = false;
        
        String buscaSql = ("SELECT * USUARIO FROM nome="+nome+";");
        
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(buscaSql);
            
            int resultado = ps.executeUpdate();
            
            if(resultado>0){
                
                
            }

            }
         catch (SQLException ex) {
            System.err.println("Deu errado no banco!..." +ex);
        }
        finally{
            dataSource.closeDataSource();
        }
        
        return alterar;
        
    }
}
