/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmBinarizar;
import vista.frmMenuPrincipal;

/**
 *
 * @author LENOVO
 */
public class ControladorMenuPrincipal {
    private frmMenuPrincipal vista;
    
    public ControladorMenuPrincipal(frmMenuPrincipal vista){
        this.vista = vista;
        
        vista.menuCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               vista.dispose();
            }
        });
        
        vista.menuBinarizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                frmBinarizar bin = new frmBinarizar();
                bin.setLocationRelativeTo(null);
                bin.setVisible(true);
            }
        });
    
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);    
    }
}
