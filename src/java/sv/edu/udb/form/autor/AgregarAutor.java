/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.form.autor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sv.edu.udb.entidades.Autor;
import sv.edu.udb.entidades.Pais;
import sv.edu.udb.modelos.Autor_Model;
import sv.edu.udb.modelos.Pais_Model;
import sv.edu.udb.validacion.Validacion;

/**
 *
 * @author jasso
 */
public class AgregarAutor extends javax.swing.JInternalFrame {

    private List<Pais> items = new ArrayList<Pais>();

    /**
     * Creates new form AgregarAutor
     */
    public AgregarAutor() {
        initComponents();
        cargarPais();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblFechaNac = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        jcbPais = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();
        txtFechaNac = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Gestión de Autores");
        setPreferredSize(new java.awt.Dimension(500, 500));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblApellido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblApellido.setText("Apellido:");

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        lblFechaNac.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblFechaNac.setText("Fecha de nacimiento:");

        lblPais.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblPais.setText("País: ");

        jcbPais.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnIngresar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnIngresar.setText("Agregar Autor");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        txtFechaNac.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Agregar Autor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellido)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellido))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFechaNac)
                                    .addComponent(lblPais))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaNac)
                                    .addComponent(jcbPais, 0, 183, Short.MAX_VALUE))))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(151, 151, 151))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNac)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPais)
                    .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnIngresar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        try {
            if (validarCampos()) {

                String PaisString = "";
                for (Pais P : items) {
                    if (P.getNombre().equals(jcbPais.getSelectedItem().toString())) {
                        PaisString = String.valueOf(P.getIdPais());
                        break;
                    }
                }

                String idAutor = Autor.crearNombreAutor(Autor_Model.obtenerNumAutor());
                String nombre = txtNombre.getText(),
                        apellido = txtApellido.getText(); //Proba
                DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaNac.getText());
                
                //new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaNac.getText())
                
                if (compararFecha(fechaNacimiento)) {//Comparamos que la fehca ingresada no sea mayor a la actual
                    if (Autor_Model.insertar(new Autor(idAutor, nombre, apellido, fechaNacimiento, PaisString))) {
                        JOptionPane.showMessageDialog(null, "Autor registrado correctamente", "Registro de Autor", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos(); //Se  inicializan los campos
                    } else {
                        JOptionPane.showMessageDialog(null, "ha ocurrido un error", "Registro de Autor", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(AgregarAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed
    
    public void limpiarCampos(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNac.setText("");
        cargarPais();
    }
    
    public void cargarPais() {
        jcbPais.removeAllItems();
        items = Pais_Model.obtenerPaises();
        for (Pais t : items) {
            jcbPais.addItem(t.getNombre());
        }
    }

    private boolean validarCampos() {
        if (Validacion.validar("^[\\p{L} .'-]+$", txtNombre.getText(), "Ingresar un nombre válido!", "Agregar Autor")
                && Validacion.validar("^[\\p{L} .'-]+", txtApellido.getText(), "Ingresar un apellido válido!", "Agregar Autor")
                && Validacion.validar("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$", txtFechaNac.getText(), "Fecha Inválida (yyyy-MM-dd)", "Agregar Autor")) {
            return true;
        }
        return false;
    }

    private boolean compararFecha(Date fecha) {
        Date fechaActual = new Date();
        if (fecha.compareTo(fechaActual) < 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar una fecha válida", "Registro de Usuario", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcbPais;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPais;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
