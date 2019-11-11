package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.NavegadorCenas;
import sample.model.Controle;

import java.sql.SQLException;

public class JanelaLogin {

    @FXML
    public TextField tfLogin;

    @FXML
    public TextField tfSenha;

    public void cadastrarUsuario(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_USUARIO);
    }

    public void entrar() throws SQLException {
        String login = tfLogin.getText();
        String senha = tfSenha.getText();

        if(Controle.getInstance().verificar(login, senha) != null ){
            NavegadorCenas.loadJanela(NavegadorCenas.JANELA_TELA_USUARIO);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"Usuario não Encontrado");
            alert.showAndWait();
        }
    }

    private void mensagem(Alert.AlertType type, String msg){
        Alert alert = new Alert(type,msg);
        alert.showAndWait();
    }


}
