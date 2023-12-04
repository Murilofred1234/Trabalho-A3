package com.booklinx.gerenciamento_livros;

import java.awt.List;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class LivroDAO {
    private Properties properties;
    
    public LivroDAO(Properties p){
        this.properties = p;
    }
    
    public void cadastrar(Livro l) throws Exception{
        String sql = "INSERT INTO livros(titulo, autor, genero, nota) VALUES(?, ?, ?, ?)";
        
        var fabricaDeConexoes = new ConnectionFactory(properties);
        try (java.sql.Connection conexao = fabricaDeConexoes.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getGenero());
            ps.setDouble(4, l.getNota());
            
            ps.execute();
        }
    }
    
    public Livro existe(Livro l) throws Exception{
        ConnectionFactory fabrica = new ConnectionFactory(properties);
        String sql = "SELECT * FROM livros WHERE titulo = ?";
        
        try(Connection conexao = fabrica.conectar()){          
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setString(1, l.getTitulo());

                try(ResultSet rs = ps.executeQuery()){
                    if (rs.next()) {
                        return l;
                    } else {
                        return null;
                    }
                }
            }            
        }
    }
    
    public Livro buscar(Livro l) throws Exception {
        ConnectionFactory fabrica = new ConnectionFactory(properties);
        String sql = "SELECT * FROM livros WHERE titulo = ?";
        
        try(Connection conexao = fabrica.conectar()){          
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setString(1, l.getTitulo());

                try(ResultSet rs = ps.executeQuery()){
                    if (rs.next()) {
                        int id = rs.getInt("id_livro");
                        String titulo = rs.getString("titulo");
                        String autor = rs.getString("autor");
                        String genero = rs.getString("genero");
                        double nota = rs.getDouble("nota");
                        Livro livro = new Livro(id, titulo, autor, genero, nota);
                        return livro;
                    } else {
                        return null;
                    }
                }
            }            
        }
    }
    
    public ArrayList<String> buscarGeneros() throws Exception {
        String sql = "SELECT genero FROM livros";
        ArrayList <String> generos = new ArrayList<>();
        
        ConnectionFactory fabric = new ConnectionFactory(properties);
        try(Connection conn = fabric.conectar()) {
            PreparedStatement ps = conn.prepareStatement(sql);           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String genero = rs.getString("genero");
                if (!generos.contains(genero)) {
                   generos.add(genero);
                }
               
            }
            return generos;
        }                    
    }
}
