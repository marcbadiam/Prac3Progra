package Llistes;

import classes.*;
/**
 * @author Marc Badia, Pol Caballé
 */

public class LlistaAccions {
    private int nElem;
    private Accio[] llistaAccio;
    private static final int CAPACITAT_INICIAL = 100; // Capacitat inicial de la llista

    public LlistaAccions() {
        llistaAccio = new Accio[CAPACITAT_INICIAL];
        nElem = 0;
    }
    public int getNumAccions(){
        return nElem;
    }

    public LlistaAccions copia(){
        LlistaAccions copiaLlistaAccions = new LlistaAccions();
        return copiaLlistaAccions;
    }

    public void afegirAccio(Accio accio) {
        if (nElem < CAPACITAT_INICIAL) {
            llistaAccio[nElem++] = accio;
        } else {
            System.out.println("No es poden afegir més accions, capacitat maxima");
        }
    }

    public String toString() { 
        String str = "";
        int i=0;
        if(llistaAccio!=null) {
            for (Accio accio : llistaAccio) {
                if (accio != null) { // Add null check here
                    str += "AccioNumero: " + i++ + "=\n";
                    str += accio.toString() + "\n";
                }
            }
        } else {
            str = "No hi ha cap accio";
        }
        return str;
    }
}

