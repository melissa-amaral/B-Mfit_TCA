package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.Exercicio;

import java.sql.SQLException;

public class JanelaMostraTreino {
    private Exercicio exercicioAtual;
    int nExercicios = 0; //Contagem de rodadas
    int passar = 0; //Contagem de exercicios passados

   @FXML
   private Text nomeExer;

   @FXML
   private Label descricao;

   @FXML
   private Text repeticao;

   @FXML
   private Text tempo;


    public void initialize() throws SQLException{
        setExercicios();
    }

    public void setExercicios() throws SQLException {
        //Verifica se array esta vazio ou se já foi realizada os 10 exercicios
        if(nExercicios > 10){
            this.exercicioAtual = null;
            mensagem(Alert.AlertType.INFORMATION, "PARABENS VOCÊ TERMINOU O TREINO DE HOJE!");

            NavegadorCenas.loadJanela(NavegadorCenas.JANELA_TELA_USUARIO);
            return;
        }

        //Pega sempre o primeiro exercicio do array
        this.exercicioAtual = Controle.getInstance().listaExercicios().get(0);

        //Atualiza o labele os textos
        nomeExer.setText(exercicioAtual.getNome());
        descricao.setText(exercicioAtual.getDescricao());
        repeticao.setText(exercicioAtual.getRepeticao());
        tempo.setText(exercicioAtual.getTempo());


        //Atualiza o número da rodada
        nExercicios++;
        //Remove a pergunta atual do array de perguntas sorteadas
       // Jogo.getInstance().getSorteados().remove(perguntaAtual);

        //Atualiza a janela com a próxima pergunta
        setExercicios();
    }

    private void passar() throws SQLException{
            //Jogo.getInstance().getSorteados().remove(perguntaAtual);
            passar++;
            setExercicios();
    }

    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_TELA_USUARIO);
    }

    private void mensagem(Alert.AlertType type, String msg){
        Alert alert = new Alert(type,msg);
        alert.showAndWait();
    }
}

