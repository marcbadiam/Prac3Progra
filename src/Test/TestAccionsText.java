
package Test;

import Classes.*;
import LlistesGestioFitxers.*;

public class TestAccionsText {
    public static void main(String[] args) {
        System.out.println("\n!!!!!!!!!!!:");
        System.out.println("18. Comprovacio AccionsText!");
        LlistaAssociacionsSerial llistaAssociacions51 = new LlistaAssociacionsSerial();
        String[] titulacions51 = {"GEB", "GEI", "GESST"};
        String[] membres51 = {"Membre1", "Membre2", "Membre3"};
        Associacio associacio51 = new Associacio("Associació de Prova", "email@example.com", titulacions51, membres51, "President", "Secretari", "Tresorer", 3, 3);
        llistaAssociacions51.afegirAssoc(associacio51);
        
        System.out.println("Arriba aqui! 185");
        LlistaAccionsText llistaAccions3 = new LlistaAccionsText();
        System.out.println("Arriba 529");
        //Accio accio1 = new Accio("Accio1", "Jaume", pos1);
        //Accio accio2 = new Accio("Accio2", "Miquel", pos2);
        Accio accioD = new Demostracio( "Demostració Robotica", "Pol Caballé", new Data(20, 4, 2024), true, (short) 15, 200, new int[]{3});
        Accio accioX = new Xerrada("Xerrada Big Data", "Yeray Zarza", 40, new Data(10, 5, 2024), (short) 25, 150, new int[]{2, 4});
        llistaAccions3.afegirAccio(accioD);

        llistaAccions3.afegirAccio(accioX);

        //llistaAccions3.carregarAccions();

        System.out.println("Detalls de la Llista d'Accions:");
        System.out.println(llistaAccions3.toString());

        // getters
        System.out.println("\nProva dels getters:");
        System.out.println("Nombre d'Accions: " + llistaAccions3.getNumAccions());
    }
}