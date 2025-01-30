package Test;

import java.io.IOException;

import LlistesGestioFitxers.LlistaAssociacionsSerial;

public class TestMostrarAssociacions {
    public static void main(String[] args) {
        System.out.println("Mostrar associacions.bin");
                    LlistaAssociacionsSerial mostrar = new LlistaAssociacionsSerial();
                    try {
                        mostrar.carregarAssociacions();
                        System.out.println("Associacions carregades correctament.");
                    } catch (IOException e) {
                        System.out.println("Error carregant les associacions: " + e.getMessage());
                    }

                    System.out.println(mostrar.toString());
    }
}
