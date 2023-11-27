package com.booklinx.gerenciamento_livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UsuarioDAO {
    private Properties properties;
    
    public UsuarioDAO(Properties p){
        this.properties = p;
        System.out.println(properties);
    }
    
    public void cadastrar(Usuario u) throws Exception{
        String sql = "INSERT INTO usuarios(nome, idade, sexo, login, senha, adm) VALUES(?, ?, ?, ?, ?, ?)";
        ConnectionFactory fabricaDeConexoes = new ConnectionFactory(properties);
        
        try(Connection conexao = fabricaDeConexoes.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, u.getNome());
            ps.setInt(2, u.getIdade());
            ps.setString(3, u.getSexo());
            ps.setString(4, u.getLogin());
            ps.setString(5, u.getSenha());
            ps.setInt(6, u.getAdm());

            ps.execute();
        }
    }
    
    public Usuario existe(Usuario u) throws Exception{
        ConnectionFactory fabrica = new ConnectionFactory(properties);
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        
        try(Connection conexao = fabrica.conectar()){          
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setString(1, u.getLogin());
                ps.setString(2, u.getSenha());

                try(ResultSet rs = ps.executeQuery()){
                    return rs.next() ? u : null;
                }
            }            
        }
    }

    public Usuario buscar(Usuario u) throws Exception {
        ConnectionFactory fabrica = new ConnectionFactory(properties);
        String sql = "SELECT * FROM usuarios WHERE login = ?";
        
        try(Connection conexao = fabrica.conectar()){          
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setString(1, u.getLogin());

                try(ResultSet rs = ps.executeQuery()){
                    if (rs.next()) {
                        int id = rs.getInt("id_usuario");
                        String nome = rs.getString("nome");
                        int idade = rs.getInt("idade");
                        String sexo = rs.getString("sexo");
                        String login = rs.getString("login");
                        String senha = "";
                        int adm = rs.getInt("adm");
                        
                        return new Usuario(id, nome, idade, sexo, login, senha, adm);
                    } else {
                        return null;
                    }
                }
            }            
        }
    }
}
