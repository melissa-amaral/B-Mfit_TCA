package sample.control;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.IMC;

import java.sql.SQLException;
import java.util.List;

public class JanelaRanking {

    @FXML
    private ListView<IMC> lvRanking;

    public void initialize() throws SQLException {
        ObservableList<IMC> ordenados = Controle.getInstance().ordenarIMC();
        if(ordenados != null){
            lvRanking.setItems(ordenados);
        }
    }

    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.LOGIN);
    }
}
