package com.teknikindustries.messagepane;

public class MainFrame extends javax.swing.JFrame 
{
    public static boolean option = false;

    public MainFrame() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Question = new javax.swing.JLabel();
        NoButton = new javax.swing.JLabel();
        YesButton = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setToolTipText("");
        getContentPane().add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 410, 15));

        Question.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Question.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Question, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 43, 310, 50));

        NoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NoButtonMouseReleased(evt);
            }
        });
        getContentPane().add(NoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 130, 170, 32));

        YesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        YesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                YesButtonMouseReleased(evt);
            }
        });
        getContentPane().add(YesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, 32));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/teknikindustries/messagepane/Layout.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 425, 185));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NoButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoButtonMouseReleased

    }//GEN-LAST:event_NoButtonMouseReleased

    private void YesButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YesButtonMouseReleased

    }//GEN-LAST:event_YesButtonMouseReleased
    
    public static void main(String args[]) 
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel NoButton;
    public static javax.swing.JLabel Question;
    public static javax.swing.JLabel Title;
    private javax.swing.JLabel YesButton;
    // End of variables declaration//GEN-END:variables
}