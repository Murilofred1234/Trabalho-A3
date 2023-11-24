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
        String sql = "INSERT INTO usuarios(nome, idade, sexo) VALUES(?, ?, ?)";
        ConnectionFactory fabricaDeConexoes = new ConnectionFactory(properties);
        
        try(Connection conexao = fabricaDeConexoes.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, u.getNome());
            ps.setInt(2, u.getIdade());
            ps.setString(3, u.getSexo());

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
}
