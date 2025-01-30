package Test;

import java.io.IOException;

import Classes.Associacio;
import LlistesGestioFitxers.LlistaAssociacionsSerial;

public class TestLlistaAccionsSerial {
    public static void main(String[] args) throws IOException {
        System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("25. Comprovació LlistaAssociacionsSerial!\n");

                    LlistaAssociacionsSerial llistaTest = new LlistaAssociacionsSerial();

                    String[] titulacionsTest1 = {"GEB", "GEI"};
                    String[] membresTest1 = {"Membre1", "Membre2", "Membre3"};
                    Associacio assocTest1 = new Associacio("AssociacióTest1", "test1@example.com", titulacionsTest1, membresTest1, "President1", "Secretari1", "Tresorer1", 3, 0);
                    String[] titulacionsTest2 = {"GEB", "GESST"};
                    String[] membresTest2 = {"Membre4", "Membre5", "Membre6"};
                    Associacio assocTest2 = new Associacio("AssociacióTest2", "test2@example.com", titulacionsTest2, membresTest2, "President2", "Secretari2", "Tresorer2", 3, 0);

                    llistaTest.afegirAssoc(assocTest1);
                    llistaTest.afegirAssoc(assocTest2);

                    System.out.println("Llista d'associacions després d'afegir:");
                    System.out.println(llistaTest.toString());

                    llistaTest.eliminarAssoc("AssociacióTest1");

                    System.out.println("Llista d'associacions després d'eliminar:");
                    System.out.println(llistaTest.toString());

                    try {
                        llistaTest.guardarAssociacions();
                        System.out.println("Associacions guardades correctament.");
                    } catch (IOException e) {
                        System.out.println("Error guardant les associacions: " + e.getMessage());
                    }

                    LlistaAssociacionsSerial llistaCarregadaTest = new LlistaAssociacionsSerial();
                    try {
                        llistaCarregadaTest.carregarAssociacions();
                        System.out.println("Associacions carregades correctament.");
                    } catch (IOException e) {
                        System.out.println("Error carregant les associacions: " + e.getMessage());
                    }

                    System.out.println("Llista d'associacions carregades:");
                    System.out.println(llistaCarregadaTest.toString());

                    if (llistaCarregadaTest.equals(llistaTest)) {
                        System.out.println("Les dues llistes són iguals i per tant la serialització ha funcionat correctament.");
                    } else {
                        System.out.println("Les dues llistes no són iguals i per tant la serialització no ha funcionat correctament.");
                    }

                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("26. Mostrar el contingut del fitxer creat\n");

                    LlistaAssociacionsSerial llistaCarregada26 = new LlistaAssociacionsSerial();
                    try {
                        llistaCarregada26.carregarAssociacions();
                        System.out.println("Associacions carregades correctament.");
                    } catch (IOException e) {
                        System.out.println("Error carregant les associacions: " + e.getMessage());
                    }

                    System.out.println("Llista d'associacions carregades:");
                    System.out.println(llistaCarregada26.toString());
    }

    
}
