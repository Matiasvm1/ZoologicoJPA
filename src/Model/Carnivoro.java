
package Model;

import java.util.InvalidPropertiesFormatException;
import javax.persistence.Entity;
@Entity
public class Carnivoro extends Mamifero {
    private static double porcentajeExtra = 0.1;
    private static double pesoMaximo = 500;

    public Carnivoro(){
        
    }

   public Carnivoro(int edad, double peso, Pais origen, Especie especie, Sector sector) throws InvalidPropertiesFormatException, Exception {
        super(edad, peso, origen, especie, sector,Dieta.CARNIVORO);
        
    }     
    
 

    public static void setPorcentajeExtra(double porcentajeExtra) {
        Carnivoro.porcentajeExtra = porcentajeExtra;
    }

    public static void setPesoMaximo(double pesoMaximo) {
        Carnivoro.pesoMaximo = pesoMaximo;
    }

    public static double getPorcentajeExtra() {
        return porcentajeExtra;
    }

    public static double getPesoMaximo() {
        return pesoMaximo;
    }
     
    public double getPorcentajeExtraASumar(){
        return 1 + (peso > pesoMaximo ? porcentajeExtra : 0);
    }
    
    @Override
    public double calcularComida() {
        return peso * especie.getPorcentajePesoEnCarne() * getPorcentajeExtraASumar();
    }
    
}
