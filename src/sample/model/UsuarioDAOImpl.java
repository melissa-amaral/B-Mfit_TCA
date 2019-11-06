package sample.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario insere(Usuario usuario) throws SQLException {

        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("INSERT INTO tca_usuario(nome, id_nivel, rg, cpf, login, senha, email) VALUES (?,?,?,?,?,?,?)");

        stm.setString(1,usuario.getNome());
        stm.setInt(2,usuario.getId_nivel().getId());
        stm.setString(3,usuario.getRg());
        stm.setString(4,usuario.getCpf());
        stm.setString(5,usuario.getLogin());
        stm.setString(6,usuario.getSenha());
        stm.setString(7,usuario.getEmail());

        stm.executeUpdate();

        stm.close();
        con.close();

        return usuario;
    }

    @Override
    public Usuario atualiza(Usuario u, Usuario logado) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("UPDATE tca_usuario WHERE id = ?  SET nome=?, id_nivel=?, rg=?, cpf=?, login=?, senha=?, email=? ");

        stm.setInt(1,logado.getId());
        stm.setString(2,u.getNome());
        stm.setInt(3,u.getId_nivel().getId());
        stm.setString(4,u.getRg());
        stm.setString(5,u.getCpf());
        stm.setString(6,u.getLogin());
        stm.setString(7,u.getSenha());
        stm.setString(8,u.getEmail());


        stm.executeUpdate();

        stm.close();
        con.close();

        return u;
    }

    @Override
    public boolean remove(Usuario u) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("DELETE FROM tca_usuario WHERE id=?");

        stm.setInt(1,u.getId());

        stm.executeUpdate();

        stm.close();
        con.close();

        return true;
    }

    @Override
    public Usuario verificaUser(String login_busca, String senha_busca) throws SQLException {
        Usuario usuario = null;

        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT * FROM tca_usuario where login like ? and senha like ?");

        stm.setString(1,login_busca);
        stm.setString(2,senha_busca);

        NivelDAO nivelDAO = new NivelDAOImpl();

        ResultSet res = stm.executeQuery();

        while(res.next()){
            String nome = res.getString("nome");
            int id_nivel = res.getInt("id_nivel");
            String rg = res.getString("rg");
            String cpf = res.getString("cpf");
            String login = res.getString("login");
            String senha = res.getString("senha");
            String email = res.getString("email");

            Nivel n =  nivelDAO.buscaId(id_nivel);

            usuario = new Usuario(nome, n, rg, cpf, login, senha, email);
        }

        res.close();
        stm.close();
        con.close();

        return usuario;
    }

    @Override
    public Usuario buscaId(int id) throws SQLException {
        Usuario u = null;

        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT * FROM tca_usuario where id=?");

        stm.setInt(1,id);

        NivelDAO nivelDAO = new NivelDAOImpl();

        ResultSet res = stm.executeQuery();

        while(res.next()){
            String nome = res.getString("nome");
            int id_nivel = res.getInt("id_nivel");
            String rg = res.getString("rg");
            String cpf = res.getString("cpf");
            String login = res.getString("login");
            String senha = res.getString("senha");
            String email = res.getString("email");

            Nivel n =  nivelDAO.buscaId(id_nivel);

            u = new Usuario(nome, n, rg, cpf, login, senha, email);
        }

        res.close();
        stm.close();
        con.close();

        return u;

    }

    @Override
    public List<Usuario> lista() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Connection con = FabricaConexao.getConnection();

        Statement stm = con.createStatement();

        NivelDAO nivelDAO = new NivelDAOImpl();

        ResultSet res = stm.executeQuery("SELECT * FROM tca_usuario");

        while(res.next()){
            String nome = res.getString("nome");
            int id_nivel = res.getInt("id_nivel");
            String rg = res.getString("rg");
            String cpf = res.getString("cpf");
            String login = res.getString("login");
            String senha = res.getString("senha");
            String email = res.getString("email");

            Nivel n =  nivelDAO.buscaId(id_nivel);

            Usuario u = new Usuario(nome, n, rg, cpf, login, senha, email);


            usuarios.add(u);
        }

        res.close();
        stm.close();
        con.close();

        return usuarios;
    }
}
