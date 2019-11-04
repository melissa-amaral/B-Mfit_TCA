package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    Usuario insere(Usuario usuario) throws SQLException;
    Usuario atualiza(Usuario u) throws SQLException;
    boolean remove(Usuario u) throws SQLException;

    Usuario buscaNome(String login_busca) throws SQLException;
    Usuario buscaId(int id) throws SQLException;
    List<Usuario> lista() throws SQLException;
}