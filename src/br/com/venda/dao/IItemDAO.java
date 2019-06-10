/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.dao;

import br.com.venda.model.Item;
import br.com.venda.model.Item;

/**
 *
 * @author Computador
 */
public interface IItemDAO extends IDaoGeneric<Item> {

    Item getByName(String nome);

}
