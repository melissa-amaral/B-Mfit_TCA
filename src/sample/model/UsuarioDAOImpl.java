package sample.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl {

    @Override
    Usuario insere(String nome, Nivel id_nivel, String rg, String cpf, String login, String senha, String email){ throws SQLException;
        Usuario u = new Usuario(nome, id_nivel, rg, cpf, login, senha,email);

        Connection con = DriverManager.getConnection();

        PreparedStatement stm = con.prepareStatement("INSERT INTO usuario(nome, id_nivel, rg, cpd, login, senha, email) VALUES (?,?,?,?,?,?,?)");

        stm.setString(1,u.getNome());
        //mnm

        stm.executeUpdate();
        stm.close();
        con.close();

        return u;
    }

    @Override
    public Usuario atualiza(Usuario u) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");

        PreparedStatement stm = con.prepareStatement("UPDATE CLIENTES SET _________ WHERE id=?");

        stm.setString(1,u.getNome());

        stm.executeUpdate();

        stm.close();
        con.close();

        return u;
    }

    @Override
    public boolean remove(Usuario c) throws SQLException {
        Connection con = DriverManager.getConnection("");

        PreparedStatement stm = con.prepareStatement("DELETE FROM usuario WHERE id=?");

        stm.setInt(1,c.getId());

        stm.executeUpdate();

        stm.close();
        con.close();

        return true;
    }

    @Override
    public Usuario buscaId(int id) throws SQLException{
        Usuario u = null;

        Connection con = DriverManager.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario where id=?");

        stm.setInt(1,id);

        ResultSet res = stm.executeQuery();

        while(res.next()){
            String nome = res.getString("NOME");

            u = new Usuario();
        }

        res.close();
        stm.close();
        con.close();

        return u;
    }

    @Override
    public List<Usuario> lista() throws SQLException {
        ArrayList<Usuario> clientes = new ArrayList<>();

        Connection con = DriverManager.getConnection("jdbc:sqlite:pizzappemi.sqlite");
        PreparedStatement stm = con.prepareStatement("SELECT * FROM usuario");

        ResultSet rs = stm.executeQuery();


        while(rs.next()){
            int id = rs.getInt("ID");
            String nome = rs.getString("NOME");

            Usuario u = new Usuario();

            clientes.add(u);
        }

        rs.close();
        stm.close();
        con.close();

        return clientes;
    }
}
