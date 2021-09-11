/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class Image extends javax.swing.JFrame {
    public static final int anchoPermitido=1300;
    public static final int altoPermitido=1300;
    private Color arreglo[][];
    private int ancho;
    private int alto;
    int x, y;
    
    public Image(String archivo) {
        arreglo = new Color[anchoPermitido][anchoPermitido];
        cargarImagen(archivo);
    }
    public void cargarImagen(String archivo){
        BufferedImage bf=null;
        try {
            bf = ImageIO.read(new File(archivo));
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bf.getWidth()<anchoPermitido) {
            ancho=bf.getWidth();
        }else
            ancho=anchoPermitido;
        if (bf.getHeight()<altoPermitido) {
            alto=bf.getHeight();
        }else
            alto=altoPermitido;
        int cont=0;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                cont++;
                arreglo[i][j]= new Color(bf.getRGB(j, i));
                //System.out.println(cont +":"+"RedGreenBlue:"+ bf.getRGB(j, i));
            }
        }
    }
    public BufferedImage redimensionar(String archivo, double porcentaje ){
        
        BufferedImage bf = null;
        try {
            bf = ImageIO.read(new File(archivo));
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ancho = bf.getWidth();
        int alto = bf.getHeight();
        int escalaAncho = (int)(porcentaje* ancho);
        int escalaAlto = (int)(porcentaje*alto);
        BufferedImage bufim = new BufferedImage(escalaAncho, escalaAlto, bf.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bf, 0,0, escalaAncho,escalaAlto, 0,0,ancho,alto, null);
        g.dispose();
        return bufim;
}
    public void binarizarImagen(double umbral ){
        
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                Color pix= arreglo[i][j];
                int promedio =(pix.getBlue()+pix.getRed()+pix.getGreen())/3;
                 
                if (promedio<umbral) 
                    arreglo[i][j]=Color.BLACK;
                else
                    arreglo[i][j] = Color.WHITE;
                
                //System.out.println("posicion [" + i + "][" + j +"]");
                
                //System.out.println(arreglo[i][j]);
                
            }
            System.out.println("\n ");
            
        }
    }
    public BufferedImage imprimirImagen(){
        BufferedImage salida = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                salida.setRGB(j, i, arreglo[i][j].getRGB());
            }
        }
        return salida;
    }
/*
    public Imagen(JPanel jPanel1) {
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/entrada3.png"));
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
    }*/
}
