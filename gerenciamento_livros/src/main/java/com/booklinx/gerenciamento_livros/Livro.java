/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.booklinx.gerenciamento_livros;

/**
 *
 * @author muril
 */
public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private double nota;

    public Livro(String titulo, String autor, String genero, double nota) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.nota = nota;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getGenero() {
        return genero;
    }    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public double getNota() {
        return nota;
    }    
    public void setNota(double nota) {
        this.nota = nota;
    }

}
