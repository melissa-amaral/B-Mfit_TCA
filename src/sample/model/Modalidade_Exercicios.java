package sample.model;

public class Modalidade_Exercicios {

    private Modalidade id_modalidade;
    private Exercicio id_exercicio;

    public Modalidade_Exercicios(Modalidade id_modalidade, Exercicio id_exercicio) {
        this.id_modalidade = id_modalidade;
        this.id_exercicio = id_exercicio;
    }

    public Modalidade getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(Modalidade id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public Exercicio getId_exercicio() {
        return id_exercicio;
    }

    public void setId_exercicio(Exercicio id_exercicio) {
        this.id_exercicio = id_exercicio;
    }
}
