package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.Usuario;

import java.sql.SQLException;

public class JanelaPrincipal {

    @FXML
    public TextField tfLogin;

    @FXML
    public TextField tfSenha;

    public void cadastrarUsuario(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_USUARIO);
    }



    private void mensagem(Alert.AlertType type, String msg){
        Alert alert = new Alert(type,msg);
        alert.showAndWait();
    }


}
