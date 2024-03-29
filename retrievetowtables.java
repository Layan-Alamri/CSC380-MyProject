package csc380_project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
public class retrievetowtables extends javax.swing.JFrame {

    
    public retrievetowtables() {
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

        retrievetow = new javax.swing.JLabel();
        btnrtwo = new javax.swing.JButton();
        phone = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        seatnum = new javax.swing.JLabel();
        txtcustomername = new javax.swing.JLabel();
        txtseatnum = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        retrievetow.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        retrievetow.setText("Retrieve from tow tables");

        btnrtwo.setText("Retrieve ");
        btnrtwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrtwoActionPerformed(evt);
            }
        });

        phone.setText("Phone");

        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });

        seatnum.setText("SeatNum");

        txtcustomername.setText("Customer Name");
        txtcustomername.setToolTipText("customername");

        txtseatnum.setToolTipText("");
        txtseatnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtseatnumActionPerformed(evt);
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
                .addComponent(retrievetow)
                .addGap(132, 132, 132))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(seatnum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtseatnum, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtcustomername)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(phone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnrtwo)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(retrievetow)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnrtwo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seatnum)
                    .addComponent(txtcustomername)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtseatnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrtwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrtwoActionPerformed
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/CINEMA", "root", "W@2915djkq#")) {
        String phone = txtphone.getText();

        // Retrieve Seatnum from TICKET table
        String ticketSql = "SELECT Seatnum FROM TICKET WHERE Customerphone = ?";

        try (PreparedStatement pstTicket = con.prepareStatement(ticketSql)) {
            pstTicket.setString(1, phone);

            try (ResultSet rsTicket = pstTicket.executeQuery()) {
                if (rsTicket.next()) {
                    int seatnum = rsTicket.getInt("Seatnum");

                    // Display or use the retrieved Seatnum information as needed
                    txtseatnum.setText(String.valueOf(seatnum));
                } else {
                    JOptionPane.showMessageDialog(this, "Ticket not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Retrieve Name from CUSTOMER table
        String customerSql = "SELECT Name FROM CUSTOMER WHERE Phone = ?";

        try (PreparedStatement pstCustomer = con.prepareStatement(customerSql)) {
            pstCustomer.setString(1, phone);

            try (ResultSet rsCustomer = pstCustomer.executeQuery()) {
                if (rsCustomer.next()) {
                    String name = rsCustomer.getString("Name");

                    // Display or use the retrieved Name information as needed
                    jTextField2.setText(name);
                } else {
                    JOptionPane.showMessageDialog(this, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    } catch (Exception ee) {
        JOptionPane.showMessageDialog(this, "Error: " + ee.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ee.printStackTrace();
    }

    }//GEN-LAST:event_btnrtwoActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void txtseatnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtseatnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtseatnumActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Worker jf2=new Worker();
        jf2.show();

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(retrievetowtables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(retrievetowtables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(retrievetowtables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(retrievetowtables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new retrievetowtables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrtwo;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel retrievetow;
    private javax.swing.JLabel seatnum;
    private javax.swing.JLabel txtcustomername;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtseatnum;
    // End of variables declaration//GEN-END:variables
}
