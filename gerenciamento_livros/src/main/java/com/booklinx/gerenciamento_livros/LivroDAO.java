package com.booklinx.gerenciamento_livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class LivroDAO {
    private Properties properties;
    
    public LivroDAO(Properties p){
        this.properties = p;
        System.out.println(properties);
    }
    
    public void cadastrar(Livro l) throws Exception{
        // 1. especificar o comando SQL
        String sql = "INSERT INTO livros(titulo, autor, genero, nota) VALUES(?, ?, ?, ?)";
        
        // 2. abrir conexao com o MySQL
        var fabricaDeConexoes = new ConnectionFactory(properties);
        var conexao = fabricaDeConexoes.conectar();
        
        // 3. preparar o comando
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        // 4. substituir os eventuais placeholders
        ps.setString(1, l.getTitulo());
        ps.setString(2, l.getAutor());
        ps.setString(3, l.getGenero());
        ps.setDouble(4, l.getNota());
        
        // 5. executar o comando preparado
        ps.execute();
        
        // 6. fechar a conexao
        conexao.close();
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
}
