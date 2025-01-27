package Tests;

import classes.*;
import Llistes.*;

public class TestClasseLlistaAccions {
    public static void main(String[] args) {
        System.out.println("\n!!!!!!!!!!!:");
        System.out.println("51. Comprovació classe LlistaAccions:\n\n");

                    
        LlistaAssociacions llistaAssociacions51 = new LlistaAssociacions();
        String[] titulacions51 = {"GEB", "GEI", "GESST"};
        String[] membres51 = {"Membre1", "Membre2", "Membre3"};
        Associacio associacio51 = new Associacio("Associació de Prova", "email@example.com", titulacions51, membres51, "President", "Secretari", "Tresorer", 3, 0);
        llistaAssociacions51.afegirAssoc(associacio51);
                   
        LlistaAccions llistaAccions = new LlistaAccions();
        Accio accio1 = new Accio("Accio1", "Jaume", llistaAssociacions51);
        Accio accio2 = new Accio("Accio2", "Miquel", llistaAssociacions51);
        llistaAccions.afegirAccio(accio1);
        llistaAccions.afegirAccio(accio2);
                    
        System.out.println("Detalls de la Llista d'Accions:");
        System.out.println(llistaAccions.toString());

        // getters
        System.out.println("\nProva dels getters:");
        System.out.println("Nombre d'Accions: " + llistaAccions.getNumAccions());
    }
}


                    