package sample.control;

import sample.NavegadorCenas;
import sample.model.Controle;

import java.sql.SQLException;

public class JanelaTelaUsuario {

    public void atualizarDados(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_ATUALIZA);
    }

    public void imc(){ NavegadorCenas.loadJanela(NavegadorCenas.JANELA_IMC); }

    public void pdf(){NavegadorCenas.loadJanela(NavegadorCenas.JANELA_PDF);}

    public void cadastrarMod(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_MODALIDADE);
    }

    public void sair(){
        NavegadorCenas.loadJanela(NavegadorCenas.LOGIN);
    }
}
