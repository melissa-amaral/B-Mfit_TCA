package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.IMC;

import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class JanelaIMC {

    @FXML
    private TextField tfKg;

    @FXML
    private TextField  tfAltura;


    @FXML
    private Button btAcao;

    public void initialize() throws SQLException{
        IMC imc = null;
        imc = Controle.getInstance().buscaIMC();

        if(imc != null){
            btAcao.setText("Atualizar");
        }
        else{
            btAcao.setText("Cadastrar");
        }
    }

    public void acao() throws SQLException {
        IMC imc = null;

        float kg = Float.valueOf(tfKg.getText());
        float altura = Float.valueOf(tfAltura.getText());
        LocalDate data = LocalDate.now();

        imc = Controle.getInstance().buscaIMC();

        if(kg != 0 && altura != 0){
            if(imc != null){
                //se tem IMC
                Controle.getInstance().atualizarIMC(kg, altura, data);
            }
            else{
                //se nao tem
                Controle.getInstance().cadastrarIMC(kg, altura, data);
            }
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
