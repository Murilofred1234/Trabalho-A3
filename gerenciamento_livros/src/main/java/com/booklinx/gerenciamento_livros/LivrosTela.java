/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.booklinx.gerenciamento_livros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author muril
 */
public class LivrosTela extends javax.swing.JFrame {

    private Properties properties;
    private Usuario usuario;
    
    public LivrosTela() {
        super ("Livros");
        initComponents();
        setLocationRelativeTo(null);
    }

    LivrosTela(Properties p, Usuario u) {
        this();
        this.properties = p;
        this.usuario = u;
        System.out.println(properties);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exibirTodosButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        voltarButton = new javax.swing.JButton();
        buscarLivroButton = new javax.swing.JButton();
        livroTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exibirTodosButton.setText("Mostrar livros");
        exibirTodosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirTodosButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Título", "Autor", "Gênero", "Nota"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        buscarLivroButton.setText("Buscar livro");
        buscarLivroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLivroButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(exibirTodosButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buscarLivroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(livroTextField))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exibirTodosButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarLivroButton)
                    .addComponent(livroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(voltarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exibirTodosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirTodosButtonActionPerformed
        try {
            ConnectionFactory fabrica = new ConnectionFactory(properties);
            Connection con = fabrica.conectar();
            
            Statement st = con.createStatement();
            String sql = "SELECT * FROM livros ORDER BY nota DESC";
            ResultSet rs = st.executeQuery(sql);
            
            DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
            tblModel.setRowCount(0);
            
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id_livro"));
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String genero = rs.getString("genero");
                String nota = String.valueOf(rs.getDouble("nota"));
                
                String tbData[] = {id, titulo, autor, genero, nota};                           
                tblModel.addRow(tbData);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_exibirTodosButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        if (usuario.getAdm() == 1) {
            DashboardTelaAdm dt = new DashboardTelaAdm(properties, usuario);
            dt.setVisible(true);
            this.dispose();
        }
        else {
            DashboardTelaUsuario dt = new DashboardTelaUsuario(properties, usuario);
            dt.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void buscarLivroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLivroButtonActionPerformed
        String livro = livroTextField.getText();
        Livro l = new Livro(livro);
        LivroDAO dao = new LivroDAO(properties);
        try {
            if(dao.existe(l) != null) {
                l = dao.buscar(l);
                String id = String.valueOf(l.getId());
                String titulo = l.getTitulo();
                String autor = l.getAutor();
                String genero = l.getGenero();
                String nota = String.valueOf(l.getNota());
                
                String tbData[] = {id, titulo, autor, genero, nota};
                DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
                tblModel.setRowCount(0);
                tblModel.addRow(tbData);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_buscarLivroButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LivrosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LivrosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LivrosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LivrosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LivrosTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarLivroButton;
    private javax.swing.JButton exibirTodosButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField livroTextField;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}