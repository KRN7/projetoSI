/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.dao;

import br.com.venda.model.Item;
import br.com.venda.model.Item;
import br.com.venda.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Computador
 */
public class ItemDAO extends DaoGenericImpl<Item> implements IItemDAO {

    private EntityManager em;

    @Override
    public Item getByName(String nome) {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select i from Item i where i.nome= :nome");
            query.setParameter("nome", nome);
            return (Item) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_BUSCAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
        return null;
    }

}
