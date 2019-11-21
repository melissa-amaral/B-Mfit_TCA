package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.Modalidade_Usuario;

import java.sql.SQLException;

public class JanelaOpPersonalizado {

    @FXML
    private RadioButton t1;

    @FXML
    private RadioButton t2;

    @FXML
    private RadioButton t3;

    @FXML
    private RadioButton t4;

    public void comecar(){

        if (t1.isSelected() || t2.isSelected() || t3.isSelected() || t4.isSelected()){
            if (t1.isSelected()){
            }
            else if (t2.isSelected()){
            }
            else if (t3.isSelected()){
            }
            else if (t4.isSelected()){
            }

            NavegadorCenas.loadJanela(NavegadorCenas.JANELA_MOSTRA_TREINO);
        }else {
            mensagem(Alert.AlertType.WARNING,"ESCOLHA UM TIPO DE TREINO");
        }
    }

    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_TELA_USUARIO);
    }

    private void mensagem(Alert.AlertType type, String msg){
        Alert alert = new Alert(type,msg);
        alert.showAndWait();
    }
}
