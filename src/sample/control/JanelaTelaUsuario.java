package sample.control;

import sample.NavegadorCenas;

public class JanelaTelaUsuario {

    public void atualizarDados(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_ATUALIZA);
    }

    public void IMC(){
        NavegadorCenas.loadJanela(NavegadorCenas.JANELA_IMC);
    }

    public void voltar(){
        NavegadorCenas.loadJanela(NavegadorCenas.LOGIN);
    }
}
