
package Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Especie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private double porcentajePesoEnCarne;
    @Enumerated(EnumType.STRING)
    private Dieta dieta;

    public Especie(){
        
    }
    public Especie(String nombre, double porcentajePesoEnCarne,Dieta dieta) {
        if(dieta.esCarnivoro()) this.porcentajePesoEnCarne = porcentajePesoEnCarne;
         this.dieta = dieta;
         this.nombre = nombre;
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentajePesoEnCarne() {
        return porcentajePesoEnCarne;
    }

    public void setPorcentajePesoEnCarne(double porcentajePesoEnCarne) {
        this.porcentajePesoEnCarne = porcentajePesoEnCarne;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }
  
    
}
