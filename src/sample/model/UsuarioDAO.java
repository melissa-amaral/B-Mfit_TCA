package sample.model;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    Usuario insere(String nome, Nivel id_nivel, String rg, String cpf, String login, String senha, String email) throws SQLException;
    Usuario atualiza(Usuario u) throws SQLException;
    boolean remove(Usuario u) throws SQLException;

    Usuario buscaId(int id) throws SQLException;
    List<Usuario> lista() throws SQLException;
}