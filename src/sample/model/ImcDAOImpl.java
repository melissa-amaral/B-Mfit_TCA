package sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ImcDAOImpl implements ImcDAO {

    @Override
    public IMC insere(IMC i) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("INSERT INTO tca_imc(id_usuario, kg_inicial, altura, data_inicial) VALUES (?,?,?,?)");

        stm.setInt(1,i.getUsuario().getId());
        stm.setFloat(2,i.getKg_inicial());
        stm.setFloat(3,i.getAltura());
        stm.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
        stm.executeUpdate();

        stm.close();
        con.close();

        return i;
    }

    @Override
    public IMC atualiza(IMC i) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("UPDATE tca_imc SET kg_atual=?, altura=?, data_atual=? WHERE id_usuario = ?");

        stm.setFloat(1,i.getKg_atual());
        stm.setFloat(2,i.getAltura());
        stm.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
        stm.setInt(4,i.getUsuario().getId());

        stm.executeUpdate();

        stm.close();
        con.close();

        return i;
    }
}
