package sample.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class IMC {

    private int id;
    private Usuario usuario;
    private float kg_inicial;
    private float altura;
    private LocalDate data_inicial;
    private float kg_atual;
    private LocalDate data_atual;


    public IMC(){

    }

    public IMC(float kg_inicial, float altura, LocalDate data_inicial) {
        this.kg_inicial = kg_inicial;
        this.altura = altura;
        this.data_inicial = data_inicial;
    }

    public IMC(Usuario usuario, float kg_inicial, float altura, LocalDate data_inicial, float kg_atual, LocalDate data_atual) {
        this.usuario = usuario;
        this.kg_inicial = kg_inicial;
        this.altura = altura;
        this.data_inicial = data_inicial;
        this.kg_atual = kg_atual;
        this.data_atual = data_atual;
    }

    public IMC(int id, Usuario usuario, float kg_inicial, float altura, LocalDate data_inicial, float kg_atual, LocalDate data_atual) {
        this.id = id;
        this.usuario = usuario;
        this.kg_inicial = kg_inicial;
        this.altura = altura;
        this.data_inicial = data_inicial;
        this.kg_atual = kg_atual;
        this.data_atual = data_atual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public float getKg_inicial() {
        return kg_inicial;
    }

    public void setKg_inicial(float kg_inicial) {
        this.kg_inicial = kg_inicial;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public LocalDate getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(LocalDate data_inicial) {
        this.data_inicial = data_inicial;
    }

    public float getKg_atual() {
        return kg_atual;
    }

    public void setKg_atual(float kg_atual) {
        this.kg_atual = kg_atual;
    }

    public LocalDate getData_atual() {
        return data_atual;
    }

    public void setData_atual(LocalDate data_atual) {
        this.data_atual = data_atual;
    }
}
