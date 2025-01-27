package Tests;
import classes.*;
import Llistes.*;

public class TestClasseXerrada {
    public static void main(String[] args) {
        System.out.println("\n!!!!!!!!!!!:");
        System.out.println("Comprovació classe Xerrada:\n\n");
        LlistaAssociacions llistaAssociacions = new LlistaAssociacions();
        String[] titulacions = {"GEB", "GEI", "GESST"};
        String[] membres = {"Membre1", "Membre2", "Membre3"};
        Associacio associacio = new Associacio("Associació de Prova", "email@example.com", titulacions, membres, "President", "Secretari", "Tresorer", 3, 0);      
        llistaAssociacions.afegirAssoc(associacio);

        Data dataXerrada = new Data(); 
        Xerrada xerrada1 = new Xerrada("Xerrada1", "Toni", dataXerrada, 50, (short) 5, llistaAssociacions);
        Xerrada xerrada2 = new Xerrada("Xerrada2", "Albert", dataXerrada, 32, (short) 3, llistaAssociacions);
                        
        System.out.println("Detalls de la Xerrada 1:");
        System.out.println(xerrada1.toString());
        System.out.println("Detalls de la Xerrada 2:");
        System.out.println(xerrada2.toString());
                    
        // getters
        System.out.println("\nProva dels getters:");
        System.out.println("Data de la Xerrada: " + xerrada1.getDataXerrada());
        System.out.println("Nombre d'Assistents: " + xerrada1.getNAssistents());
        System.out.println("Valoracions: " + xerrada1.getValoracions());
                    
        // setters
        System.out.println("\nProva dels setters:");
        Data novaDataXerrada = new Data(); 
        xerrada1.setDataXerrada(novaDataXerrada);
        xerrada1.setNAssistents(100);
        xerrada1.setValoracions((short) 4);
                    
        // Mostrar despres de setters
        System.out.println("Detalls de la Xerrada després de modificar:");
        System.out.println(xerrada1.toString());
    }
}
