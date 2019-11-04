package sample.control;

import javafx.scene.control.Alert;

public class Controller {

    protected void mensagem(String msg){
        Alert a = new Alert(Alert.AlertType.INFORMATION,msg);
        a.showAndWait();
    }


}