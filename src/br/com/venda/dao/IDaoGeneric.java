package br.com.venda.dao;

import java.util.List;
import org.hibernate.Criteria;
import br.com.venda.exception.DAOException;

public interface IDaoGeneric<T> {

    T save(T t) throws DAOException;

    T update(T t) throws DAOException;

    T remove(T t) throws DAOException;

    T getById(Long id) throws DAOException;

    List<T> getAll() throws DAOException;

    Criteria getCriteria();

}
