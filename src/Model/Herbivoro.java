
package Model;

import java.util.InvalidPropertiesFormatException;
import javax.persistence.Entity;

@Entity
public class Herbivoro extends Mamifero{
 private static double pesoEnHierbas = 2 ;
 private double valorFijoHerbivoro;

    public Herbivoro() {
    }

  
    public Herbivoro(double valorFijoHerbivoro, int edad, double peso, Pais origen, Especie especie, Sector sector) throws InvalidPropertiesFormatException, Exception {
        super(edad, peso, origen, especie, sector,Dieta.HERBIVORO);
        this.valorFijoHerbivoro = valorFijoHerbivoro;
      
    }

    public static double getPesoEnHierbas() {
        return pesoEnHierbas;
    }

    public static void setPesoEnHierbas(double pesoEnHierbas) {
        Herbivoro.pesoEnHierbas = pesoEnHierbas;
    }

    public double getValorFijoHerbivoro() {
        return valorFijoHerbivoro;
    }

    public void setValorFijoHerbivoro(double valorHerbivoro) {
        this.valorFijoHerbivoro = valorHerbivoro;
    }




    @Override
    public double calcularComida() {
        return (super.getPeso()* pesoEnHierbas)+ valorFijoHerbivoro;
    }
    
}
