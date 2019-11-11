package sample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DietaDAOImpl implements DietaDAO {

    @Override
    public List<Dieta> lista() throws SQLException {

        ArrayList<Dieta> dietas = new ArrayList<>();

        Connection con = FabricaConexao.getConnection();

        Statement stm = con.createStatement();

        ResultSet res = stm.executeQuery("SELECT * FROM tca_dieta");

        while(res.next()){
            String nome = res.getString("nome");
            String descricao = res.getString("descricao");

            Dieta d = new Dieta(nome, descricao);

            dietas.add(d);
        }

        res.close();
        stm.close();
        con.close();

        return dietas;
    }
}
