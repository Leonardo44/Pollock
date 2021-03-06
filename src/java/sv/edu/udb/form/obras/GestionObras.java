/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.form.obras;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.entidades.Autor;
import sv.edu.udb.entidades.Obra;
import sv.edu.udb.modelos.Autor_Model;
import sv.edu.udb.modelos.Obra_Model;
import sv.edu.udb.pollock.Pollock;
import sv.edu.udb.validacion.Validacion;


/**
 *
 * @author Diego Lemus
 */
public class GestionObras extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = null;
    private List<Autor> autores = Autor_Model.obtenerAutores();
    private List<Obra> obras = Obra_Model.obtenerObras(true);
    private String idObraSeleccionada = "";
    private List<Autor> autorBusqueda = new ArrayList<Autor>();
    /**
     * Creates new form GestionObras
     */
    public GestionObras() {
        initComponents();
        inicializarComponentes();
        cargarObras();
        
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
    private void cargarAutores(){
        cmbAutores.removeAllItems(); //Remover Items
        autores = Obra_Model.obtenerAutores();
        for(Autor _a : autores){
            cmbAutores.addItem(_a.getNombres() + " " + _a.getApellidos());
        }
    }
    private static void saveImage(String imageUrl,String destinationFile) throws IOException{
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);
        byte[] b = new byte[2048];
        int length;
        while((length = is.read(b)) != -1){
            os.write(b,0,length);
        }
        is.close();
        os.close();
    }
    private static void mover(String archivoDestino){
        String savePath = System.getProperty("user.dir") + "^web^images^obras";
        savePath = String.join(System.getProperty("file.separator"), savePath.split("\\^"));
        Path origenPath =  Paths.get(System.getProperty("user.dir") + "\\" + archivoDestino);
        Path destinoPath = Paths.get(savePath +"\\"+ archivoDestino);
        try{
        Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException ex){
            Logger.getLogger(AgregarObra.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void cargarObras(){
        Object[][] datos = null;
        String[] columns = {"Nombre","Descripción","Imagen","Nombre del autor"};
        modelo = new DefaultTableModel(datos,columns);
        for(Obra _o: obras){
            Object[] nuevaLinea = {_o.getNombre(),_o.getDescripcion(),_o.getImagen(), _o.getAutor().getNombres() +" "+ _o.getAutor().getApellidos()};
            modelo.addRow(nuevaLinea);
        }
        jTblObras.setModel(modelo);
    }
    
    private void inicializarComponentes(){
        txtNombre.setText("");
        txtNombre.setEnabled(false);
        txtDescripcion.setText("");
        txtDescripcion.setEnabled(false);
        txtUrlImagen.setText("");
        txtUrlImagen.setEnabled(false);
        cmbAutores.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        autorBusqueda = Obra_Model.obtenerAutores();
        cargarAutores();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblObras = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblDescripcion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblUrlImagen = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtUrlImagen = new javax.swing.JTextField();
        cmbAutores = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        lblFiltro = new javax.swing.JLabel();
        cmbBuscador = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("[Pollock] - Gestión de Obras");

        jTblObras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTblObras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblObrasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblObras);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión de Obras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblDescripcion.setText("Descripción");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblNombre.setText("Nombre");
        lblNombre.setToolTipText("");

        lblUrlImagen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblUrlImagen.setText("Url Imagen");

        lblAutor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblAutor.setText("Autor");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txtUrlImagen.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        cmbAutores.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblAutor)
                        .addGap(53, 53, 53)
                        .addComponent(cmbAutores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblUrlImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(txtUrlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(lblNombre)
                    .addGap(29, 29, 29)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUrlImagen))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutor)
                    .addComponent(cmbAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre))
                    .addGap(24, 24, 24)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(144, Short.MAX_VALUE)))
        );

        jLabel1.setText("Patrón a buscar:");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        lblFiltro.setText("Filtro");

        cmbBuscador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Imagen", "Nombre autor" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltro)
                    .addComponent(cmbBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        if(cmbBuscador.getSelectedItem().toString().equals("Nombre")){
            obras = Obra_Model.BuscarObras("nombre", txtBusqueda.getText());
        }else if(cmbBuscador.getSelectedItem().toString().equals("Descripcion")){
            obras = Obra_Model.BuscarObras("descripcion", txtBusqueda.getText());
        }else if(cmbBuscador.getSelectedItem().toString().equals("Imagen")){
            obras = Obra_Model.BuscarObras("imagen", txtBusqueda.getText());
        }else if(cmbBuscador.getSelectedItem().toString().equals("Nombre autor")){
            String idAutor = "";
            for(Autor _a:autorBusqueda){
                CharSequence cs1 = _a.getNombres();
                if(txtBusqueda.getText().contains(cs1)){
                    idAutor = _a.getIdAutor();
                }
            }
            obras = Obra_Model.BuscarObras("idAutor", idAutor);
        }
        if(txtBusqueda.getText().length() == 1){
            obras = Obra_Model.obtenerObras();
        }
        cargarObras();
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void jTblObrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblObrasMouseClicked
        if(obras.size() > 0){
            int fila = jTblObras.rowAtPoint(evt.getPoint());
            if(fila > -1){
                idObraSeleccionada = obras.get(fila).getIdObra();
                txtNombre.setText(obras.get(fila).getNombre());
                txtDescripcion.setText(obras.get(fila).getDescripcion());
                txtUrlImagen.setText(obras.get(fila).getImagen());
                for(Autor _a: autores){
                    if(String.valueOf(_a.getIdAutor()).equals(obras.get(fila).getAutor().getIdAutor())){
                        cmbAutores.removeAllItems(); //Remover Items
                        cmbAutores.addItem(_a.getNombres() +" "+ _a.getApellidos());
                        cmbAutores.setEnabled(false);
                    }
                }
                desbloquearCampos();
            }
        }
    }//GEN-LAST:event_jTblObrasMouseClicked
    private void modificarObra(){
            try{
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                String idAutor = "";
                Autor objectAutor = null;
                String img = "";
                for(Autor _a: autores){
                   if((_a.getNombres() +" "+ _a.getApellidos()).equals(cmbAutores.getSelectedItem().toString())){
                       idAutor = String.valueOf(_a.getIdAutor());
                       objectAutor = _a;
                       break;
                   }
               }
               if(txtUrlImagen.getText().equals(idObraSeleccionada + ".jpg")){
               img = txtUrlImagen.getText();
                    if(Obra_Model.modificar(new Obra(idObraSeleccionada,nombre,descripcion,img,objectAutor))){
                        JOptionPane.showMessageDialog(null, "Obra modificada correctamente", "Gestión de Obras", JOptionPane.INFORMATION_MESSAGE);
                    }
               }else if(!(txtUrlImagen.getText().equals(idObraSeleccionada + ".jpg"))){
                   String urlImg = txtUrlImagen.getText();
                   String idObra = idObraSeleccionada;
                   String archivoDestino = idObra + ".jpg";
                   if(Obra_Model.modificar(new Obra(idObraSeleccionada,nombre,descripcion,archivoDestino,objectAutor))){
                        JOptionPane.showMessageDialog(null, "Obra modificada correctamente", "Gestión de Obras", JOptionPane.INFORMATION_MESSAGE);
                        saveImage(urlImg,archivoDestino);
                        mover(archivoDestino);
                   }
               }else{
                   JOptionPane.showMessageDialog(null,"Ocurrio un error con la URL, porfavor ingrese una URL de una IMG o el nombre del archivo original","Gestión de Obras",JOptionPane.ERROR_MESSAGE);
               }
            }catch(Exception ex){
                Logger.getLogger(GestionObras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(idObraSeleccionada.length() > 0){
            if(validarDatos() && verificarVacios()){
                modificarObra();
                inicializarComponentes();
                cargarObras();
                obras = Obra_Model.obtenerObras();
                txtBusqueda.setText("");
            }else{
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error al modificar la obra","Gestión de Obras",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed
    private void eliminarImg(File fichero){
        if (!fichero.exists()) {
        System.out.println("El archivo data no existe.");
    } else {
        fichero.delete();
        System.out.println("El archivo data fue eliminado.");
    }
    }
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(idObraSeleccionada.length() > 0){
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar esta obra?", "Gestión de Obras", JOptionPane.WARNING_MESSAGE);
            if(respuesta == JOptionPane.OK_OPTION){
                if(Obra_Model.eliminar(new Obra(idObraSeleccionada))){
                    String archivoDestino = idObraSeleccionada + ".jpg";
                    String savePath = System.getProperty("user.dir") + "^web^images^obras";
                    savePath = String.join(System.getProperty("file.separator"), savePath.split("\\^"));
                    Path destinoPath = Paths.get(savePath +"\\"+ archivoDestino);
                    String ruta = String.valueOf(destinoPath);
                    File fichero = new File(ruta);
                    eliminarImg(fichero);
                    inicializarComponentes();
                    cargarObras();
                    txtBusqueda.setText("");
                    obras = Obra_Model.obtenerObras();
                    JOptionPane.showMessageDialog(null, "Usuario elimnado correctamente", "Gestión de Usuario", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Error en el proceso de eliminación", "Gestión de Usuario", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona una obra", "Gestión de Obras", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void desbloquearCampos(){
        txtNombre.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtUrlImagen.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    private boolean verificarVacios(){
        if((txtNombre.getText().length() > 0) && !(txtNombre.getText().equals("")) && !(txtNombre.getText().isEmpty())){
           if((txtDescripcion.getText().length() > 0) && !(txtDescripcion.getText().equals("")) && !(txtDescripcion.getText().isEmpty())){
               if((txtUrlImagen.getText().length() > 0) && !(txtUrlImagen.getText().equals("")) && !(txtUrlImagen.getText().isEmpty())){
                   return true;
               }else{
                   return false;
               }
            }else{
               return false;
           }
        }else{
            return false;
        }
    }
    private boolean validarDatos() {
        if(Validacion.validar("^[A-Z][A-Za-z ñ.]+$",txtNombre.getText() , "Porfavor, revise el nombre de la obra", "Agregar Obras")
                && Validacion.validar("^[A-Za-z ñ,.)'0-9ñáéíóú:(-]+$",txtDescripcion.getText(),"Alguno caracteres no estan permitidos en la descripción","Agregar Obras")){
                if(Validacion.validar("^[A-Za-z .'/_:#?0-9-+]+$", txtUrlImagen.getText(), "Ingrese una URL correcta", "Agregar Obras") || Validacion.validar("^O[0-9][0-9][0-9][0-9].jpg+$", txtUrlImagen.getText(), "Ingrese un formato de imagen correcto", "Agregar Obras")){
                    return true;
                }else{
                 return false;
                }
        }else{
         return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbAutores;
    private javax.swing.JComboBox<String> cmbBuscador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblObras;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUrlImagen;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUrlImagen;
    // End of variables declaration//GEN-END:variables
}
