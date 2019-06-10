/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.facade;

import br.com.venda.dao.*;
import br.com.venda.exception.*;
import br.com.venda.model.*;
import java.util.List;

/**
 *
 * @author felpz
 */
public class Facade {

    private IDaoPessoa daoPessoa;
    private IClienteDAO daoCliente;
    private IEnderecoDAO daoEndereco;
    private IItemDAO daoItem;
    private IVendaDAO daoVenda;
    private IUsuarioDAO daoUsuario;

    public Facade() {
        this.daoCliente = new ClienteDAO();
        this.daoEndereco = new EnderecoDAO();
        this.daoItem = new ItemDAO();
        this.daoVenda = new VendaDAO();
        this.daoUsuario = new UsuarioDAO();
    }

    //-----C L I E N T E-----
    public Cliente saveCliente(Cliente cliente) throws DAOException {
        return this.daoCliente.save(cliente);
    }

    public Cliente getClienteById(long id) throws DAOException {
        return this.daoCliente.getById(id);
    }

    public Cliente getClienteByName(String nome) throws DAOException {
        return this.daoCliente.getByName(nome);
    }

    public List<Cliente> getAllCliente() throws DAOException, DAOException, DAOException {
        return this.daoCliente.getAll();
    }

    public Cliente updateCliente(Cliente cliente) throws DAOException {
        return this.daoCliente.update(cliente);
    }

    public Cliente removeCliente(Cliente cliente) throws DAOException {
        return this.daoCliente.remove(cliente);
    }

    //-----E N D E R E C O-----
    public Endereco saveEndereco(Endereco end) throws DAOException {
        return this.daoEndereco.save(end);
    }

    public Endereco getEnderecoById(long id) throws DAOException {
        return this.daoEndereco.getById(id);
    }

    public List<Endereco> getAllEndereco() throws DAOException {
        return this.daoEndereco.getAll();
    }

    public Endereco updateEndereco(Endereco end) throws DAOException {
        return this.daoEndereco.update(end);
    }

    public Endereco removeEndereco(Endereco end) throws DAOException {
        return this.daoEndereco.remove(end);
    }

    //-----I T E M-----
    public Item saveItem(Item item) throws DAOException {
        return this.daoItem.save(item);
    }

    public Item getItemById(long id) throws DAOException {
        return this.daoItem.getById(id);
    }

    public Item getItemByName(String nome) throws DAOException {
        return this.daoItem.getByName(nome);
    }

    public List<Item> getAllItem() throws DAOException {
        return this.daoItem.getAll();
    }

    public Item updateItem(Item item) throws DAOException {
        return this.daoItem.update(item);
    }

    public Item removeItem(Item item) throws DAOException {
        return this.daoItem.remove(item);
    }

    //-----V E N D A-----
    public Venda saveVenda(Venda venda) throws DAOException {
        return this.daoVenda.save(venda);
    }

    public Venda getVendaById(long id) throws DAOException {
        return this.daoVenda.getById(id);
    }

    public List<Venda> getAllVenda() throws DAOException {
        return this.daoVenda.getAll();
    }

    public Venda updateVenda(Venda venda) throws DAOException {
        return this.daoVenda.update(venda);
    }

    public Venda removeVenda(Venda venda) throws DAOException {
        return this.daoVenda.remove(venda);
    }

    //-----U S U A R I O-----
    public Usuario saveUsuario(Usuario usuario) throws DAOException {
        return this.daoUsuario.save(usuario);
    }

    public Usuario getUsuarioByLogin(String login, String senha) throws DAOException {
        return this.daoUsuario.getByLogin(login, senha);
    }

    public List<Usuario> getAllUsuario() throws DAOException {
        return this.daoUsuario.getAll();
    }

}
