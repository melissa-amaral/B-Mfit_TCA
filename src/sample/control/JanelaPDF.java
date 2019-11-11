package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.Dieta;

import java.sql.SQLException;

public class JanelaPDF {

    @FXML
    private ListView<Dieta> lista_dietas;

    @FXML
    private TextField tfNome;

    public void initialize(){
        try{
            lista_dietas.setItems(Controle.getInstance().listaDieta());
            System.out.println(Controle.getInstance().listaDieta());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void gerarPDF()throws SQLException{
        String nome = tfNome.getText();
        Dieta dieta = lista_dietas.getSelectionModel().getSelectedItem();

        if(nome != null && dieta != null){
                Controle.getInstance().criaPdf(nome, dieta);
                mensagem(Alert.AlertType.CONFIRMATION,"pdf gerado!");
        }else {
            mensagem(Alert.AlertType.INFORMATION,"nao deu certooo");
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
