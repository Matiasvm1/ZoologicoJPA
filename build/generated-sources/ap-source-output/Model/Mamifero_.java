package Model;

import Model.Dieta;
import Model.Especie;
import Model.Pais;
import Model.Sector;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-26T22:08:23", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Mamifero.class)
public abstract class Mamifero_ { 

    public static volatile SingularAttribute<Mamifero, Especie> especie;
    public static volatile SingularAttribute<Mamifero, Integer> codigo;
    public static volatile SingularAttribute<Mamifero, Double> peso;
    public static volatile SingularAttribute<Mamifero, Pais> origen;
    public static volatile SingularAttribute<Mamifero, Integer> edad;
    public static volatile SingularAttribute<Mamifero, Sector> sector;
    public static volatile SingularAttribute<Mamifero, Dieta> dieta;

}