package sample.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModalidadeDAOImpl implements ModalidadeDAO {

    @Override
    public List<Modalidade> lista() throws SQLException {
        ArrayList<Modalidade> modalidades = new ArrayList<>();

        Connection con = FabricaConexao.getConnection();

        Statement stm = con.createStatement();

        ResultSet res = stm.executeQuery("SELECT * FROM tca_modalidade");

        while(res.next()){
            int id_modalidade = res.getInt("id_modalidade");
            String nome = res.getString("nome");

            Modalidade mod = new Modalidade(id_modalidade, nome);

            modalidades.add(mod);
        }

        res.close();
        stm.close();
        con.close();

        return modalidades;
    }

    @Override
    public Modalidade buscaId(int id) throws SQLException {
        Modalidade mod = null;

        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT * FROM tca_modalidade where id_modalidade=?");

        stm.setInt(1,id);

        ResultSet res = stm.executeQuery();

        while(res.next()) {
            int id_modalidade = res.getInt("id_modalidade");
            String nome = res.getString("nome");

            mod = new Modalidade(id_modalidade, nome);
        }

        res.close();
        stm.close();
        con.close();

        return mod;
    }
}
