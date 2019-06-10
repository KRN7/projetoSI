/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author wfeli
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String decricao;
    private double valor_und;
    @Transient
    private int qunt;

    public Item() {
    }

    public Item(long id, String nome, String decricao, double valor_und, int qunt) {
        this.id = id;
        this.nome = nome;
        this.decricao = decricao;
        this.valor_und = valor_und;
        this.qunt = qunt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public double getValor_und() {
        return valor_und;
    }

    public void setValor_und(double valor_und) {
        this.valor_und = valor_und;
    }

    public int getQunt() {
        return qunt;
    }

    public void setQunt(int qunt) {
        this.qunt = qunt;
    }

    @Override
    public String toString() {
        return "Item1{" + "id=" + id + ", nome=" + nome + ", decricao=" + decricao + ", valor_und=" + valor_und + ", qunt=" + qunt + '}';
    }

}
