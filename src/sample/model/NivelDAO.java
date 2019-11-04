package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface NivelDAO {

    Nivel buscaId(int id) throws SQLException;
    List<Nivel> lista() throws SQLException;


}
