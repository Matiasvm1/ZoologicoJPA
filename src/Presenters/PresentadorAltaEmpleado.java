
package Presenters;

import Model.Empleado;
import Persistencia.PersistenciaConfig;
import View.ViewAltaEmpleado;
import javax.swing.JOptionPane;



public class PresentadorAltaEmpleado {
    private ViewAltaEmpleado vistaEmpleado;
    private PersistenciaConfig controlPersis = new PersistenciaConfig();
    
    
    
   

    public void setVistaEmpleado(ViewAltaEmpleado vistaEmpleado) {
        this.vistaEmpleado = vistaEmpleado;
    }

    public void createEmpleado(String dni, String nombre, String direccion) throws Exception {
        int dniAux = Integer.parseInt(dni);
        Empleado empleado = new Empleado(dniAux,nombre,direccion);
       
       controlPersis.createEmpleado(empleado);
      
       JOptionPane.showMessageDialog(vistaEmpleado, "Empleado creado correctamente", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        
   
     
        
    }
    
    
    

