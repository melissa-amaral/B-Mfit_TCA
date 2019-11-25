package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface ExercicioDAO {

     List<Exercicio> Aleatorio(Usuario u)throws SQLException ;
     List<Exercicio> Personalizado(Usuario u)throws SQLException ;


}
