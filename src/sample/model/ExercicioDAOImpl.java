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

        //CallableStatement stm = con.prepareCall("select * from tca_exercicios where id_exercicios=1");

        //stm.setInt(1, u.getId());

        PreparedStatement stm = con.prepareStatement("select * from tca_exercicios where id_exercicios=1");

        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            int repeticao = rs.getInt("repeticao");
            int tempo = rs.getInt("tempo");
            BufferedImage bim=null;
            Image image=null;
            try{
                  bim = ImageIO.read(rs.getBinaryStream("demonstracao"));
                  image = SwingFXUtils.toFXImage(bim,null);
            }catch (IOException e){
                e.printStackTrace();
            }
            //blob como pegar

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

        CallableStatement stm = con.prepareCall("call tca_listaExerciciosTipo(?,?,?)");

        stm.setInt(1, u.getId());
        stm.setInt(1,tipo);


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
}
