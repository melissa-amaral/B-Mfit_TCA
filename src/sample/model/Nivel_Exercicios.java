package sample.model;

public class Nivel_Exercicios {

    private Nivel id_nivel;
    private Exercicio id_exercicio;

    public Nivel_Exercicios(Nivel id_nivel, Exercicio id_exercicio) {
        this.id_nivel = id_nivel;
        this.id_exercicio = id_exercicio;
    }

    public Nivel getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(Nivel id_nivel) {
        this.id_nivel = id_nivel;
    }

    public Exercicio getId_exercicio() {
        return id_exercicio;
    }

    public void setId_exercicio(Exercicio id_exercicio) {
        this.id_exercicio = id_exercicio;
    }
}
