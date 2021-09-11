package DAO;

import modelo.Conexion;
import VO.ProductoVO;
import java.sql.*;
import java.util.ArrayList;
import modelo.Accesorio;


/*Metodo listar*/
public class ProductoDAO{

    public ArrayList<ProductoVO> Listar_ProductoVO(){
        ArrayList<ProductoVO> list = new ArrayList<ProductoVO>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM vid;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoVO vo = new ProductoVO();
                vo.setIdproducto(rs.getInt(1));
                vo.setTipoDeUva(rs.getString(2));
                //vo.setPrecio(rs.getDouble(3));
                //vo.setMarca(rs.getString(4));
                
                vo.setFoto(rs.getBytes(3));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }
    
    public ArrayList<ProductoVO> listar(String tipo){
        ArrayList<ProductoVO> list = new ArrayList<ProductoVO>();
        Conexion con = new Conexion();
        String SQL = "{call get_vid(?)}";   
        
        CallableStatement stmt = null;
        //String[][] datos = null;
        try(Connection conn = con.conectarMySQL() ){
           
            stmt = conn.prepareCall(SQL);
            stmt.setString(1, tipo);
            
            ResultSet rs = stmt.executeQuery();
            //rs.last();
            while(rs.next()){
                ProductoVO vo = new ProductoVO();
                vo.setIdproducto(rs.getInt("id"));
                vo.setTipoDeUva(rs.getString("tipoDeUva"));
                //vo.setPrecio(rs.getDouble(3));
                //vo.setMarca(rs.getString(4));
                
                vo.setFoto(rs.getBytes("foto"));
                vo.setFecha(String.valueOf(rs.getDate("fecha")));
                list.add(vo);
            }/*
            datos= new String[rs.getRow()][4];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                datos[i][0]= String.valueOf(rs.getString("id"));
                //Accesorio producto = new Accesorio(datos[i][0]);
                //System.out.println(producto.consultar());
                datos[i][1]= rs.getString("tipoDeUva");
                datos[i][2]= String.valueOf(producto.getDescripcion());
                datos[i][3]= String.valueOf(rs.getDate("fecha"));
                //datos[i][4]= String.valueOf(producto.getPrecio());
                i++;
            }*/
        }catch(Exception e){
            System.out.println(e);
        }

        return list;
        
    }

/*
/*Metodo agregar*//*
    public void Agregar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "INSERT INTO producto (idProducto, nombre, precio, marca, foto)\n" +
"VALUES (NULL,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getMarca());
            ps.setBytes(4, vo.getFoto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
*/

/*Metodo Modificar*//*
    public void Modificar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE producto SET nombre = ?, precio = ?, marca = ?, foto = ?\n" +
"WHERE idProducto = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getMarca());
            ps.setBytes(4, vo.getFoto());
            ps.setInt(5, vo.getIdproducto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }*/
/*
    public void Modificar_ProductoVO2(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE producto SET nombre = ?, precio = ?, marca = ? \n" +
"WHERE idProducto = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getMarca());
            ps.setInt(4, vo.getIdproducto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
*/
/*Metodo Eliminar*//*
    public void Eliminar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM producto WHERE idProducto = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getIdproducto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
*/

}
