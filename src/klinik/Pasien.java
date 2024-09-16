/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package klinik;
import java.sql.*;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jagad
 */
public class Pasien extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.KoneksiDatabase.Koneksi();
    public Pasien() {
        initComponents();
        TampilData("");
        
    btnSimpan.setEnabled(true);
    btnUbah.setEnabled(false);
    btnHapus.setEnabled(false);
    }
    
    private void Bersih(){
    btnSimpan.setEnabled(true);
    btnUbah.setEnabled(false);
    btnHapus.setEnabled(false);

    txtid_pasien.setEditable(true);

    txtid_pasien.setText("");
    txtnama_pasien.setText("");
    txtalamat_pasien.setText("");
    txttelp_pasien.setText("");
    }
    
    private void TampilData(String string){
try {
    st = cn.createStatement();
    rs = st.executeQuery("SELECT * FROM pasien ORDER BY id_pasien ASC");
    
    DefaultTableModel model = new DefaultTableModel ();
    model.addColumn("id");
    model.addColumn("nama");
    model.addColumn("alamat");
    model.addColumn("telp");
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
    model.setRowCount(0);
    
    while (rs.next()){
    Object [] data = {
    rs.getString("id_pasien"),
    rs.getString("nama_pasien"),
    rs.getString("alamat_pasien"),
    rs.getString("telp_pasien")
    };
    
    model.addRow(data);
    tblData.setModel(model);
    }
} catch (Exception e){
}
}

        private String cekIDpasien;
        private void cekIDpasien()
        {
            try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) as total FROM administrasi WHERE id_pasien = '" + txtid_pasien.getText() + "'");
            
            while (rs.next()) {
                this.cekIDpasien = rs.getString("total");
            }
            
            if (Integer.parseInt(cekIDpasien) > 0) {
                btnHapus.setEnabled(false);
            } else {
                btnHapus.setEnabled(true);
            }
            
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        private void cekINTtelp()
        {
        try {

            Integer.parseInt(txttelp_pasien.getText());

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Ups..... no. telp harus angka");

            return;

        }
    }

    /**
     * Creates new form Pasien
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid_pasien = new javax.swing.JTextField();
        txtnama_pasien = new javax.swing.JTextField();
        txtalamat_pasien = new javax.swing.JTextField();
        txttelp_pasien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("id");

        jLabel2.setText("nama");

        jLabel3.setText("alamat");

        jLabel4.setText("telp");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel5.setText("PASIEN");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Reset");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "nama", "alamat", "telp"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatal))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtid_pasien)
                            .addComponent(txtnama_pasien)
                            .addComponent(txtalamat_pasien)
                            .addComponent(txttelp_pasien))))
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnama_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtalamat_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttelp_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // TODO add your handling code here:

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        cekINTtelp();
       try {
       st = cn.createStatement();
       if (txtid_pasien.getText().equals("")|| txtnama_pasien.getText().equals("") ||
               txttelp_pasien.getText().equals("") || txtalamat_pasien.getText().equals("")) {
       JOptionPane.showMessageDialog(null, "Data tidak boleh kosong", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);       
       return;
       }
       if (btnSimpan.getText() == "Simpan"){
            String cek = "SELECT * FROM pasien WHERE id_pasien = '" + txtid_pasien.getText() + "'";
            rs = st.executeQuery(cek);
            if (rs.next()){
            JOptionPane.showMessageDialog(null, "Ups.....id_pasien sudah ada");
            } else {
            String sql  = "INSERT INTO pasien VALUES ('"+ txtid_pasien.getText() + 
                    "', '"+ txtnama_pasien.getText() +
                    "', '"+ txtalamat_pasien.getText() + 
                    "', '"+ txttelp_pasien.getText() + "')";
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            TampilData ("");
            Bersih ();
            }
       }
       } catch (Exception e){
               }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        Bersih ();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {
          int jawab;

          if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
            st = cn.createStatement();
            st.execute("DELETE FROM pasien WHERE id_pasien='"
                + tblData.getValueAt(tblData.getSelectedRow(), 0) + "'");
            TampilData("");
            Bersih ();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        cekINTtelp();
          try {
          st = cn.createStatement();
          st.execute("UPDATE pasien set " 
              + "nama_pasien='"      + txtnama_pasien.getText() + "', "
              + "alamat_pasien='"   + txtalamat_pasien.getText() + "', "
              + "telp_pasien='"    + txttelp_pasien.getText() + "' WHERE "
              + "id_pasien='"       + txtid_pasien.getText() + "'");
          TampilData("");
          JOptionPane.showMessageDialog(null, "Update Berhasil");
          Bersih ();
          } catch (Exception e) {
//          e.printStackTrace();
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        txtid_pasien.setText(tblData.getValueAt(tblData.getSelectedRow(), 0).toString());
        txtnama_pasien.setText(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
        txtalamat_pasien.setText(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
        txttelp_pasien.setText(tblData.getValueAt(tblData.getSelectedRow(), 3).toString());
        
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(true);
//        btnHapus.setEnabled(true);
        txtid_pasien.setEditable(false);
        cekIDpasien();
    }//GEN-LAST:event_tblDataMouseClicked

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
            java.util.logging.Logger.getLogger(Pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtalamat_pasien;
    private javax.swing.JTextField txtid_pasien;
    private javax.swing.JTextField txtnama_pasien;
    private javax.swing.JTextField txttelp_pasien;
    // End of variables declaration//GEN-END:variables
}
