
package Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Empleado implements Serializable {
    @Id
    private int dni;
            
    private String nombre;
    private String direccion;
    

    public Empleado(){
        
    }
    
    public Empleado(int dni,String nombre, String direccion ) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
    
}
