/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Accesorio;
import modelo.Conexion;
import ordendetrabajo.conectar;
import vista.frmAñadirProducto;

/**
 *
 * @author LENOVO
 */
public class ControladorAñadirProducto {
    private frmAñadirProducto vista;
    
    public ControladorAñadirProducto(frmAñadirProducto vista){
    this.vista = vista;
    
    vista.btnGuardar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if(validar()){
                Accesorio producto = new Accesorio(vista.txtCodigo.getText(), vista.txtNombre.getText(), Integer.parseInt(vista.txtCantidad.getText()), 
                                                vista.txtDescripcion.getText(), Float.parseFloat(vista.txtPrecio.getText()));
                producto.insert2();
                
                JOptionPane.showMessageDialog(null, "Operación exitosa");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(vista, "Llene todos los campos");
            }
        }
    });
    
    vista.btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            vista.dispose();
        }
    });
    
    vista.btnMostrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String[] cabecera = new String[5];
            cabecera[0] = "Código";
            cabecera[1] = "Nombre";
            cabecera[2] = "Descripción";
            cabecera[3] = "Cantidad";
            cabecera[4] = "Precio";
            String[][] datos = null;
            try {
                datos = getDatosProducto(datos);
                DefaultTableModel modelo= new DefaultTableModel(datos, cabecera);
                vista.tblProductos.setModel(modelo);
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAñadirProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
    });
    
    
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public boolean validar(){
        boolean result = false;
        
        if(this.vista.txtCodigo.getText().length() !=0 &&
            this.vista.txtNombre.getText().length() !=0 &&
            this.vista.txtCantidad.getText().length() !=0 &&
            this.vista.txtDescripcion.getText().length() !=0 &&
            this.vista.txtPrecio.getText().length() !=0 ){
        
                result = true;
                return result;
        }else{
            return result;
        }
    }
    
    public void limpiar(){
        vista.txtCantidad.setText("");
        vista.txtCodigo.setText("");
        vista.txtDescripcion.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
    }
    /*
    public void mostrar() throws SQLException{
        Conexion conectar = new Conexion();
        String SQL = "{call get_producto}";
        CallableStatement stmt = null;
        String[] cabecera = new String[5];
        cabecera[0] = "Código";
        cabecera[1] = "Nombre";
        cabecera[2] = "Descripción";
        cabecera[3] = "Cantidad";
        cabecera[4] = "Precio";
        //datos[4] = "Código";
    
    }*/
    
    public String[][] getDatosProducto(String[][] datos) throws SQLException{
        Conexion con = new Conexion();
        String SQL = "{call get_producto}";   
        
        CallableStatement stmt = null;
        //String[][] datos = null;
        try(Connection conn = con.conectarMySQL() ){
           
            stmt = conn.prepareCall(SQL);
            
            ResultSet rs = stmt.executeQuery();
            rs.last();
            datos= new String[rs.getRow()][5];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                datos[i][0]= rs.getString("codigo");
                Accesorio producto = new Accesorio(datos[i][0]);
                System.out.println(producto.consultar());
                datos[i][1]= producto.getNombre();               
                datos[i][2]= String.valueOf(producto.getDescripcion());
                datos[i][3]= rs.getString("cantidad");
                datos[i][4]= String.valueOf(producto.getPrecio());
                i++;
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return datos;
    
    }
}
