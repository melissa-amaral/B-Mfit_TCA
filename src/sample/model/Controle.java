package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class Controle {

    UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    NivelDAO nivelDAO = new NivelDAOImpl();

    private ObservableList<Usuario> usuarios;
    private ObservableList<Nivel> niveis;
    private Usuario logado;

    private static Controle instance=new Controle();

    public Controle() {
        usuarios = FXCollections.observableArrayList();
        niveis = FXCollections.observableArrayList();
    }

    public static Controle getInstance(){
        return instance;
    }

    public void cadastraUsuario(Usuario u) throws SQLException {
        usuarioDAO.insere(u);
    }

    public Usuario verificar(String login, String senha) throws SQLException {
        logado = null;
        Usuario u = usuarioDAO.verificaUser(login, senha);
        if(u != null){
            logado = u;
        }
        return u;
    }


    public ObservableList<Usuario> listaUsuario() throws SQLException{
        usuarios.clear();

        usuarios.addAll(usuarioDAO.lista());

        System.out.println(usuarios);

        return usuarios;
    }

    public ObservableList<Nivel> listaNiveis() throws SQLException{
        niveis.clear();

        niveis.addAll(nivelDAO.lista());

        System.out.println(niveis);

        return niveis;
    }

    public void atualizar(Usuario u) throws SQLException{
        u.setId(logado.getId());
        usuarioDAO.atualiza(u);
    }








}






