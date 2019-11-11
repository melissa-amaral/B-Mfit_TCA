package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface ImcDAO {

    IMC insere(IMC i) throws SQLException;
    IMC atualiza(IMC i) throws SQLException;
    List<IMC> lista() throws SQLException;


}