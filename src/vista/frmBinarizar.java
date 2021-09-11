/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.imagen2;
import modelo.vid;

/**
 *
 * @author LENOVO
 */
public class frmBinarizar extends javax.swing.JFrame {

    /**
     * Creates new form frmMenu
     */
    public frmBinarizar() {
        initComponents();
        //this.setLocationRelativeTo(null);
        
    }
    //String foto = "D:\\UNMSM\\ciclo 2021-1\\ARQUITECTURA DE COMPUTADORAS\\proyecto\\deteccionDeMadures\\BinarizaciondeImagen\\src\\imagenSalida\\salida5.jpg";
    //String foto = "D:\\UNMSM\\ciclo 2021-1\\ARQUITECTURA DE COMPUTADORAS\\proyecto\\deteccionDeMadures\\BinarizaciondeImagen\\src\\imagenes\\salida5.jpg";
    String foto = "D:\\UNMSM\\ciclo 2021-1\\ARQUITECTURA DE COMPUTADORAS\\project\\projectArquitectura_Grupo11\\src\\salida\\";        
    String foto2 = "D:\\UNMSM\\ciclo 2021-1\\ARQUITECTURA DE COMPUTADORAS\\project\\projectArquitectura_Grupo11\\src\\imagenes\\";
    //String ruta2 = txtRuta.getText();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtRuta = new javax.swing.JTextField();
        btnAbrir = new javax.swing.JButton();
        jCTipodeUva = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        JPimagen = new javax.swing.JPanel();
        btnMostrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DETECCIÓN Y COSECHA DE UVAS NEGRAS");

        jPanel2.setBackground(new java.awt.Color(102, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtRuta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAbrir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jCTipodeUva.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCTipodeUva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "uva negra", "uva verde" }));
        jCTipodeUva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTipodeUvaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCTipodeUva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTipodeUva, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setBackground(new java.awt.Color(51, 153, 0));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ordendetrabajo/exit.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        JPimagen.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout JPimagenLayout = new javax.swing.GroupLayout(JPimagen);
        JPimagen.setLayout(JPimagenLayout);
        JPimagenLayout.setHorizontalGroup(
            JPimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JPimagenLayout.setVerticalGroup(
            JPimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        btnMostrar.setText("mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ordendetrabajo/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JPimagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(this);
                File archivo = jf.getSelectedFile();
                
                if(archivo != null){
                    txtRuta.setText(archivo.getAbsolutePath());
                }
                
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        // TODO add your handling code here:
        if(txtRuta.getText().length() != 0){
        String ruta = txtRuta.getText();
        
        String[] datos = ruta.split("imagenes");
        System.out.println(Arrays.toString(datos));
        
        String opc = "/imagenes";
        //datos[1].substring(1);
        String opc2 = datos[1].substring(1);
        String[] datos2 = opc2.split("entrada");
        System.out.println(Arrays.toString(datos2));
        
        foto = foto+"salida"+datos2[1];
        
        opc = opc + "/"+datos[1].substring(1);
        
        foto2 = foto2 + datos[1].substring(1);
        System.out.println(opc);
        
        
        
        txtRuta.setText("/salida/salida"+datos2[1]);
        
        try{
        Image obj = new Image(foto2);
        obj.binarizarImagen(100);
        BufferedImage img = obj.imprimirImagen();
        ImageIO.write(img, "jpg", new File(foto));
        } catch(Exception e){
            System.out.println("La fruta esta inmadura");
        }
        
        imagen2 im = new imagen2(JPimagen, opc);
        JPimagen.add(im).repaint();
        
        } else{
            JOptionPane.showMessageDialog(null, "La ruta del archivo se encuentra vacia.");
        }
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
       
        //String opc = "/salida/salida5.jpg";

        //System.out.println(opc);
        
        //this.txtRuta.setText(opc);
        if(txtRuta.getText().length() != 0){
            System.out.println(txtRuta.getText());
            imagen2 im = new imagen2(JPimagen, txtRuta.getText());
            JPimagen.add(im).repaint();
        //opc = "";
        } else{
            JOptionPane.showMessageDialog(null, "No existe imagen para mostrar.");
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(txtRuta.getText().length() != 0){
        String opc = txtRuta.getText();
        String[] datos = opc.split("salida");
        System.out.println(Arrays.toString(datos));
        //opc = foto +"salida"+datos[2];
        opc = foto;
        System.out.println(opc);
        
        File ruta = new File(foto);
        vid imagenUva = new vid();
        //imagenUva.setTipoDeUva((String) jCTipodeUva.getSelectedItem());
        try{
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            //imagenUva.setFoto(icono);
            imagenUva.insertar((String) jCTipodeUva.getSelectedItem(), icono);
        }catch(Exception ex){
            imagenUva.setFoto(null);
        }
        
        dispose();
        } else{
            JOptionPane.showMessageDialog(null, "No existe imagen para almacenar.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jCTipodeUvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipodeUvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTipodeUvaActionPerformed
    
    public void guardar(String ruta){
        
    
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
            java.util.logging.Logger.getLogger(frmBinarizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBinarizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBinarizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBinarizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmBinarizar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(frmBinarizar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(frmBinarizar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(frmBinarizar.class.getName()).log(Level.SEVERE, null, ex);
                }
                new frmBinarizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel JPimagen;
    public javax.swing.JButton btnAbrir;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMostrar;
    public javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> jCTipodeUva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
