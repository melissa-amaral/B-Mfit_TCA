package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.IMC;
import sample.model.Modalidade_Usuario;

import java.sql.SQLException;

public class JanelaTelaUsuario {

    @FXML
    private Label MostraTreinos;

    @FXML
    private RadioButton Perso;

    @FXML
    private RadioButton Alea;


    public void initialize() throws SQLException{
        Modalidade_Usuario mu = null;
        mu = Controle.getInstance().buscaNomeMU();

        if(mu != null){
            MostraTreinos.setText(mu.toString());
        }
        else{
            MostraTreinos.setText("Você ainda não é cadastrado em nenhuma modalidade!");
        }

    }

    public void comecar(){

        if (Perso.isSelected() || Alea.isSelected()){
            if (Perso.isSelected()){
                NavegadorCenas.loadJanela(NavegadorCenas.JANELA_OP_PERSONALIZADO);
            }
            else if (Alea.isSelected()){
                NavegadorCenas.loadJanela(NavegadorCenas.JANELA_MOSTRA_TREINO);
            }
        }else {
            mensagem(Alert.AlertType.WARNING,"ESCOLHA UM TIPO DE TREINO");
        }
    }

    public void atualizarDados(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_ATUALIZA);
    }

    public void imc(){ NavegadorCenas.loadJanela(NavegadorCenas.JANELA_IMC); }

    public void pdf(){NavegadorCenas.loadJanela(NavegadorCenas.JANELA_PDF);}

    public void cadastrarMod(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_MODALIDADE);
    }

    public void sair(){
        NavegadorCenas.loadJanela(NavegadorCenas.LOGIN);
    }

    private void mensagem(Alert.AlertType type, String msg){
        Alert alert = new Alert(type,msg);
        alert.showAndWait();
    }
}
