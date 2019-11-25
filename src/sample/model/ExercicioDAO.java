package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface ExercicioDAO {

     List<Exercicio> aleatorio(Usuario u)throws SQLException ;
     List<Exercicio> Personalizado(Usuario u, int tipo)throws SQLException ;


}
