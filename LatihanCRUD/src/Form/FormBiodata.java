/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import Config.KoneksiDB;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Asus
 */
public class FormBiodata extends javax.swing.JFrame {

    //Menyiapkan objek yang diperlukan untuk mengola database
    private Statement st;
    private ResultSet rs;
    private Connection conn;
    
    /**
     * Creates new form FormBiodata
     */
    public FormBiodata() {
        initComponents();
        conn = KoneksiDB.getKoneksi();
        tampilData();
    }

    private void tampilData () {
        DefaultTableModel kolomtabel = new DefaultTableModel(); 
        kolomtabel.addColumn("No."); 
        kolomtabel.addColumn("Nama"); 
        kolomtabel.addColumn("NIM"); 
        kolomtabel.addColumn("TTL"); 
        kolomtabel.addColumn("Jenis Kelamin"); 
        kolomtabel.addColumn("Prodi"); 
        kolomtabel.addColumn("No. Telepon"); 
        kolomtabel.addColumn("Alamat"); 
 
        try { 
            int nomor = 1; 
 
            // buat objek statement untuk mengeksekusi query mysql. 
            st = conn.createStatement(); 
 
            // buat query ke database 
            String sql = "Select * FROM tbl_biodata"; 
 
            // eksekusi query dan simpan hasilnya di objek ResultSet 
            rs = st.executeQuery(sql); 
 
            // tampilkan hasil query menggunakan perulangan while 
            while (rs.next()) { 
                kolomtabel.addRow(new Object[]{ 
                    ("" + nomor++), 
                    rs.getString("nama"), 
                    rs.getString("nim"), 
                    rs.getString("ttl"), 
                    rs.getString("jekel"), 
                    rs.getString("prodi"), 
                    rs.getString("notelp"), 
                    rs.getString("alamat"),}
                ); 
                tblBiodata.setModel(kolomtabel); 
                tblBiodata.enable(true); 
                tfNama.requestFocus(); 
            } 
 
 
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data. \n" + e.getMessage()); 
        } 
    }
    
    private void clearForm() {
        tfNama.setText(""); 
        tfNim.setText(""); 
        tfTTL.setText(""); 
        buttonGroup1.clearSelection(); 
        cmbProdi.setSelectedItem("-- Program Studi --"); 
        tfNomorTelp.setText(""); 
        taAlamat.setText(""); 
        tfNama.requestFocus(); 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        tfNim = new javax.swing.JTextField();
        tfTTL = new javax.swing.JTextField();
        tfNomorTelp = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        cmbProdi = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBiodata = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Biodata");

        jLabel2.setText("Nama Mahasiswa/i :");

        jLabel3.setText("NIM :");

        jLabel4.setText("Tempat dan Tgl. Lahir :");

        jLabel5.setText("Jenis Kelamin :");

        jLabel6.setText("Prodi :");

        jLabel7.setText("Nomor Telp :");

        jLabel8.setText("Alamat :");

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbLaki);
        rbLaki.setText("Laki - laki");

        buttonGroup1.add(rbPerempuan);
        rbPerempuan.setText("Perempuan");

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane1.setViewportView(taAlamat);

        cmbProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Program Studi --", "Teknik Informatika", "Teknik Industri", "Teknik Lingkungan", "Teknik Arsitektur", "Manajemen" }));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblBiodata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "no", "Nama", "Nim", "Ttl", "Jenis Kelamin", "Prodi", "No.Telp", "Alamat"
            }
        ));
        jScrollPane2.setViewportView(tblBiodata);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbPerempuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tfNomorTelp)
                                    .addComponent(tfNama)
                                    .addComponent(tfNim)
                                    .addComponent(tfTTL)
                                    .addComponent(cmbProdi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnSubmit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExit)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfTTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rbLaki)
                            .addComponent(rbPerempuan))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(tfNomorTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnSubmit)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnExit))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int jawab = JOptionPane.showOptionDialog(this, 
                "Apakah Anda Ingin Keluar?",
                "Exit", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (jawab == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if (tfNama.getText().equals("") 
            || tfNim.getText().equals("") 
            || tfTTL.getText().equals("") 
            || tfNomorTelp.getText().equals("") 
            || taAlamat.getText().equals("") 
            || buttonGroup1.isSelected(null) 
            || cmbProdi.getSelectedItem().equals("-- Program Studi --")) { 
           JOptionPane.showMessageDialog(this, "Field harap di isi !", "Validasi", JOptionPane.ERROR_MESSAGE); 
            return; 
        } 
        try { 
            String cekDB = "SELECT * FROM tbl_biodata WHERE nim = '" + 
            tfNim.getText() + "'   "; 
            rs = st.executeQuery(cekDB); 
            if (rs.next()) { 
                JOptionPane.showMessageDialog(null, "NIM sudah tersedia !"); 
            } else { 
                st = conn.createStatement(); 
                String jekel;
                if (rbLaki.isSelected()) { 
                    jekel = "Laki - Laki"; 
                } else { 
                    jekel = "Perempuan"; 
                } 
                //aksi simpan data (Submit/Save/Add)  
                String sql = "INSERT INTO tbl_biodata (nama, nim, ttl, jekel, prodi, notelp, alamat) VALUES ('"
                        + tfNama.getText()
                        + "', '" + tfNim.getText()
                        + "', '" + tfTTL.getText()
                        + "', '" + jekel
                        + "', '" + cmbProdi.getSelectedItem()
                        + "', '" + tfNomorTelp.getText()
                        + "', '" + taAlamat.getText()
                        + "')";
                
                st.executeUpdate(sql); 
                JOptionPane.showMessageDialog(null, "Data berhasil di simpan"); 
                tampilData(); 
                clearForm(); 
            } 
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(this, e.getMessage()); 
        } 
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (tfNama.getText().equals("") 
            || tfNim.getText().equals("") 
            || tfTTL.getText().equals("") 
            || tfNomorTelp.getText().equals("") 
            || taAlamat.getText().equals("") 
            || buttonGroup1.isSelected(null) 
            || cmbProdi.getSelectedItem().equals("-- Program Studi --")) { 
           JOptionPane.showMessageDialog(this, "Field harap di isi!", "Validasi", JOptionPane.ERROR_MESSAGE); 
            return; 
        } 
        try { 
            String jekel;
            if (rbLaki.isSelected()) { 
                jekel = "Laki - Laki"; 
            } else { 
                jekel = "Perempuan"; 
            } 
            // Query untuk update data
            String sql = "UPDATE tbl_biodata SET "
                    + "nama = '" + tfNama.getText() + "', "
                    + "ttl = '" + tfTTL.getText() + "', "
                    + "jekel = '" + jekel + "', "
                    + "prodi = '" + cmbProdi.getSelectedItem() + "', "
                    + "notelp = '" + tfNomorTelp.getText() + "', "
                    + "alamat = '" + taAlamat.getText() + "' "
                    + "WHERE nim = '" + tfNim.getText() + "'";

            st.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate"); 
            tampilData(); 
            clearForm(); 
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(this, e.getMessage()); 
        } 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (tfNim.getText().equals("")) { 
            JOptionPane.showMessageDialog(this, "NIM tidak boleh kosong!", "Validasi", JOptionPane.ERROR_MESSAGE); 
            return; 
        }
        int jawab = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (jawab == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM tbl_biodata WHERE nim = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, tfNim.getText());

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                    tampilData();
                    clearForm();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data. \n" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        tfNama.setText(""); 
        tfNim.setText(""); 
        tfTTL.setText(""); 
        buttonGroup1.clearSelection(); 
        cmbProdi.setSelectedItem("-- Program Studi --"); 
        tfNomorTelp.setText(""); 
        taAlamat.setText(""); 
        tfNama.requestFocus(); 
    }//GEN-LAST:event_btnClearActionPerformed

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

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
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBiodata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbProdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTable tblBiodata;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNim;
    private javax.swing.JTextField tfNomorTelp;
    private javax.swing.JTextField tfTTL;
    // End of variables declaration//GEN-END:variables
}
