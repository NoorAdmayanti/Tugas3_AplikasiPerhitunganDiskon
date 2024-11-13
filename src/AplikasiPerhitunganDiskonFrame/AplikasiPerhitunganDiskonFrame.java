/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiPerhitunganDiskonFrame;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AplikasiPerhitunganDiskonFrame extends javax.swing.JFrame {
    private Map<String, Double> kodeKupon;
    private ArrayList<String> historyEntries;
    /**
     * Creates new form AplikasiPerhitunganDiskonFrame
     */
    public AplikasiPerhitunganDiskonFrame() {
          initComponents();
        initCustomComponents();
    }

    // Metode untuk menginisialisasi komponen kustom
    private void initCustomComponents() {
        // Inisialisasi kode kupon
        kodeKupon = new HashMap<>();
        kodeKupon.put("V10", 10.0);  // Diskon 10%
        kodeKupon.put("V20", 20.0);   // Diskon 20%
        kodeKupon.put("V30", 30.0);   // Diskon 30%

        // Inisialisasi list untuk riwayat
        historyEntries = new ArrayList<>();

        // Tambahkan event listener ke tombol hitung
        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hitungDiskon();
            }
        });

        // Tambahkan event listener untuk mengubah diskonSlider sesuai persentase diskon
        diskonSlider.addChangeListener(e -> {
            int diskonSliderValue = diskonSlider.getValue();
            jLabel3.setText(diskonSliderValue + "%");
        });
    }

    private double getDiskonKupon(String kode) {
        return kodeKupon.getOrDefault(kode.toUpperCase(), 0.0);
    }

    private void hitungDiskon() {
        try {
            double harga = Double.parseDouble(hargaAwal.getText());
            int diskonPersen = diskonSlider.getValue();

            // Langkah 1: Hitung harga setelah diskon awal
            double penghematanAwal = harga * (diskonPersen / 100.0);
            double hargaSetelahDiskon = harga - penghematanAwal;

            // Langkah 2: Terapkan diskon kupon jika ada
            double diskonKupon = getDiskonKupon(kuponKode.getText());
            double penghematanKupon = hargaSetelahDiskon * (diskonKupon / 100.0);
            double hargaAkhirValue = hargaSetelahDiskon - penghematanKupon;

            // Hitung total penghematan
            double totalPenghematan = penghematanAwal + penghematanKupon;

            // Tampilkan hasil
            hargaAkhir.setText(String.format("Harga Akhir: Rp%.2f", hargaAkhirValue));
            savingLabel.setText(String.format("Total Penghematan Rp%.2f", totalPenghematan));

            // Memperbarui riwayat
            String historyEntry = String.format("Harga Awal: Rp%.2f, Diskon Awal: %d%%, Kupon: %.1f%%, Akhir: Rp%.2f", 
                                    harga, diskonPersen, diskonKupon, hargaAkhirValue);

            historyEntries.add(historyEntry);
            updateHistory();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan harga yang valid.", "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateHistory() {
    historyArea.setText(""); // Mengosongkan JTextArea sebelum menambahkan riwayat baru
    for (String entry : historyEntries) {
        historyArea.append(entry + "\n");
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hargaAwal = new javax.swing.JTextField();
        diskonSlider = new javax.swing.JSlider();
        btnHitung = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        savingLabel = new javax.swing.JLabel();
        hargaAkhir = new javax.swing.JLabel();
        kuponKode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        historyArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Masukan Harga");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(hargaAwal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(diskonSlider, gridBagConstraints);

        btnHitung.setText("Hitung");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(btnHitung, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("APLIKASI MENGHITUNG DISKON");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 9;
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Masukan Diskon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Masukan Kode Kupon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel4, gridBagConstraints);

        savingLabel.setText("Penghematan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(savingLabel, gridBagConstraints);

        hargaAkhir.setText("Harga Akhir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(hargaAkhir, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(kuponKode, gridBagConstraints);

        historyArea.setColumns(20);
        historyArea.setRows(5);
        jScrollPane1.setViewportView(historyArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AplikasiPerhitunganDiskonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiPerhitunganDiskonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiPerhitunganDiskonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiPerhitunganDiskonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiPerhitunganDiskonFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JSlider diskonSlider;
    private javax.swing.JLabel hargaAkhir;
    private javax.swing.JTextField hargaAwal;
    private javax.swing.JTextArea historyArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kuponKode;
    private javax.swing.JLabel savingLabel;
    // End of variables declaration//GEN-END:variables
}