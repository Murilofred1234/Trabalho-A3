/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.booklinx.gerenciamento_livros;

import java.io.FileReader;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws Exception{ 
        
        FileReader fr = new FileReader("C:\\Users\\muril\\Documents\\importante\\usjt\\gerenciamento_livros\\Trabalho-A3\\gerenciamento_livros\\src\\main\\java\\com\\booklinx\\gerenciamento_livros\\properties\\DatabaseConnection.properties");
        Properties p = new Properties();
        p.load(fr);
               
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginTela(p).setVisible(true);
            }
        });
    }
}
