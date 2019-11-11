package sample.model;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.ListNumberingType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Controle {

    UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    NivelDAO nivelDAO = new NivelDAOImpl();
    ImcDAO imcDAO = new ImcDAOImpl();
    DietaDAO dietaDAO = new DietaDAOImpl();

    private ObservableList<Usuario> usuarios;
    private ObservableList<Nivel> niveis;
    private ObservableList<IMC> imcs;
    private ObservableList<Dieta> dietas;
    private Usuario logado;

    private static Controle instance=new Controle();

    public Controle() {
        usuarios = FXCollections.observableArrayList();
        niveis = FXCollections.observableArrayList();
        imcs = FXCollections.observableArrayList();
        dietas = FXCollections.observableArrayList();
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

    public ObservableList<Dieta> listaDieta() throws SQLException{
        dietas.clear();
        dietas.addAll(dietaDAO.lista());
        return dietas;
    }

    //este método cria um documento para receber o conteúdo
    private Document abreDocumento(String arq) throws IOException {
        PdfWriter writer = new PdfWriter(arq);
        PdfDocument pdf  = new PdfDocument(writer);
        Document document = new Document(pdf);

        return  document;
    }

    public void criaPdf(String arq, Dieta dieta){

        try{
            Document document = abreDocumento(arq);

            // Cria uma fonte
            PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);

            String x = dieta.getDescricao();

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

}






