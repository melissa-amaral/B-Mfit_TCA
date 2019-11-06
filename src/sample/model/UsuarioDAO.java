package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    Usuario insere(Usuario usuario) throws SQLException;
    Usuario atualiza(Usuario u, Usuario logado) throws SQLException;
    boolean remove(Usuario u) throws SQLException;

    Usuario verificaUser(String login_busca, String senha_busca) throws SQLException;
    Usuario buscaId(int id) throws SQLException;
    List<Usuario> lista() throws SQLException;
}