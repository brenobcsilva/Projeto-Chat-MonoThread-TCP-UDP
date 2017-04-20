package com.Programacao.Concorrente.Cliente;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author ronaldo
 */
public class Cliente extends javax.swing.JFrame {

    private Socket cliente;
   
  //  JButton b1, b2;
    /**
     * Creates new form FClient
     */ 
    public Cliente() {
        initComponents();
        initCliente();
        
    }

    private void initCliente() {
        try {
            cliente = new Socket("127.0.0.1", 9009);
        } catch (IOException ex) {
            Logger.getLogger(FCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        //jScrollPane1 = new javax.swing.JScrollPane();
        
       // jScrollPane1.setBackground(Color.red);
        
    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setBackground(Color.white);
        jTextArea1.setCaretColor(Color.red);
        jTextArea1.setDebugGraphicsOptions(HEIGHT);
        jTextArea1.setForeground(Color.blue);
       
        jScrollPane1.setViewportView(jTextArea1);
     
        jButton1.setText("Enviar Mensagem");
        jButton1.setBackground(Color.lightGray);
        
        jLabel1.setForeground(Color.white);
        jLabel1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 16)); 
        jLabel.setText("      \t");
        jLabel1.setText("     \tProgramacao Concorrente - Professor Ilo. Chat para somente um usuario de cada vez acessar.");
       
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
     
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addComponent(jLabel1)
                                                .addGap(4)
                                                .addComponent(jLabel)
                                                   
                                                
                                              //  .addGap(0, 0, Short.MAX_VALUE)
                                        ))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addComponent(jLabel1)
                                .addGap(0)
                                .addComponent(jLabel)
                                
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold> 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            saida.println(jTextArea1.getText());
            jTextArea1.setText("");
        } catch (IOException ex) {
            Logger.getLogger(FCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.GroupLayout groupLayout; 
    
    // End of variables declaration      
    
    
   
}
