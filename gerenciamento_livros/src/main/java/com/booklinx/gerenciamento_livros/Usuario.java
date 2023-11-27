package com.booklinx.gerenciamento_livros;

public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private String login;
    private String senha;
    private int adm;
    
    public Usuario(int id, String nome, int idade, String sexo, String login, String senha, int adm) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.login = login;
        this.senha = senha;
        this.adm = adm;
    }
    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    public Usuario() {}
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public int getAdm() {
        return adm;
    }
    
    public void setAdm(int adm) {
        this.adm = adm;
    }
}
