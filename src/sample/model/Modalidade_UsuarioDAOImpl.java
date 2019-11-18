package sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

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
        stm.setInt(4,mu.getId_usuario().getId());

        stm.executeUpdate();

        stm.close();
        con.close();

        return mu;
    }
}
