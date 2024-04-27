
package Model;

public enum Dieta {
    CARNIVORO,HERBIVORO;
    
    
    
    public boolean esCarnivoro(){
        return this == CARNIVORO;
    }
     
    public boolean esHerbivoro(){
        return this == HERBIVORO;
    }
    public static boolean esCarnivoro(String dieta){
        return dieta.equalsIgnoreCase("Carnivoro");
       
      
    }
    
}


