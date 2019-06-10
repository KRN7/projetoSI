/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.modelGeneric;

import br.com.venda.model.Venda;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author felpz
 */
public class GenericVenda {

    private StringProperty data;
    private DoubleProperty valor;

    public GenericVenda(Venda venda) {
        try {
            this.data = new SimpleStringProperty(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            this.valor = new SimpleDoubleProperty(venda.getValor());
        } catch (Exception ex) {
            Logger.getLogger(GenericCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public Double getValor() {
        return valor.get();
    }

    public void setValor(Double valor) {
        this.valor.set(valor);
    }

    @Override
    public String toString() {
        return "GenericVenda{" + "data=" + data + ", valor=" + valor + '}';
    }

}
