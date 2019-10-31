package sample.model;

import java.time.LocalDateTime;

public class IMC {

    private int id;
    private Usuario id_usuario;
    private float kg;
    private float altura;
    private LocalDateTime data;

    public IMC(Usuario id_usuario, float kg, float altura, LocalDateTime data) {
        this.id_usuario = id_usuario;
        this.kg = kg;
        this.altura = altura;
        this.data = data;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public float getKg() {
        return kg;
    }

    public void setKg(float kg) {
        this.kg = kg;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
