package sample.control;

import javafx.scene.control.Alert;
import sample.NavegadorCenas;

public class JanelaPrincipal {

    public void cadastrarUsuario(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_USUARIO);
    }

    private void mensagem(Alert.AlertType type, String msg){
        Alert alert = new Alert(type,msg);
        alert.showAndWait();
    }


}
