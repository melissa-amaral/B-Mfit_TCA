package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import sample.control.JanelaBase;

import java.io.IOException;

public class NavegadorCenas {

    public static final String BASE = "/view/base.fxml";
    public static final String LOGIN = "/view/login.fxml";
    public static final String JANELA_USUARIO = "/view/cadastrar_usuario.fxml";
    public static final String JANELA_TELA_USUARIO = "/view/telaUsuario.fxml";
    public static final String JANELA_ATUALIZA = "/view/atualizar.fxml";
    public static final String JANELA_IMC = "/view/cadastrar_IMC.fxml";


    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador) {
        NavegadorCenas.controlador = controlador;
    }

    public static void loadJanela(String fxml) {
        try {
            controlador.setJanelaBase(
                    (Node) FXMLLoader.load(
                            NavegadorCenas.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

