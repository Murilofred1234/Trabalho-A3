/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.booklinx.gerenciamento_livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 *
 * @author muril
 */
class NotaDAO {
    private Properties properties;
    
    public NotaDAO(Properties p){
        this.properties = p;      
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
    
    public double media(int idLivro) throws Exception{
        double quantidadeAvaliacoes = 0;
        double totalNotas = 0;
        double nota;
        
        String sql = "SELECT * FROM notas WHERE id_livro = ?";
        
        ConnectionFactory fabric = new ConnectionFactory(properties);
        try (Connection conexao = fabric.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idLivro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nota = rs.getDouble("nota");
                totalNotas += nota;
                quantidadeAvaliacoes += 1;
            }
            double media = totalNotas / quantidadeAvaliacoes;
            return media;
        }                        
    }
}
