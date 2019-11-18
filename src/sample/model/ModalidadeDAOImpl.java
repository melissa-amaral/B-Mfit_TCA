package sample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
