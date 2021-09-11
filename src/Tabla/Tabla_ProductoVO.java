package Tabla;

import DAO.ProductoDAO;
import VO.ProductoVO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Tabla_ProductoVO{

   ProductoDAO dao = null;


    public void visualizar_ProductoVO(JTable tabla){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dt.addColumn("N°");
        dt.addColumn("Tipo de uva");
        //dt.addColumn("precio");
        //dt.addColumn("marca");
        dt.addColumn("Foto");
        dt.addColumn("fecha");

        dao = new ProductoDAO();
        ProductoVO vo = new ProductoVO();
        ArrayList<ProductoVO> list = dao.listar("uva negra");

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getIdproducto();
                //fila[1] = vo.getNombre();
                fila[1] = vo.getTipoDeUva();
                //fila[3] = vo.getMarca();
                try{
                    byte[] bi = vo.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    fila[2] = new JLabel(imgi);

                }catch(Exception ex){
                    fila[2] = new JLabel("No imagen");
                }
                fila[3] = vo.getFecha();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
    }
}


