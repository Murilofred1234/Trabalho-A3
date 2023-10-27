package com.booklinx.gerenciamento_livros;

import java.sql.PreparedStatement;

public class UsuarioDAO {
    public void cadastrar(Usuario u) throws Exception{
        // 1. especificar o comando SQL
        String sql = "INSERT INTO usuarios(nome, idade, sexo) VALUES(?, ?, ?)";
        
        // 2. abrir conexao com o MySQL
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.conectar();
        
        // 3. preparar o comando
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        // 4. substituir os eventuais placeholders
        ps.setString(1, u.getNome());
        ps.setInt(2, u.getIdade());
        ps.setString(3, u.getSexo());
        
        // 5. executar o comando preparado
        ps.execute();
        
        // 6. fechar a conexao
        conexao.close();
    }
}
