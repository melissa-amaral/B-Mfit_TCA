package sample.model;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class Controle {

    UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    NivelDAO nivelDAO = new NivelDAOImpl();
    ImcDAO imcDAO = new ImcDAOImpl();
    DietaDAO dietaDAO = new DietaDAOImpl();
    ModalidadeDAO modalidadeDAO = new ModalidadeDAOImpl();
    Modalidade_UsuarioDAO modalidade_usuarioDAO = new Modalidade_UsuarioDAOImpl();
    ExercicioDAO exercicioDAO = new ExercicioDAOImpl();

    private ObservableList<Usuario> usuarios;
    private ObservableList<Nivel> niveis;
    private ObservableList<IMC> imcs;
    private ObservableList<Alimentacao> alimentacaos;
    private ObservableList<Modalidade> modalidades;
    private ObservableList<Modalidade_Usuario> modalidade_usuarios;
    private ObservableList<Exercicio> exercicios;
    private Usuario logado;

    private static Controle instance=new Controle();

    public Controle() {
        usuarios = FXCollections.observableArrayList();
        niveis = FXCollections.observableArrayList();
        imcs = FXCollections.observableArrayList();
        alimentacaos = FXCollections.observableArrayList();
        modalidades = FXCollections.observableArrayList();
        modalidade_usuarios = FXCollections.observableArrayList();
        exercicios = FXCollections.observableArrayList();
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

    public void cadastrarIMC(float kg, float altura, LocalDate data) throws SQLException{
        IMC i = new IMC(kg, altura, data);
        i.setUsuario(logado);
        imcDAO.insere(i);
    }

    public void atualizarIMC(float kg, float altura, LocalDate data) throws SQLException{
        IMC i = new IMC();
        i.setKg_atual(kg);
        i.setAltura(altura);
        i.setData_atual(data);
        i.setUsuario(logado);

        imcDAO.atualiza(i);
    }

    public ObservableList<IMC> listarIMC() throws SQLException{
        imcs.clear();
        imcs.addAll(imcDAO.lista());
        return imcs;
    }

    public ObservableList<Alimentacao> listaDieta() throws SQLException{
        alimentacaos.clear();
        alimentacaos.addAll(dietaDAO.lista());
        return alimentacaos;
    }

    //este método cria um documento para receber o conteúdo
    private Document abreDocumento(String arq) throws IOException {
        PdfWriter writer = new PdfWriter(arq);
        PdfDocument pdf  = new PdfDocument(writer);
        Document document = new Document(pdf);

        return  document;
    }

    public void criaPdf(String arq, Alimentacao alimentacao){
        try{
            Document document = abreDocumento(arq);

            // Cria uma fonte
            PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);

            String x = alimentacao.getDescricao();

            String[] lista = x.split(";");

            for(String s:lista){
                //adiciona um parágrafo no documento.
                document.add(new Paragraph(s).setFont(font));
            }

            //fecha o documento
            document.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public IMC buscaIMC() throws SQLException{
        IMC imc = imcDAO.buscaIMC(logado);
        return imc;
    }

    public ObservableList<Modalidade> listaModalidade() throws SQLException{
        modalidades.clear();
        modalidades.addAll(modalidadeDAO.lista());

        return modalidades;
    }

    public void cadastarModalidadeUser(Modalidade mod, LocalDate data) throws SQLException{
        Modalidade_Usuario mod_u = null;
        mod_u = buscaMU();
        if (mod_u != null && mod_u.getData_termino() == null){
            modalidade_usuarioDAO.atualiza(mod_u);
        }

        Modalidade_Usuario mu = new Modalidade_Usuario(mod, data);
        mu.setId_usuario(logado);

        modalidade_usuarioDAO.insere(mu);
    }






    public Modalidade_Usuario buscaMU() throws SQLException{
        Modalidade_Usuario mu = modalidade_usuarioDAO.buscaModalidadeUsuario(logado);
        return mu;
    }

    public Modalidade_Usuario buscaNomeMU() throws SQLException{
        Modalidade_Usuario mu = modalidade_usuarioDAO.buscaRapidaMU(logado);
        return mu;
    }

    public ObservableList<Exercicio> aleatorio() throws SQLException{
        exercicios.clear();
        exercicios.addAll(exercicioDAO.Aleatorio(logado));
        return exercicios;
    }

    /*
    public ObservableList<Exercicio> Personalizado() throws SQLException{
        exercicios.clear();
        exercicios.addAll(exercicioDAO.Personalizado(logado));
        return exercicios;
    }
     */

    public ObservableList<Exercicio> listaExercicios() throws SQLException{

        ObservableList<Exercicio> aux = FXCollections.observableArrayList();

        //EMBARALHA A LISTA DE EXERCICIOS QUE VAI RETORNAR
        if(tipo == 1){
            aux.addAll(aleatorio().sorted());
        }
        else if(tipo == 2){
            //aux.addAll(personalizado().sorted());
        }

        for(Exercicio e: aux){
            if(exercicios.size() < 10) {
                this.exercicios.add(e);
            }
        }

        //Adiciona os sorteados ao aux e embaralha
        aux.clear();
        aux.addAll(exercicios);
        aux = aux.sorted();

        //Limpa os sorteados e adiciona aux
        this.exercicios.clear();
        this.exercicios.addAll(aux);

        return this.exercicios;
    }






}






