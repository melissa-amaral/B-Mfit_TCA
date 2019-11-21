package sample.model;

import java.sql.*;
import java.time.LocalDate;

public class Modalidade_UsuarioDAOImpl implements Modalidade_UsuarioDAO {

    @Override
    public Modalidade_Usuario insere(Modalidade_Usuario mu) throws SQLException {

        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("INSERT INTO tca_modalidade_usuario(id_modalidade, id_usuario, data_inicio) VALUES (?,?,?)");

        stm.setInt(1,mu.getId_modalidade().getId());
        stm.setInt(2,mu.getId_usuario().getId());
        stm.setTimestamp(3,new Timestamp(System.currentTimeMillis()));

        stm.executeUpdate();

        stm.close();
        con.close();

        return mu;
    }

    @Override
    public Modalidade_Usuario atualiza(Modalidade_Usuario mu) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("UPDATE tca_modalidade_usuario SET data_termino=? WHERE id_usuario = ?");

        stm.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
        stm.setInt(2,mu.getId_usuario().getId());

        stm.executeUpdate();

        stm.close();
        con.close();

        return mu;
    }

    @Override
    public Modalidade_Usuario buscaModalidadeUsuario(Usuario u) throws SQLException{
        Modalidade_Usuario mu = null;

        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT * FROM tca_modalidade_usuario where id_usuario=?");

        stm.setInt(1,u.getId());

        ModalidadeDAO modalidadeDAO = new ModalidadeDAOImpl();

        ResultSet res = stm.executeQuery();

        while(res.next()){
            int id_modalidade = res.getInt("id_modalidade");
            LocalDate data_inicio= res.getDate("data_inicio").toLocalDate();

           Modalidade mod = modalidadeDAO.buscaId(id_modalidade);

            mu = new Modalidade_Usuario(mod, u, data_inicio);
        }

        res.close();
        stm.close();
        con.close();

        return mu;
    }
}
