
package Presenters;

import Model.Dieta;
import Model.Especie;
import Persistencia.PersistenciaConfig;
import View.ViewAltaEspecie;
import javax.swing.JOptionPane;

public class PresentadorAltaEspecie {
    ViewAltaEspecie vistaEspecie;
    PersistenciaConfig controlPersis = new PersistenciaConfig();
    
    public void setVistaEspecie(ViewAltaEspecie vista){
        vistaEspecie = vista;
    }

    
    public void createEspecie(String nombre,String valorCarnivoro,String dieta) {
        Especie especie;
        double valorCarnivoroAux = Double.parseDouble(valorCarnivoro);
        if(Dieta.esCarnivoro(dieta)){
            especie = new Especie(nombre,valorCarnivoroAux,Dieta.CARNIVORO);
        }else{
            especie = new Especie(nombre,valorCarnivoroAux,Dieta.HERBIVORO);
        }
        
        controlPersis.createEspecie(especie);
        JOptionPane.showMessageDialog(vistaEspecie, "Especie creada correctamente", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        
    }
    
    
}
