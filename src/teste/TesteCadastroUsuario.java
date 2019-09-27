/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import bean.UsuarioBean;
import conexao.DataSource;
import dao.UsuarioDao;

/**
 *
 * @author ALPHA OMEGA
 */
public class TesteCadastroUsuario {
    
    public static void main(String args[]){
        
        DataSource dataSource = new DataSource();
        UsuarioDao dao = new UsuarioDao(dataSource);
        
        UsuarioBean novo = new UsuarioBean();
        
//        novo.setNome("Romildo Alves");
//        novo.setLogin("romildo");
//        novo.setSenha("12345");
//        
//        dao.salvarUsuario(novo.getNome(), novo.getLogin(), novo.getSenha());
        
//        dao.logarUsuario("romildo", "12345");

        dao.excluirUsuario("romildo");
    }
    
}
