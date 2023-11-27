/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.booklinx.gerenciamento_livros;

/**
 *
 * @author muril
 */
public class Nota {
    private int id;
    private int idLivro;
    private int idUsuario;
    private double nota;
    
    public Nota(int idLivro, int idUsuario, double nota) {
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
        this.nota = nota;
    }

    public Nota() {
        
    }
    
    public int getId() {
        return id;
    }
    
    public int getIdLivro() {
        return idLivro;
    }
    
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
    
}
