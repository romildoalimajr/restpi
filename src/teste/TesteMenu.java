/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import bean.MenuBean;
import conexao.DataSource;
import dao.MenuDao;

/**
 *
 * @author KALANGO'S
 */
public class TesteMenu {
    
    public static void main(String args[]){
        
        DataSource dataSource = new DataSource();
        
        MenuBean novo = new MenuBean();
        
        MenuDao dao = new MenuDao(dataSource);
        
//        novo.setDescricao("Hamburguer X-Tudo");
//        novo.setPrecoVenda("R$ 1,50");
//        
//        dao.incluirMenu(novo.getDescricao(), novo.getPrecoVenda());
        
        dao.alterarMenu("Hamburguer X-Tudo", "R$ 6,50", 1);
        
        
    }
}
