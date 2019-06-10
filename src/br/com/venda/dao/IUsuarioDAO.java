/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.dao;

import br.com.venda.model.Usuario;

/**
 *
 * @author wfeli
 */
public interface IUsuarioDAO extends IDaoGeneric<Usuario> {

    Usuario getByLogin(String login, String senha);
}
