/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.view;

import br.com.venda.exception.DAOException;
import br.com.venda.facade.Facade;
import br.com.venda.model.*;
import br.com.venda.modelGeneric.*;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author felpz
 */
public class ViewVendaController implements Initializable {

    @FXML
    private JFXTextField tfValor;
    @FXML
    private JFXDatePicker dtVenda;
    @FXML
    private JFXComboBox cbCliente;
    @FXML
    private TableView<GenericItem> tableItem;
    @FXML
    private TableColumn<GenericItem, String> colunaItemNome;
    @FXML
    private TableColumn<GenericItem, String> colunaItemEstq;
    @FXML
    private TableColumn<GenericItem, String> colunaItemValor;
    @FXML
    private TableView<GenericItem> tableItem2;
    @FXML
    private TableColumn<GenericItem, String> colunaItemNome2;
    @FXML
    private TableColumn<GenericItem, String> colunaItemQunt2;
    @FXML
    private TableColumn<GenericItem, String> colunaItemValor2;

    private Facade fac;
    private Usuario usuario;
    private Stage stage;
    private String dia;
    private String mes;
    private String ano;
    private ObservableList<GenericItem> olItem;
    private final GenericItemController controllerItem = new GenericItemController();
    private List<Item> lista = new ArrayList<>();

    @FXML
    public void cadastrar() {
        try {
            if (this.dtVenda.getValue() != null) {
                this.dia = String.valueOf(this.dtVenda.getValue().getDayOfMonth());
                this.mes = String.valueOf(this.dtVenda.getValue().getMonthValue());
                this.ano = String.valueOf(this.dtVenda.getValue().getYear());
            } else {
                this.dia = "30";
                this.mes = "11";
                this.ano = "0002";
            }
            Venda venda = new Venda();
            venda.setDtVenda(new SimpleDateFormat("dd/MM/yyyy").parse(dia + '/' + mes + '/' + ano));
            String[] valor = this.tfValor.getText().split(" ");
            venda.setValor(Double.valueOf(valor[1]));
            venda.setItens(this.lista);
            System.out.println(lista);
            this.fac.saveVenda(venda);
        } catch (DAOException ex) {
            Logger.getLogger(ViewVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ViewVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTableItem() {
        try {
            this.colunaItemNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaItemValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
            this.olItem = FXCollections.observableArrayList(this.controllerItem.listarAll(this.fac.getAllItem()));
            this.tableItem.setItems(null);
            this.tableItem.setItems(this.olItem);
            this.tableItem.setRowFactory(tv -> {
                TableRow<GenericItem> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        try {
                            int qunt = Integer.valueOf(addItemToCart());
                            GenericItem rowData = row.getItem();
                            Item item = this.fac.getItemByName(rowData.getNome());
                            item.setQunt(qunt);
                            this.lista.add(item);
                            preencherTableItemCart(lista);
                        } catch (Exception ex) {
                            Logger.getLogger(ViewVendaController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                return row;
            });
        } catch (Exception ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTableItemCart(List<Item> listaAux) {
        try {
            this.colunaItemNome2.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.colunaItemQunt2.setCellValueFactory(new PropertyValueFactory<>("qunt"));
            this.colunaItemValor2.setCellValueFactory(new PropertyValueFactory<>("valor"));
            this.olItem = FXCollections.observableArrayList(this.controllerItem.listarAll(listaAux));
            this.tableItem2.setItems(null);
            this.tableItem2.setItems(this.olItem);
            double valor = 0;
            for (Item i : listaAux) {
                valor = valor + (i.getValor_und() * i.getQunt());
                System.out.println(i);
                System.out.println(valor);
            }
            this.tfValor.setText("R$ " + valor);
        } catch (Exception ex) {
            Logger.getLogger(ViewContaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public String addItemToCart() {
        String qunt = JOptionPane.showInputDialog(null, "quantidade de itens:");
        return qunt;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setFuncionario(Usuario usuario) {
        this.usuario = usuario;
    }

    private static LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fac = new Facade();
        preencherTableItem();
        this.dtVenda.setValue(LOCAL_DATE(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
    }

}
