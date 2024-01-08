
package csc380_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class retrievemovie extends javax.swing.JFrame {

   
    public retrievemovie() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnretrieve = new javax.swing.JButton();
        txtmovtitle = new javax.swing.JLabel();
        txtmovietitle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtmovielang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        suitablefor = new javax.swing.JLabel();
        txtsuitablefor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnretrieve.setText("Retrieve");
        btnretrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnretrieveActionPerformed(evt);
            }
        });

        txtmovtitle.setText("Movie Title");

        txtmovietitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmovietitleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel1.setText("Retrieve Movie");

        txtmovielang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmovielangActionPerformed(evt);
            }
        });

        jLabel2.setText("Movie Language");

        suitablefor.setText("Suitable For");

        txtsuitablefor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsuitableforActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(150, 150, 150))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(txtmovtitle)
                        .addGap(18, 18, 18)
                        .addComponent(txtmovietitle, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnretrieve))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtmovielang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(suitablefor)
                        .addGap(18, 18, 18)
                        .addComponent(txtsuitablefor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmovtitle)
                    .addComponent(txtmovietitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnretrieve)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmovielang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(suitablefor)
                    .addComponent(txtsuitablefor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmovielangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmovielangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmovielangActionPerformed

    private void txtsuitableforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsuitableforActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsuitableforActionPerformed

    private void btnretrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnretrieveActionPerformed
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/CINEMA", "root", "W@2915djkq#")) {
            String sql = "SELECT Title, SuitableFor,MovieLanguage FROM MOVIE WHERE Title = ?";

            try (PreparedStatement pst = con.prepareStatement(sql)) {
                if (!isStringValid(txtmovietitle.getText())) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid movie title", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    pst.setString(1, txtmovietitle.getText());

                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            // Retrieve and display movie information
                            String title = rs.getString("Title");
                            String suitableFor = rs.getString("SuitableFor");
                        

                            // Display retrieved information
                           txtmovietitle.setText(title);
                           txtsuitablefor.setText(suitableFor);
                           txtmovielang.setText(rs.getString("MovieLanguage"));

                            JOptionPane.showMessageDialog(this, "Movie information retrieved successfully!");
                        } else {
                            JOptionPane.showMessageDialog(this, "Movie not found", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_btnretrieveActionPerformed

    private void txtmovietitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmovietitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmovietitleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Movieplayer jf1=new Movieplayer();
          jf1.show();
     
     dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

     private boolean isStringValid(String text) {
        return text != null && !text.trim().isEmpty();
    }
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
            java.util.logging.Logger.getLogger(retrievemovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retrievemovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retrievemovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retrievemovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new retrievemovie().setVisible(true);
                //txtmovname
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnretrieve;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel suitablefor;
    private javax.swing.JTextField txtmovielang;
    private javax.swing.JTextField txtmovietitle;
    private javax.swing.JLabel txtmovtitle;
    private javax.swing.JTextField txtsuitablefor;
    // End of variables declaration//GEN-END:variables
}
