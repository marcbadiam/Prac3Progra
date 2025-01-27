package Tests;

import GestioFitxers.LlistaAssociacionsSerial;
import classes.Associacio;

public class TestLlistaAccionsSerial {
    public static void main(String[] args) {
        System.out.println("\n!!!!!!!!!!!:");
        System.out.println("51. Comprovació classe LlistaAssociacionsSerial:\n\n");
                
        LlistaAssociacionsSerial llista = new LlistaAssociacionsSerial();
                    
        String[] titulacions1 = {"GEB", "GEI"};
        String[] membres1 = {"Membre1", "Membre2", "Membre3"};
        Associacio assoc1 = new Associacio("Associació1", "pr1@example.com", titulacions1, membres1, "President1", "Secretari1", "Tresorer1", 3, 0);
        String[] titulacions2 = {"GEB","GESST"};
        String[] membres2 = {"Membre4", "Membre5", "Membre6"};
        Associacio assoc2 = new Associacio("Associació2", "pr2@example.com", titulacions2, membres2, "President2", "Secretari2", "Tresorer2", 3, 0);
        String[] titulacions3 = {"GEI", "GESST"};
        String[] membres3 = {"Membre7", "Membre8", "Membre9"};
        Associacio assoc3 = new Associacio("Associació3", "pr3@example.com", titulacions3, membres3, "President3", "Secretari3", "Tresorer3", 3, 0);
          
        llista.afegirAssoc(assoc1);
        llista.afegirAssoc(assoc2);
        llista.afegirAssoc(assoc3);

        System.out.println(llista.toString());

        llista.eliminarAssoc("Associació2");
                    
        System.out.println("Numero d'elements actuals: " + llista.getNElem());
                    
        System.out.println("Associacions actuals:");
        System.out.println(llista.toString());

        //part serialitzada

        llista.guardarAssociacions();
                    
        LlistaAssociacionsSerial llistaCarregada = new LlistaAssociacionsSerial();
        llistaCarregada.carregarAssociacions();

        System.out.println("Llista Associacions Carregades:");
        System.out.println(llistaCarregada.toString());
                    
        if(llistaCarregada.equals(llista))
            System.out.println("Les dues llistes són iguals i per tant la serialització ha funcionat correctament");
        else    
            System.out.println("Les dues llistes no són iguals i per tant la serialització no ha funcionat correctament");
    }
}
