/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import conexao.DataSource;

/**
 *
 * @author ALPHA OMEGA
 */
public class TesteConexao {
    
    public static void main(String args[]){
        
        DataSource teste = new DataSource();
        
        teste.getConnection();
        teste.closeDataSource();
    }
    
}
