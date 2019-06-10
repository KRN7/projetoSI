/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.view;

import br.com.venda.exception.DAOException;
import br.com.venda.facade.Facade;
import br.com.venda.model.*;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import salao.util.CriptografiaUtil;

/**
 *
 * @author Computador
 */
public class ViewCadastroUsuarioController implements Initializable {

    @FXML
    private JFXTextField tfnome;
    @FXML
    private JFXTextField tfcpf;
    @FXML
    private JFXTextField tflogin;
    @FXML
    private JFXPasswordField tfsenha;

    private Facade fac;
    private String date;
    private Stage stage;

    @FXML
    public void cadastrar() {
        try {
            Usuario user = new Usuario();
            user.setLogin(this.tflogin.getText());
            user.setSenha(CriptografiaUtil.md5(this.tfsenha.getText()));
            user.setNome(this.tfnome.getText());
            user.setCpf(this.tfcpf.getText());
            user.setCargo(Cargo.ATENDENTE);
            user.setDtCadastro(new SimpleDateFormat().parse(date));
            if (this.fac.saveUsuario(user) != null) {
                JOptionPane.showMessageDialog(null, "usuário cadastrado com sucesso!", "cadastro usuário", JOptionPane.INFORMATION_MESSAGE);
                this.stage.close();
            }else{
                JOptionPane.showMessageDialog(null, "erro ao cadastrar usuário!", "cadastro usuário", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DAOException ex) {
            Logger.getLogger(ViewCadastroUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ViewCadastroUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String crip(String senha) {
        return CriptografiaUtil.md5(senha);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fac = new Facade();
        this.date = new SimpleDateFormat().format(new Date());
    }
}
