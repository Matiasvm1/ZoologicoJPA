package Model;

import Model.Dieta;
import Model.Empleado;
import Model.Mamifero;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-26T22:08:23", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Sector.class)
public class Sector_ { 

    public static volatile ListAttribute<Sector, Mamifero> mamiferos;
    public static volatile SingularAttribute<Sector, Double> latitud;
    public static volatile SingularAttribute<Sector, Double> longitud;
    public static volatile SingularAttribute<Sector, Dieta> tipo;
    public static volatile SingularAttribute<Sector, Empleado> empleadoResponsable;
    public static volatile SingularAttribute<Sector, Integer> id;
    public static volatile SingularAttribute<Sector, Integer> limite;

}