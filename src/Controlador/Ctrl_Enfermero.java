
package Controlador;

import Modelo.Enfermero;
import Vista.frmEnfermero;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Ctrl_Enfermero implements MouseListener {
    
    private Enfermero modelo;
    private frmEnfermero vista;
    
     public Ctrl_Enfermero(Enfermero modelo, frmEnfermero vista){
        this.modelo = modelo;
        this.vista = vista;

        vista.btn_Agregar.addMouseListener(this);   
        vista.btn_Eliminar.addMouseListener(this);
        vista.btn_Actualizar.addMouseListener(this);
        vista.btn_Limpiar.addMouseListener(this);
        vista.jtbEnfermero.addMouseListener(this);
        modelo.Mostrar(vista.jtbEnfermero);

    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
         if(e.getSource() == vista.btn_Agregar){
            modelo.setNombre(vista.txt_Nombre.getText());
            modelo.setEdad(Integer.parseInt(vista.txt_Edad.getText()));
            modelo.setPeso(Integer.parseInt(vista.txt_Peso.getText()));
            modelo.setCorreo(vista.txt_Correo.getText());

            
            modelo.Guardar();
            modelo.Mostrar(vista.jtbEnfermero);
        }
        
        if(e.getSource() == vista.btn_Eliminar){
            modelo.Eliminar(vista.jtbEnfermero);
            modelo.Mostrar(vista.jtbEnfermero);
        }
        
        if(e.getSource() == vista.jtbEnfermero){
            modelo.cargarDatosTabla(vista);
        }
        
        if(e.getSource() == vista.btn_Actualizar){
            modelo.setNombre(vista.txt_Nombre.getText());
            modelo.setEdad(Integer.parseInt(vista.txt_Edad.getText()));
            modelo.setPeso(Integer.parseInt(vista.txt_Peso.getText()));
            modelo.setCorreo(vista.txt_Correo.getText());

            
            modelo.Actualizar(vista.jtbEnfermero);
            modelo.Mostrar(vista.jtbEnfermero);
        }
        
        if(e.getSource() == vista.btn_Limpiar){
            modelo.limpiar(vista);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    
}
