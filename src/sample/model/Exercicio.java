package sample.model;

public class Exercicio {

    private  int id;
    private String nome;
    private int tipo;
    //private demonstracao;
    private String descricao;
    private int repeticao;
    private int tempo;

    public Exercicio(String nome, String descricao, int repeticao, int tempo) {
        this.nome = nome;
        this.descricao = descricao;
        this.repeticao = repeticao;
        this.tempo = tempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
