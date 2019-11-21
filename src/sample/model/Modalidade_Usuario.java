package sample.model;

import java.time.LocalDate;

public class Modalidade_Usuario {

    private Modalidade id_modalidade;
    private Usuario id_usuario;
    private LocalDate data_inicio;
    private LocalDate data_termino;

    public Modalidade_Usuario(){}

    public Modalidade_Usuario(Modalidade id_modalidade, Usuario id_usuario, LocalDate data_inicio, LocalDate data_termino) {
        this.id_modalidade = id_modalidade;
        this.id_usuario = id_usuario;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
    }

    public Modalidade_Usuario(Modalidade id_modalidade, LocalDate data_inicio) {
        this.id_modalidade = id_modalidade;
        this.data_inicio = data_inicio;
    }

    public Modalidade_Usuario(Modalidade id_modalidade, Usuario id_usuario, LocalDate data_inicio) {
        this.id_modalidade = id_modalidade;
        this.id_usuario = id_usuario;
        this.data_inicio = data_inicio;
    }

    public Modalidade getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(Modalidade id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_termino() {
        return data_termino;
    }

    public void setData_termino(LocalDate data_termino) {
        this.data_termino = data_termino;
    }

    @Override
    public String toString() {
        return "Modalidade:" + id_modalidade ;
    }
}