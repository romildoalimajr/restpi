/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UsuarioBean;
import conexao.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KALANGO'S
 */
public class UsuarioDao {
    private DataSource dataSource;
    
    public UsuarioDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public void salvarUsuario(String nome, String login, String senha){
        
        
        String sql = ("INSERT INTO usuario (nome,login,senha) VALUES (?,?,?);");
        
        try {
           
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
            
            ps.setString(1, nome);
            ps.setString(2, login);
            ps.setString(3, senha);
            
            int rs = ps.executeUpdate();
            if (rs > 0){    
            System.out.println("Usuário Cadastrado!");
            ps.close();
            }else{
                System.out.println("Usuário não Cadastrado!...");
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro ao Cadastrar no banco! "+ex);
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
                System.out.println("Usuário Logado com Sucesso!...");
                }else{
                logar=false;
                System.out.println("Usuário ou senha não encontrado");
            }
            return logar;
        } catch (SQLException ex) {
            System.err.println("Deu erro ao logar no banco! "+ex);
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
    public boolean alterarUsuario(String login, String senha, String nome){
        
        boolean alterar = false;
        
        String sql = ("UPDATE usuario set login=?, senha=? WHERE nome=?;");
        
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
            
            ps.setString(1, login);
            ps.setString(2, senha);
            ps.setString(3, nome);
            
            int rs = ps.executeUpdate();
            
            if(rs > 0){
            System.out.println("Dados Alterados!...");
            alterar = true;
            ps.close();
            
            }else{
            System.out.println("Nada foi alterado!...");
            alterar = false;
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
    public List<UsuarioBean> buscarTodos(){
        
        String sql = ("SELECT * FROM usuario");
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
        
        try {
            ps = dataSource.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
                
            while(rs.next()){
                
                UsuarioBean usuario = new UsuarioBean();
                
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                
                lista.add(usuario);
            }
            ps.close();
            
            return lista;
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar no banco!..." +ex);
        }
        finally{
            dataSource.closeDataSource();
        }
        return null;
    }
}
