/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.form.usuario;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sv.edu.udb.connection.Email;
import sv.edu.udb.entidades.Encriptar;
import sv.edu.udb.entidades.TipoUsuario;
import sv.edu.udb.entidades.Usuario;
import sv.edu.udb.modelos.TipoUsuario_Model;
import sv.edu.udb.modelos.Usuario_Model;
import sv.edu.udb.pollock.Pollock;
import sv.edu.udb.validacion.Validacion;
/**
 *
 * @author Leonardo
 */
public class AgregarUsuario extends javax.swing.JInternalFrame {
    private List<TipoUsuario> tipos = new ArrayList<TipoUsuario>();
    /**
     * Creates new form AgregarUsuario
     */
    public AgregarUsuario() {
        initComponents();
        cargarTipoUsuario();
        
        String savePath = System.getProperty("user.dir") + "^web^images";
        savePath = String.join(System.getProperty("file.separator"), savePath.split("\\^"));

        ImageIcon i = null;
        URL url = null;
        try {
            url = new URL("file:///" + savePath + System.getProperty("file.separator") + "logo.png");
            i = new ImageIcon(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Pollock.class.getName()).log(Level.SEVERE, null, ex);
        }

        setFrameIcon(i);
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
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JFormattedTextField();
        btnRegistrar = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("[Pollock] - Agregar Usuario");

        lblNombre.setText("Nombres");

        lblApellido.setText("Apellidos");

        lblCorreo.setText("Correo Electrónico");

        jLabel4.setText("Fecha Nacimiento");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblTipo.setText("Tipo de Usuario");

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Agregar Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCorreo)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblApellido)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNombre)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblTipo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRegistrar)
                                .addGap(92, 92, 92)))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(128, 128, 128))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnRegistrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Registrar usuario
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if(validarCampos()){
                String tipo = "";
                for(TipoUsuario t : tipos){
                    if(t.getNombre().equals(cmbTipoUsuario.getSelectedItem().toString())){
                        tipo = String.valueOf(t.getId());
                        break;
                    }
                }
                
                int numUsuario = Usuario_Model.obtenerNumUsuario(tipo);
                String password = Encriptar.encriptar(Usuario.crearContransenna());
                String nombre = txtNombre.getText(), 
                    apellido = txtApellido.getText(),
                    correo = txtCorreo.getText(),
                    tipoUsuario = cmbTipoUsuario.getSelectedItem().toString();
                String idUsuario = Usuario.crearIdUsuario(nombre, apellido, numUsuario);
                
                DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");  
                Date fechaNacimiento = ft.parse(txtFechaNacimiento.getText());
                //Este es el de Leo :v
                if(compararFecha(fechaNacimiento)){//Comparamos que la fehca ingresada no sea mayor a la actual
                    if(Usuario_Model.verificarCorreo(correo)){
                        if(Usuario_Model.insertar(new Usuario(idUsuario, nombre, apellido, correo, fechaNacimiento, password, true, tipo))){
                            if(enviarCorreo(correo, Encriptar.desencriptar(password))){
                                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.\n ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE); 
                                limpiarComponentes(); //Se reinician campos
                            }else{
                                JOptionPane.showMessageDialog(null, "ha ocurrido un error", "Registro de Usuario", JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Registro de Usuario", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El correo ingresado ya existe!", "Registro de Usuario", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    
    public void limpiarComponentes(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNacimiento.setText("");
        txtCorreo.setText("");
        cargarTipoUsuario();
    }
    
    //Carga los tipos de usuario en el cmb
    public void cargarTipoUsuario(){
        cmbTipoUsuario.removeAllItems(); //Remover Items
        tipos = TipoUsuario_Model.obtenerTiposUsuarios();
        for(TipoUsuario t : tipos){
            cmbTipoUsuario.addItem(t.getNombre());
        }
    }
    
    private boolean validarCampos(){
        if(Validacion.validar("^[\\p{L} .'-]+$", txtNombre.getText(), "Ingresar un nombre válido!", "Agregar Usuario")
           && Validacion.validar("^[\\p{L} .'-]+", txtApellido.getText(), "Ingresar un apellido válido!", "Agregar Usuario")
           && Validacion.validar("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", txtCorreo.getText(), "Correo Electrónico no válido", "Registro Usuario")
           && Validacion.validar("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$", txtFechaNacimiento.getText(), "Fecha Inválida (yyyy-MM-dd)", "Agregar Usuario")){
            return true;
        }
        return false;
    }
    
    private boolean compararFecha(Date fecha){
        Date fechaActual = new Date();
        if(fecha.compareTo(fechaActual) < 0){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Ingresar una fecha válida", "Registro de Usuario", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    private boolean enviarCorreo(String correo, String contrasenna) {
        String mensaje = "<h5>Contraseña: </h5>" + contrasenna;
        Email email = new Email(correo);
        return email.enviar(mensaje, "[Pollock] - Registro de Usuario");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
