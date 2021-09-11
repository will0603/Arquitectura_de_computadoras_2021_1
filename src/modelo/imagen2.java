/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class imagen2 extends javax.swing.JPanel{
    int x, y;
    String ruta;

   
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    

    public imagen2(JPanel jPanel1, String ruta) {
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.ruta = ruta;
        this.setSize(x, y);
    }
    
     public String getRuta() {
        return ruta;
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon Img = new ImageIcon(getClass().getResource(this.ruta));
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
    }
}
