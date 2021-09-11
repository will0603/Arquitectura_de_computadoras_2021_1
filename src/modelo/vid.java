/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class vid {
   String tipoDeUva;
   private byte[] foto;
   
   public vid(){}

    public String getTipoDeUva() {
        return tipoDeUva;
    }

    public void setTipoDeUva(String tipoDeUva) {
        this.tipoDeUva = tipoDeUva;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
   
   public void insertar(String uva, byte[] foto){
       Conexion conectar = new Conexion();
       String SQL = "{call insert_vid(?,?)}";
       CallableStatement stmt = null;
        
       try(Connection conn = conectar.conectarMySQL()){
            stmt = conn.prepareCall(SQL);
            stmt.setString(1,uva);
            stmt.setBytes(2, foto);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Operación exitosa");
        } catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ocurrió un problema con la Base de Datos");
        }
   
   }
}
