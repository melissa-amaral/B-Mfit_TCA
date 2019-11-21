package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import sample.NavegadorCenas;
import sample.model.Controle;
import sample.model.Modalidade;
import sample.model.Modalidade_Usuario;

import java.sql.SQLException;
import java.time.LocalDate;

public class JanelaModalidade {

    @FXML
    private ComboBox<Modalidade> idMod;

    public void initialize(){
        try{
            idMod.setItems(Controle.getInstance().listaModalidade());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void cadastrar()throws SQLException{
        Modalidade mod = idMod.getValue();
        LocalDate data = LocalDate.now();

        Controle.getInstance().cadastarModalidadeUser(mod, data);
        voltar();
    }

    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_TELA_USUARIO);

    }
}
