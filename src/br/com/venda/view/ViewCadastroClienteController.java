/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.view;

import br.com.venda.exception.DAOException;
import br.com.venda.facade.Facade;
import br.com.venda.model.Cliente;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Computador
 */
public class ViewCadastroClienteController {

    @FXML
    private JFXTextField tfnome;
    @FXML
    private JFXTextField tfcpf;
    @FXML
    private JFXDatePicker dtNascimento;
    @FXML
    private JFXTextField tfrua;
    @FXML
    private JFXTextField tfbairro;
    @FXML
    private JFXTextField tfcep;
    @FXML
    private JFXTextField tfuf;
    @FXML
    private JFXTextField tfcidade;
    @FXML
    private JFXTextField tfcomplemento;
    @FXML
    private JFXTextField tfnumero;

    private Facade fa = new Facade();
    private String dia;
    private String mes;
    private String ano;
    private Stage stage;

    @FXML
    public void cadastrar() {
        try {
            if (this.dtNascimento.getValue() != null) {
                this.dia = String.valueOf(this.dtNascimento.getValue().getDayOfMonth());
                this.mes = String.valueOf(this.dtNascimento.getValue().getMonthValue());
                this.ano = String.valueOf(this.dtNascimento.getValue().getYear());
            } else {
                this.dia = "30";
                this.mes = "11";
                this.ano = "0002";
            }
            Cliente c = new Cliente();
            c.setNome(this.tfnome.getText());
            c.setCpf(this.tfcpf.getText());
            c.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(dia + '/' + mes + '/' + ano));
            c.getEndereco().setRua(this.tfrua.getText());
            c.getEndereco().setCep(this.tfcep.getText());
            c.getEndereco().setBairro(this.tfbairro.getText());
            c.getEndereco().setCidade(this.tfcidade.getText());
            c.getEndereco().setComplemento(this.tfcomplemento.getText());
            c.getEndereco().setNumero(Integer.valueOf(this.tfnumero.getText()));
            fa.saveCliente(c);
            JOptionPane.showMessageDialog(null, "cliente cadastrado com sucesso!", "cadastro cliente", JOptionPane.INFORMATION_MESSAGE);
            this.stage.close();
        } catch (DAOException ex) {
            Logger.getLogger(ViewCadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ViewCadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
