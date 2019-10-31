package sample.model;

public class Usuario{

    private int id;
    private String nome;
    private Nivel id_nivel;
    private String rg;
    private String cpf;
    private String login;
    private String senha;
    private String email;

    public Usuario(String nome, Nivel id_nivel, String rg, String cpf, String login, String senha, String email) {
        this.nome = nome;
        this.id_nivel = id_nivel;
        this.rg = rg;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    //falta construtor

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

    public Nivel getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(Nivel id_nivel) {
        this.id_nivel = id_nivel;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
