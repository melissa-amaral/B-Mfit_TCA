package sample.model;

import java.sql.SQLException;

public interface Modalidade_UsuarioDAO {

    Modalidade_Usuario insere(Modalidade_Usuario mu) throws SQLException;
    Modalidade_Usuario atualiza(Modalidade_Usuario mu) throws SQLException;
    Modalidade_Usuario buscaModalidadeUsuario(Usuario u) throws SQLException;

}
