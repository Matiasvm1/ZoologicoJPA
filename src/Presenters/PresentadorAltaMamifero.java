
package Presenters;

import Model.Carnivoro;
import Model.Especie;
import Model.Herbivoro;
import Model.Pais;
import Model.Sector;
import Persistencia.PersistenciaConfig;
import View.ViewAltaMamifero;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class PresentadorAltaMamifero {
    private ViewAltaMamifero vistaAlta;
    private PersistenciaConfig controlPersis = new PersistenciaConfig();

    public void setVistaAlta(ViewAltaMamifero vistaAlta) {
        this.vistaAlta = vistaAlta;
    }

    
    
    
    public void setCmbEspecies() {
        ArrayList<Especie> listaEspecies = controlPersis.findEspecieEntities();
        for (Especie especie : listaEspecies) {
            vistaAlta.getCmbEspecie().addItem(especie);
        }
    }

    public void setCmbPaises() {
        ArrayList<Pais> listaPaises = controlPersis.findPaisEntities();
        for (Pais pais : listaPaises) {
            vistaAlta.getCmbPais().addItem(pais);
        }
    }


    public void createMamifero() {
       
    }

    public void createMamifero(Object especie, String edad, Object pais, String peso, Object sector, String valorHerbivoro) throws Exception{
        Especie especieAux = (Especie) especie;
        Pais paisAux = (Pais) pais;
        Sector sectorAux = (Sector) sector;
        int edadAux = Integer.parseInt(edad);
        double pesoAux = Double.parseDouble(peso);
        
        if(especieAux.getDieta().esCarnivoro()){
            Carnivoro carnivoro = new Carnivoro(edadAux, pesoAux, paisAux, especieAux, sectorAux);
            controlPersis.createCarnivoro(carnivoro);
        }else{
            double valorHerbivoroAux = Double.parseDouble(valorHerbivoro);
            Herbivoro herbivoro = new Herbivoro(valorHerbivoroAux, edadAux, pesoAux, paisAux, especieAux, sectorAux);
            controlPersis.createHerbivoro(herbivoro);
        }
                 JOptionPane.showMessageDialog( vistaAlta, "Mamifero creado correctamente", "Confirmacion Mamifero", JOptionPane.INFORMATION_MESSAGE);

        
    }

    public void limitarEspecie(Object especieSelec) {
        ArrayList<Sector> sectores = controlPersis.findSectorEntities();
        Especie especie = (Especie) especieSelec;
        if(especie.getDieta().esCarnivoro()){
           vistaAlta.getCmbSectores().removeAllItems();
           vistaAlta.getTxtValorHerbivoro().setEnabled(false);
            for (Sector sector : sectores) {
                if(sector.getTipo().esCarnivoro()){
                    vistaAlta.getCmbSectores().addItem(sector);
                }
            }
        }else{
            vistaAlta.getCmbSectores().removeAllItems();
            vistaAlta.getTxtValorHerbivoro().setEnabled(true);
            for (Sector sector : sectores) {
                if(sector.getTipo().esHerbivoro()){
                    vistaAlta.getCmbSectores().addItem(sector);
                }
        }
    }
    
    }
}