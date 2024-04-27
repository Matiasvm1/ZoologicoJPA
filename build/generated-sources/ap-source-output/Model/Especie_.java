package Model;

import Model.Dieta;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-26T22:08:23", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Especie.class)
public class Especie_ { 

    public static volatile SingularAttribute<Especie, Double> porcentajePesoEnCarne;
    public static volatile SingularAttribute<Especie, Integer> id;
    public static volatile SingularAttribute<Especie, String> nombre;
    public static volatile SingularAttribute<Especie, Dieta> dieta;

}