/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.dao;

import br.com.venda.model.Usuario;
import br.com.venda.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author wfeli
 */
public class UsuarioDAO extends DaoGenericImpl<Usuario> implements IUsuarioDAO {

    private EntityManager em;

    public Usuario getByLogin(String login, String senha) {
        try {
            em = JPAUtil.getEntityManager();
            Query query = em.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
            query.setParameter("login", login);
            query.setParameter("senha", senha);
            return (Usuario) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new Exception(PropertiesUtil.getMsgValue(PropertiesUtil.MSG_ERROR_BUSCAR + " USUARIO NÃO ENCONTRADO!"));
        } finally {
            JPAUtil.close();
        }
        return null;
    }
}
