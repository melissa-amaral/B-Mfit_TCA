package sample.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NivelDAOImpl implements NivelDAO {

    @Override
    public Nivel buscaId(int id) throws SQLException {
        Nivel n = null;

        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT * FROM tca_nivel where id_nivel=?");

        stm.setInt(1,id);

        ResultSet res = stm.executeQuery();

        while(res.next()){
            String descricao = res.getString("descricao");
            n = new Nivel(id,descricao);
        }

        res.close();
        stm.close();
        con.close();

        return n;
    }

    @Override
    public List<Nivel> lista() throws SQLException {
        ArrayList<Nivel> niveis = new ArrayList<>();

        Connection con = FabricaConexao.getConnection();

        Statement stm = con.createStatement();

        ResultSet res = stm.executeQuery("SELECT * FROM tca_nivel");

        while(res.next()){
            int id_nivel = res.getInt("id_nivel");
            String descricao = res.getString("descricao");

            Nivel n = new Nivel(id_nivel, descricao);

            niveis.add(n);
        }

        res.close();
        stm.close();
        con.close();

        return niveis;
    }
}
