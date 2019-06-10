/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.view;

import br.Main;
import br.com.venda.exception.DAOException;
import br.com.venda.facade.Facade;
import br.com.venda.model.*;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import salao.util.CriptografiaUtil;

/**
 *
 * @author Computador
 */
public class ViewLoginController {

    @FXML
    private JFXTextField tfLogin;
    @FXML
    private JFXPasswordField tfSenha;

    @FXML
    public void logar() {
        try {
            //Colocar Criptografia MD5
            System.out.println(new Facade().getAllUsuario());
            Usuario user = new Facade().getUsuarioByLogin(this.tfLogin.getText(), CriptografiaUtil.md5(this.tfSenha.getText()));
            if (user != null) {
                Main.showViewConta(user);
            } else {
                //(Wanderson)joptionpane personalizado. 
                JOptionPane.showMessageDialog(null, "Erro ao logar", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ViewLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastrar_Se() {
        try {
            Main.showStageCadastrarUsuario();
        } catch (IOException ex) {
            Logger.getLogger(ViewLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
