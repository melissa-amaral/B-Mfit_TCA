package sample.control;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class JanelaBase {

    @FXML
    private StackPane janelaBase;

    public void setJanelaBase(Node node){
        janelaBase.getChildren().setAll(node);
    }

}