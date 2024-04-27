
package Model;

import java.io.Serializable;
import java.util.InvalidPropertiesFormatException;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Mamifero implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  private int codigo;
  
  protected int edad;
  protected double peso;
  @OneToOne
  protected Pais origen;
  @OneToOne
  protected Especie especie;
  @ManyToOne
  protected Sector sector;
  @Enumerated(EnumType.STRING)
  protected Dieta dieta;

  
    protected Mamifero(){
        
    }

    protected Mamifero(int edad, double peso, Pais origen, Especie especie, Sector sector,Dieta dieta) throws InvalidPropertiesFormatException, Exception {
        
        if(origen == null)
            throw new IllegalArgumentException("Origen nulo en la creacion del Mamifero.");
        if(especie == null)
            throw new IllegalArgumentException("Especie nula en la creacion del Mamifero.");
        if(origen == null)
            throw new IllegalArgumentException("Sector nulo en la creacion del Mamifero.");
        if(dieta.ordinal() != especie.getDieta().ordinal())
            throw new IllegalArgumentException("La dieta del mamifero no es la misma que la de la Especie");
      
        this.dieta = dieta;
        this.edad = edad;
        this.peso = peso;
        this.origen = origen;
        this.especie = especie;
        this.sector = sector;
 
        
    }
    
    public abstract double calcularComida();

    public int getEdad() {
        return edad;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public Pais getOrigen() {
        return origen;
    }

    public Especie getEspecie() {
        return especie;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Dieta getDieta() {
        return dieta;
    }

    double comida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

  
    


  
  
    
}
