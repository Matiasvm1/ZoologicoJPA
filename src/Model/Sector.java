
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class Sector implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private double latitud;
    private double longitud;
    private int limite;
    @Enumerated(EnumType.STRING)
    private Dieta tipo;
    @OneToOne
    private Empleado empleadoResponsable;
    @OneToMany
    private ArrayList<Mamifero> mamiferos = new ArrayList<>();

    public Sector(){
        
    }
    public Sector( double latitud, double longitud, int limite, Dieta tipo, Empleado empleadoResponsable) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.limite = limite;
        this.tipo = tipo;
        this.empleadoResponsable = empleadoResponsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getAltitud() {
        return longitud;
    }

    public void setAltitud(double altitud) {
        this.longitud = altitud;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public Dieta getTipo() {
        return tipo;
    }

    public void setTipo(Dieta tipo) {
        this.tipo = tipo;
    }

    public Empleado getEmpleadoResponsable() {
        return empleadoResponsable;
    }

    public void setEmpleadoResponsable(Empleado empleadoResponsable) {
        this.empleadoResponsable = empleadoResponsable;
    }
 
    public double comida(){
        double comida = 0;
        for (Mamifero mamifero : mamiferos) {
            comida = comida + mamifero.comida();
        }
        
        return comida;
    }

    public ArrayList<Mamifero> getMamiferos() {
        return mamiferos;
    }
    
    public void addMamifero(Mamifero mamifero) throws Exception
    {
      
    }

    @Override
    public String toString() {
        return ""+id;
    }

    public void setMamiferos(ArrayList<Mamifero> mamiferos) {
        this.mamiferos = mamiferos;
    }

 
    
   
    
    
    
}
