package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface DietaDAO {

    List<Alimentacao> lista() throws SQLException;
}
