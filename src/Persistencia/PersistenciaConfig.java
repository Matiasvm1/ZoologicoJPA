
package Persistencia;

import Model.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaConfig {
CarnivoroJpaController controlCarn = new CarnivoroJpaController();
EmpleadoJpaController controlEmp = new EmpleadoJpaController();
EspecieJpaController controlEsp = new EspecieJpaController();
HerbivoroJpaController controlHerb = new HerbivoroJpaController();
MamiferoJpaController controlMam = new MamiferoJpaController();
PaisJpaController controlPais = new PaisJpaController();
SectorJpaController controlSec = new SectorJpaController();

    public PersistenciaConfig() {
    }
    
    //-----------------Empleados------------------------------------------
    public void createEmpleado(Empleado empleado) throws Exception{
        this.controlEmp.create(empleado);
    }
      public ArrayList<Empleado> findEmpleadosEntities(){
       List<Empleado> listita = controlEmp.findEmpleadoEntities();
       ArrayList<Empleado> listaEmpleados = new ArrayList<>(listita);
       return listaEmpleados; 
    }
      public Empleado findEmpleadosEntities(int dniEmpResp) {
          return controlEmp.findEmpleado(dniEmpResp);
      }
    //--------------------------------------------------------------------------  
    //------------------------Pais------------------------------------------
    public void createPais(Pais pais) throws Exception {
       this.controlPais.create(pais);
    }
       public ArrayList<Pais> findPaisEntities(){
       List<Pais> listita = controlPais.findPaisEntities();
       ArrayList<Pais> listaPaises= new ArrayList<>(listita);
       return listaPaises; 
    }
    //--------------------------------------------------------------------------  
    //------------------------Especie------------------------------------------

    public void createEspecie(Especie especie) {
       this.controlEsp.create(especie);
    }
       public ArrayList<Especie> findEspecieEntities(){
       List<Especie> listita = controlEsp.findEspecieEntities();
       ArrayList<Especie> listaEspecie= new ArrayList<>(listita);
       return listaEspecie; 
    }
    //--------------------------------------------------------------------------  
    //------------------------Sector------------------------------------------
    public void createSector(Sector sector){
        this.controlSec.create(sector);
    }
       public ArrayList<Sector> findSectorEntities(){
       List<Sector> listita = controlSec.findSectorEntities();
       ArrayList<Sector> listaSector= new ArrayList<>(listita);
       return listaSector; 
    }
    //------------------------Carnivoro------------------------------------------

    public void createCarnivoro(Carnivoro carnivoro) {
        controlCarn.create(carnivoro);
    }

    public void createHerbivoro(Herbivoro herbivoro) {
        controlHerb.create(herbivoro);
    }

  
    
    
  
}