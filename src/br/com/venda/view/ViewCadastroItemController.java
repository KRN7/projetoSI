/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.view;

import br.com.venda.exception.DAOException;
import br.com.venda.facade.Facade;
import br.com.venda.model.*;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author Computador
 */
public class ViewCadastroItemController implements Initializable {

    @FXML
    private JFXTextField tfnome;
    @FXML
    private JFXTextField tfprecovenda;
    @FXML
    private JFXTextField tfdescricao;

    private Facade fac;
    private Stage stage;

    @FXML
    public void cadastrar() {
        try {
            Item i = new Item();
            i.setNome(this.tfnome.getText());
            i.setDecricao(this.tfdescricao.getText());
            i.setValor_und(Double.valueOf(this.tfprecovenda.getText()));
//            i.setNome(this.tfnome.getText());
//            i.setPrecoVendaItem(Double.valueOf(this.tfprecovenda.getText()));
//            i.setDescricao(this.tfdescricao.getText());
            System.out.println(i.toString());
            this.fac.saveItem(i);
            this.stage.close();
        } catch (DAOException ex) {
            Logger.getLogger(ViewCadastroItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fac = new Facade();
    }

}
