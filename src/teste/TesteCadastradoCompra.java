/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import bean.CompraBean;
import conexao.DataSource;
import dao.CompraDao;

/**
 *
 * @author KALANGO'S
 */
public class TesteCadastradoCompra {
    
    public static void main(String args[]){
        DataSource dataSource = new DataSource();
        CompraBean nova = new CompraBean();
        CompraDao dao = new CompraDao(dataSource);

//        nova.setNomeProduto("Carne de Cavalo");
//        nova.setPrecoCompra("50,00");
//        nova.setQuantidade(30);
//        
//        dao.salvarCompra(nova.getNomeProduto(), nova.getPrecoCompra(), nova.getQuantidade());

//        dao.excluirCompra("Coca-Cola");

//        dao.alterarCompra(10, "25,00", "Carne de Cavalo");
        
        dao.excluirCompra("Carne de Cavalo");
    }
}
