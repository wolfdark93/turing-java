package vistas;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.cinta;
import modelo.maquina;
import modelo.transicion;
public class abrirArchivo extends javax.swing.JFrame {
    
    //listActividades datos=new listActividades();
    maquina DefMaquina = new maquina();
    ArrayList<cinta> casos;
    public abrirArchivo() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        direccion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        abrir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Abrir archivo");
        setResizable(false);

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ruta archivo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton3)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(direccion)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(abrir)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser file= new JFileChooser();
        int opcion= file.showOpenDialog(this);
        if(opcion==JFileChooser.APPROVE_OPTION){
            direccion.setText(file.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        int cantCasos;
        int iniEstado, finalEstado;
        char entrada, salida, accion;
        transicion funcion;
        try{
            FileReader Vfile=new FileReader(direccion.getText());
            BufferedReader Bufer=new BufferedReader(Vfile);
            String lineas= new String();
            
            lineas=Bufer.readLine(); //lee primera linea
            DefMaquina.agregaNM(lineas);
            lineas=Bufer.readLine(); //leer 2da linea con alfabeto
            DefMaquina.agregaAlfabeto(lineas);
            
            //leer funciones de trasicion
            for (int i = 0; i < (DefMaquina.getM()*DefMaquina.getN()); i++) {
                lineas=Bufer.readLine();
                DefMaquina.agregarFuncion(lineas);
            }
            
            lineas=Bufer.readLine(); //lee linea con cantidad de casos
            cantCasos = Integer.parseInt("" + lineas.charAt(0));
            DefMaquina.setCantcasos(cantCasos);
            for (int i = 0; i < cantCasos; i++) { //leer todos los casos o cintas
                lineas=Bufer.readLine();
                DefMaquina.agregarCaso(lineas);
            }
            dispose();
            new inicio(DefMaquina).setVisible(true);
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ruta o Archivo no valida");
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        new inicio().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
