/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.booklinx.gerenciamento_livros;

import java.sql.PreparedStatement;
import java.util.Properties;

/**
 *
 * @author muril
 */
class NotaDAO {
    private Properties properties;
    
    public NotaDAO(Properties p){
        this.properties = p;
        System.out.println(properties);
    }
    
    public void cadastrar(Nota n) throws Exception {
        String sql = "INSERT INTO notas(id_livro, id_usuario, nota) VALUES(?, ?, ?)";
        
        var fabricaDeConexoes = new ConnectionFactory(properties);
        try (java.sql.Connection conexao = fabricaDeConexoes.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, n.getIdLivro());
            ps.setInt(2, n.getIdUsuario());
            ps.setDouble(3, n.getNota());
            
            ps.execute();
        }
    }
}
