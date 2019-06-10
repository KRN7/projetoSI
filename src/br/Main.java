/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br;

import br.com.venda.facade.Facade;
import br.com.venda.model.*;
import br.com.venda.view.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author felpz
 */
public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane mainPane;
    private static final String PATH = "com/venda/view/";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("Vendas");
        Main.primaryStage.setResizable(false);
        new Facade().getAllUsuario();
        showViewMain();
        showViewLogin();
    }

    public void showViewMain() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PATH + "ViewMain.fxml"));
        Main.mainPane = loader.load();
        Scene scene = new Scene(Main.mainPane);
        Main.primaryStage.setScene(scene);
        Main.primaryStage.setResizable(false);
        Main.primaryStage.show();
    }

    public static void showViewLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PATH + "ViewLogin.fxml"));
        BorderPane borderPane = loader.load();
        Main.mainPane.setCenter(borderPane);
    }

    public static void showViewConta(Usuario usuario) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PATH + "ViewConta.fxml"));
        BorderPane borderPane = loader.load();
        Main.mainPane.setCenter(borderPane);
        ViewContaController control = (ViewContaController) loader.getController();
        control.setStage(Main.primaryStage);
        control.setUsuario(usuario);
    }

    public static void showStageCadastrarUsuario() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PATH + "ViewCadastroUsuario.fxml"));
        BorderPane borderPane = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.primaryStage);
        stage.setTitle("cadastrar usuário");
        stage.setResizable(false);
        ViewCadastroUsuarioController control = (ViewCadastroUsuarioController) loader.getController();
        control.setStage(stage);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void showStageCadastrarCliente() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PATH + "ViewCadastroCliente.fxml"));
        BorderPane borderPane = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.primaryStage);
        stage.setTitle("cadastrar cliente");
        stage.setResizable(false);
        ViewCadastroClienteController control = (ViewCadastroClienteController) loader.getController();
        control.setStage(stage);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void showStageCadastrarItem() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PATH + "ViewCadastroItem.fxml"));
        BorderPane borderPane = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.primaryStage);
        stage.setTitle("cadastrar item");
        stage.setResizable(false);
        ViewCadastroItemController control = (ViewCadastroItemController) loader.getController();
        control.setStage(stage);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void showStageCadastrarVenda(Usuario usuario) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PATH + "ViewVenda.fxml"));
        BorderPane borderPane = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(Main.primaryStage);
        stage.setTitle("registrar venda");
        stage.setResizable(false);
        ViewVendaController control = (ViewVendaController) loader.getController();
        control.setStage(stage);
        control.setFuncionario(usuario);
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void main(String[] main) {
        launch(main);
    }

}
