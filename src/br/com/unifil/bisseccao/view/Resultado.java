package br.com.unifil.bisseccao.view;
import javax.swing.*;
import java.util.*;

public class Resultado extends javax.swing.JFrame {
    String Resultado = "";
    Scanner teclado = new Scanner(System.in);

    public Resultado() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setResultado(String Resposta){
        Resultado = Resposta;
        CAIXA.setText(Resposta);
    }
    public String RR(){
        return Resultado;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        CAIXA = new javax.swing.JTextArea();

<<<<<<< HEAD
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
=======
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
>>>>>>> 7f3aee15f2b2629cef549faaffe964e058a933d5
        setTitle("Saida");
        setResizable(false);

        CAIXA.setColumns(20);
        CAIXA.setRows(5);
        CAIXA.setText("teste de texto");
        CAIXA.setToolTipText("");
        jScrollPane2.setViewportView(CAIXA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );

        pack();
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Resultado().setVisible(true);
            }
        });
    }

    public javax.swing.JTextArea CAIXA;
    private javax.swing.JScrollPane jScrollPane2;
}

