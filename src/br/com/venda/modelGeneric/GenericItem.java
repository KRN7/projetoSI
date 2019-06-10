/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.modelGeneric;

import br.com.venda.model.Item;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author felpz
 */
public class GenericItem {

    private StringProperty nome;
    private StringProperty descricao;
    private DoubleProperty valor;
    private IntegerProperty qunt;

    public GenericItem(Item item) {
        try {
            this.nome = new SimpleStringProperty(item.getNome());
            this.descricao = new SimpleStringProperty(item.getDecricao());
            this.valor = new SimpleDoubleProperty(item.getValor_und());
            this.qunt = new SimpleIntegerProperty(item.getQunt());
        } catch (Exception ex) {
            Logger.getLogger(GenericCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricap(String descricao) {
        this.descricao.set("(" + descricao + ")");
    }

    public double getValor() {
        return valor.get();
    }

    public void setValor(double valor) {
        this.valor.set(valor);
    }

    public int getQunt() {
        return qunt.get();
    }

    public void setQunt(int qunt) {
        this.qunt.set(qunt);
    }

    @Override
    public String toString() {
        return "GenericItem{" + "nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", qunt=" + qunt + '}';
    }

}
