/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALPHA OMEGA
 */
public class DataSource {
    
    private String  hostname;
    private int     porta;
    private String  database;
    private String  username;
    private String  password;
    
    private Connection connection;
    
    public DataSource(){
        
        try{
            
            hostname    = "localhost";
            porta       = 3306;
            database    = "lanchonete";
            username    = "root";
            password    = "";
        
            String url  = "jdbc:mysql://"+hostname+":"+porta+"/"+database;
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            
            System.out.println("Conectado ao Banco!");
        
        }
        catch(SQLException ex){
            System.err.println("Falha na Conexão! "+ex);
        }
        catch(Exception ex){
            System.err.println("Erro Geral... " +ex);
        }
    }
        public Connection getConnection(){
            return this.connection;
        }
        public void closeDataSource(){
        try {
            connection.close();
            
            System.out.println("Banco Fechado!");
        } catch (SQLException ex) {
            System.err.println("Erro ao fechar o banco! "+ ex.getMessage());
            }
        }
        public PreparedStatement prepareStatement(String sql){
            throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
        }
}
