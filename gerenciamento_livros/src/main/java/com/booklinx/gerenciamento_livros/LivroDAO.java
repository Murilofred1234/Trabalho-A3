/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.booklinx.gerenciamento_livros;

import java.sql.PreparedStatement;

public class LivroDAO {
    public void cadastrar(Livro l) throws Exception{
        // 1. especificar o comando SQL
        String sql = "INSERT INTO livros(titulo, autor, genero, nota) VALUES(?, ?, ?, ?)";
        
        // 2. abrir conexao com o MySQL
        var fabricaDeConexoes = new ConnectionFactory();
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
