package Test;

import java.io.IOException;

import Classes.Associacio;
import LlistesGestioFitxers.LlistaAssociacionsSerial;

public class TestCarregarPosicionsAssocciacio {
    public static void main(String[] args) {
        System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("Comprovacio carregarPosicionsAssocciacio");

                    LlistaAssociacionsSerial llistaTestt = new LlistaAssociacionsSerial();
                    String[] titulacionsTestt1 = {"GEB", "GEI"};
                    String[] membresTestt1 = {"Membre1", "Membre2", "Membre3"};
                    Associacio assocTestt1 = new Associacio("AssociacióTest1", "test1@example.com", titulacionsTestt1, membresTestt1, "President1", "Secretari1", "Tresorer1", 3, 1);
                    String[] titulacionsTestt2 = {"GEB", "GESST"};
                    String[] membresTestt2 = {"Membre4", "Membre5", "Membre6"};
                    Associacio assocTestt2 = new Associacio("AssociacióTest2", "test2@example.com", titulacionsTestt2, membresTestt2, "President2", "Secretari2", "Tresorer2", 3, 4);
                    String[] titulacionsTestt3 = {"GEB", "GEI"};
                    String[] membresTestt3 = {"Membre7", "Membre8", "Membre9"};
                    Associacio assocTestt3 = new Associacio("AssociacióTest3", "test3@example.com", titulacionsTestt3, membresTestt3, "President3", "Secretari3", "Tresorer3", 3, 2);
                    String[] titulacionsTestt4 = {"GEB", "GESST"};
                    String[] membresTestt4 = {"Membre10", "Membre11", "Membre12"};
                    Associacio assocTestt4 = new Associacio("AssociacióTest4", "test4@example.com", titulacionsTestt4, membresTestt4, "President4", "Secretari4", "Tresorer4", 3, 3);

                    llistaTestt.afegirAssoc(assocTestt1);
                    llistaTestt.afegirAssoc(assocTestt2);
                    llistaTestt.afegirAssoc(assocTestt3);
                    llistaTestt.afegirAssoc(assocTestt4);
                    
                    System.out.println("Llista d'associacions després d'afegir:");
                    System.out.println(llistaTestt.toString());

                    try {
                        llistaTestt.guardarAssociacions();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    int[] posicionsTestt = {0, 3};
                    LlistaAssociacionsSerial llistaPos = new LlistaAssociacionsSerial();
                    llistaPos = llistaPos.carregarPosicionsAssociacions(posicionsTestt);
                    System.out.println(llistaPos.toString());

    }
}
