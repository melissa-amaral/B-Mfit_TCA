package sample.model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAOImpl implements ExercicioDAO {

    @Override
    public List<Exercicio> aleatorio(Usuario u)throws SQLException {
        ArrayList<Exercicio> exercicios = new ArrayList<>();

        Connection con = FabricaConexao.getConnection();

        CallableStatement stm = con.prepareCall("call tca_listaExercicios(?)");

        stm.setInt(1, u.getId());

       //PreparedStatement stm = con.prepareStatement("select * from tca_exercicios");

        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            int repeticao = rs.getInt("repeticao");
            int tempo = rs.getInt("tempo");
            String demonstracao = rs.getString("demonstracao");
            System.out.println(demonstracao);
            System.out.println(getClass().getResource("/sample/imgs/" + demonstracao));
            Image image = new Image(getClass().getResource("/sample/imgs/" + demonstracao).toExternalForm(),640,420,true,false);


            Exercicio exer = new Exercicio(nome, descricao, repeticao, tempo);
            exer.setDemonstracao(image);
            exercicios.add(exer);
        }

        return exercicios;
    }

    @Override
    public List<Exercicio> Personalizado(Usuario u,int tipo) throws SQLException {
        ArrayList<Exercicio> exercicios = new ArrayList<>();

        Connection con = FabricaConexao.getConnection();

        CallableStatement stm = con.prepareCall("call tca_listaExerciciosTipo(?,?)");

        stm.setInt(1, u.getId());
        stm.setInt(2,tipo);

        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            int repeticao = rs.getInt("repeticao");
            int tempo = rs.getInt("tempo");
            String demonstracao = rs.getString("demonstracao");

            Image image = new Image(getClass().getResource("/sample/imgs/" + demonstracao).toExternalForm(),640,420,true,false);

            Exercicio exer = new Exercicio(nome, descricao, repeticao, tempo);
            exer.setDemonstracao(image);
            exercicios.add(exer);
        }

        return exercicios;
    }


}
