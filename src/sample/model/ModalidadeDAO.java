package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface ModalidadeDAO {

    List<Modalidade> lista() throws SQLException;
}
