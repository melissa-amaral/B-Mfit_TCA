package sample.control;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.Exercicio;

import java.sql.SQLException;

public class JanelaMostraTreino {
    private Exercicio exercicioAtual;

   @FXML
   private Text nomeExer;

   @FXML
   private Label descricao;

   @FXML
   private Text repeticao;

   @FXML
   private Text tempo;

   @FXML
   private ImageView imgView;


    public void initialize() throws SQLException{
        setExercicios();
    }

    @FXML
    public void setExercicios() throws SQLException {

        //Verifica se array esta vazio
        if(Controle.getInstance().getSorteados().size() == 0){
            exercicioAtual = null;
            mensagem(Alert.AlertType.INFORMATION, "PARABENS VOCÊ TERMINOU O TREINO DE HOJE!");

            NavegadorCenas.loadJanela(NavegadorCenas.JANELA_TELA_USUARIO);
            return;
        }

        //Pega sempre o primeiro exercicio do array
        exercicioAtual = Controle.getInstance().getSorteados().get(0);

        //Atualiza o labele os textos
        nomeExer.setText("Exercicio: " +exercicioAtual.getNome());
        descricao.setText(exercicioAtual.getDescricao());
        repeticao.setText("Repetição: "+exercicioAtual.getRepeticao());
        tempo.setText("Serie:" +exercicioAtual.getTempo());
        imgView.setImage(exercicioAtual.getDemonstracao());

    }

    @FXML
    private void passar() throws SQLException{
            Controle.getInstance().getSorteados().remove(exercicioAtual);
            setExercicios();
    }

    @FXML
    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_TELA_USUARIO);
    }

    @FXML
    private void mensagem(Alert.AlertType type, String msg){
        Alert alert = new Alert(type,msg);
        alert.showAndWait();
    }



}

