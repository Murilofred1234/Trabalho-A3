package com.booklinx.gerenciamento_livros;

import java.sql.PreparedStatement;
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
}
