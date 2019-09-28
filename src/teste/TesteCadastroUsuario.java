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
 * @author Kalango's
 */
public class TesteCadastroUsuario {
    
    public static void main(String args[]){
        
        DataSource dataSource = new DataSource();
        UsuarioBean novo = new UsuarioBean();
        UsuarioDao dao = new UsuarioDao(dataSource);
        
//        novo.setNome("Andrews");
//        novo.setLogin("ninja");
//        novo.setSenha("ninja");
//        
//        dao.salvarUsuario(novo.getNome(), novo.getLogin(), novo.getSenha());
        
//        dao.logarUsuario("romildo", "12345");

//          dao.excluirUsuario("romildo");
          
//            dao.alterarUsuario("sumido", "12345", "Andrews");

        
        if (dao.buscarTodos() != null){
               for (UsuarioBean usuario : dao.buscarTodos()){
                   System.out.printf(usuario.getCodigo()+"\n");
                   System.out.printf(usuario.getNome()+"\n");
                   System.out.printf(usuario.getLogin()+"\n");
                   System.out.printf(usuario.getSenha()+"\n");
            }
        }else{
            System.out.println("Nada Encontrado!");
        }
    }
}
