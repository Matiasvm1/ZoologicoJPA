
package Presenters;

import Model.Dieta;
import Model.Empleado;
import Model.Sector;
import Persistencia.PersistenciaConfig;
import View.ViewAltaSector;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PresentadorAltaSector {
    private ViewAltaSector vistaSector;
    PersistenciaConfig controlPersis = new PersistenciaConfig();

    public void setVistaSector(ViewAltaSector vistaSector) {
        this.vistaSector = vistaSector;
    }

    public PresentadorAltaSector() {
    }

    public void setCmbEmpleado() {
        ArrayList<Empleado> empleados = controlPersis.findEmpleadosEntities();
        for (Empleado empleado : empleados) {
            vistaSector.getCmbEmpleado().addItem(empleado.getDni());         
        }  
    }

    public void createSector(String latitud, String longitud, String limite, String dieta, String dniEmpResp) {
     double latitudAux = Double.parseDouble(latitud);
     double longitudAux = Double.parseDouble(longitud);
     int limiteAux = Integer.parseInt(limite);
     Empleado empleado = controlPersis.findEmpleadosEntities(Integer.parseInt(dniEmpResp));
     Sector sector; 
     if(Dieta.esCarnivoro(dieta)){
         sector = new Sector(latitudAux,longitudAux,limiteAux,Dieta.CARNIVORO,empleado);
     }else{
         sector = new Sector(latitudAux,longitudAux,limiteAux,Dieta.HERBIVORO,empleado);
     }
        controlPersis.createSector(sector);
        JOptionPane.showMessageDialog(vistaSector, "Sector creado correctamente", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

    }
    
    
}
