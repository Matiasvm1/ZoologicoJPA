
package Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Pais implements Serializable {
    @Id
    private int codigoISO;
   
    private String nombre;

    public Pais() {
    }

    public Pais(String nombre, int codigoISO) {
        this.nombre = nombre;
        this.codigoISO = codigoISO;
    }

    public int getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(int codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
