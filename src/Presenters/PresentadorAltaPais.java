
package Presenters;

import Model.*;
import Persistencia.*;
import View.*;
import javax.swing.JOptionPane;



public class PresentadorAltaPais {
    ViewAltaPais vistaAltaPais;
    PersistenciaConfig controlPersis = new PersistenciaConfig();

  
   
    public void setVistaAltaPais(ViewAltaPais vista){
        this.vistaAltaPais = vista;
    }
    
    public void createPais(String nombre, String codigoIso) throws Exception {
         int codigoIsoAux = Integer.parseInt(codigoIso);
         Pais pais = new Pais(nombre,codigoIsoAux);
        controlPersis.createPais(pais);
         
         JOptionPane.showMessageDialog( vistaAltaPais, "Pais creado correctamente", "Confirmacion Pais", JOptionPane.INFORMATION_MESSAGE);
         
    }
    

    
    
    
}
