package sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario insere(String nome, Nivel id_nivel, String rg, String cpf, String login, String senha, String email) throws SQLException {

        Connection con = FabricaConexao.getConnection();

        return null;
    }

    @Override
    public Usuario atualiza(Usuario u) throws SQLException {
        return null;
    }

    @Override
    public boolean remove(Usuario u) throws SQLException {
        return false;
    }

    @Override
    public List<Usuario> buscaNome(String nome) throws SQLException {
        return null;
    }

    @Override
    public Usuario buscaId(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Usuario> lista() throws SQLException {
        return null;
    }
}
