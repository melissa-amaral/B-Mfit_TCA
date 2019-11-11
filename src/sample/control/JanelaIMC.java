package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.IMC;

import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class JanelaIMC {

    @FXML
    private TextField tfKg;

    @FXML
    private TextField  tfAltura;


    public void cadastrar() throws SQLException {
        float kg = Float.valueOf(tfKg.getText());
        float altura = Float.valueOf(tfAltura.getText());
        LocalDateTime data = LocalDateTime.now();

        if(kg != 0 && altura != 0){
            Controle.getInstance().cadastrarIMC(kg, altura, data);
            voltar();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"PREENCHA TODOS OS ITENS!");
            alert.showAndWait();
        }
    }

    public void atualizar() throws SQLException{
        float kg_atual = Float.valueOf(tfKg.getText());
        float altura = Float.valueOf(tfAltura.getText());
        LocalDateTime data = LocalDateTime.now();

        if(kg_atual != 0 && altura != 0){
            Controle.getInstance().atualizarIMC(kg_atual, altura, data);
            voltar();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"PREENCHA TODOS OS ITENS!");
            alert.showAndWait();
        }
    }

    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_TELA_USUARIO);
    }
}
