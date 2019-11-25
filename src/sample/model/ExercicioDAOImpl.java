package sample.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAOImpl implements ExercicioDAO {

    @Override
    public List<Exercicio> Aleatorio(Usuario u)throws SQLException {
        ArrayList<Exercicio> exercicios = new ArrayList<>();

        Connection con = FabricaConexao.getConnection();

        CallableStatement stm = con.prepareCall("call tca_listaExercicio(?,?)");

        stm.setInt(1, u.getId());

        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            int repeticao = rs.getInt("repeticao");
            int tempo = rs.getInt("tempo");
            //blob como pegar

            Exercicio exer = new Exercicio(nome, descricao, repeticao, tempo);

            exercicios.add(exer);
        }

        return exercicios;
    }

    @Override
    public List<Exercicio> Personalizado(Usuario u) throws SQLException {
        return null;
    }
}
