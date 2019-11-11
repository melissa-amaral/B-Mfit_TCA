package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface DietaDAO {

    List<Dieta> lista() throws SQLException;
}
