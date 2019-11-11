package sample.model;

import java.sql.SQLException;

public interface ImcDAO {

    IMC insere(IMC i) throws SQLException;
    IMC atualiza(IMC i) throws SQLException;
}
