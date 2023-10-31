package com.booklinx.gerenciamento_livros;

import javax.swing.JOptionPane;

class CadastroUsuario {
    public static void main(String[] args) throws Exception{
        // 1 - cadastrar um usuario
        // 0 - sair
        
        String menu = "1 - Cadastrar\n0 - Sair";
        int op;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(op) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
                    String sexo = JOptionPane.showInputDialog("Digite o sexo");
                    
                    var usuario = new Usuario(nome, idade, sexo);                
                    var usuarioDAO = new UsuarioDAO();
                    usuarioDAO.cadastrar(usuario);
                    
                    break;
            }
        } while(op != 0);
    }
}