package sample.model;

import javafx.scene.image.Image;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<IMC> lista() throws SQLException {
        ArrayList<IMC> imc = new ArrayList<>();

        Connection con = FabricaConexao.getConnection();

        Statement stm = con.createStatement();

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        ResultSet res = stm.executeQuery("SELECT * FROM tca_imc");

        while(res.next()){

            int id_usuario = res.getInt("id_usuario");
            float kg_inicial = res.getFloat("kg_inicial");
            float altura = res.getFloat("altura");
            LocalDate data_inicial = res.getDate("data_inicial").toLocalDate();
            float kg_atual = res.getFloat("kg_atual");

            Date data_atualBD = res.getDate("data_atual");
            LocalDate data_atual =null;
            if(data_atualBD != null){
                data_atual = data_atualBD.toLocalDate();
            }

            Usuario u = usuarioDAO.buscaId(id_usuario);

            IMC i = new IMC(u, kg_inicial, altura, data_inicial, kg_atual, data_atual);

            imc.add(i);
        }

        res.close();
        stm.close();
        con.close();

        return imc;
    }

    public IMC buscaIMC(Usuario u) throws SQLException{
        IMC imc = null;

        Connection con = FabricaConexao.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT * FROM tca_imc where id_usuario=?");

        stm.setInt(1,u.getId());

        ResultSet res = stm.executeQuery();

        while(res.next()){
            int id_imc = res.getInt("id_imc");
            float kg_inicial = res.getFloat("kg_inicial");
            float altura = res.getFloat("altura");
            LocalDate data_inicial = res.getDate("data_inicial").toLocalDate();
            float kg_atual = res.getFloat("kg_atual");
            LocalDate data_atual = res.getDate("data_atual").toLocalDate();

            imc = new IMC(id_imc, u, kg_inicial, altura, data_inicial, kg_atual, data_atual);
        }

        res.close();
        stm.close();
        con.close();

        return imc;
    }

}
