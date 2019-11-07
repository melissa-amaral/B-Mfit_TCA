package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.Nivel;
import sample.model.Usuario;

import java.sql.SQLException;

public class JanelaAtualiza {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfRg;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfEmail;

    @FXML
    private ComboBox<Nivel> nivel;

    public void initialize(){
        try{
            nivel.setItems(Controle.getInstance().listaNiveis());
            System.out.println(Controle.getInstance().listaNiveis());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizar() throws SQLException {

        String nome = tfNome.getText();
        String rg = tfRg.getText();
        String CPF = tfCPF.getText();
        String login = tfLogin.getText();
        String senha = tfSenha.getText();
        String email = tfEmail.getText();
        Nivel nivelop = nivel.getValue();

        Usuario u = new Usuario(nome, nivelop, rg, CPF, login, senha, email);
        Controle.getInstance().atualizar(u);
        voltar();

    }


    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.PRINCIPAL);
    }
}
