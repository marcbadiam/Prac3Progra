package Llistes;

import classes.*;

/**
 * @author Marc Badia, Pol Caballé
 */

public class LlistaAssociacions {
    
    private int nElem;
    private Associacio[] llista;
    private static final int CAPACITAT_INICIAL = 100; // Capacitat inicial de la llista

    public LlistaAssociacions() {
        llista = new Associacio[CAPACITAT_INICIAL];
        nElem = 0;
    }

    public void afegirAssoc(Associacio a) {
        if (nElem < llista.length) {
            llista[nElem] = a.copia();
            nElem++;
            System.out.println("Associació afegida: " + a.getNomAssociacio());
            System.out.println("Nombre d'elements actual: " + nElem);
        } else {
            System.out.println("No es pot afegir més associacions, capacitat màxima.");
        }
    }

    public void eliminarAssoc(String nomAssoc) {
        for(int i=0; i<nElem; i++){
            if(llista[i].getNomAssociacio().equalsIgnoreCase(nomAssoc)){
                llista[i] = llista[nElem-1];
                llista[i-1] = null;
                nElem--;
            }
        }
    }

    public LlistaAssociacions copiaLlistAssociacio(){

        LlistaAssociacions copia = new LlistaAssociacions();
        for (int i = 0; i < nElem; i++){
            copia.afegirAssoc(llista[i].copia());
        }
        return copia;
    }
    
    public String getNomAssociacioPosicio(int n) {
        if (n >= 0 && n < nElem && llista[n] != null) {
            return llista[n].getNomAssociacio();
        } else {
            String str="Err:\n";
            if(n<0) str+= "getNomAssociacioPosicio: Assoc no existent: n<0  \n";
            if(n>=nElem) str+= "getNomAssociacioPosicio: Assoc no existent: n>=nElem  \n";
            if(llista[n]==null) str+= "getNomAssociacioPosicio: Assoc no existent:  llista[n] == null  \n";
            return str;
        }
    }

    public int getNumAccionsPosicio(int n) {
        if (n >= 0 && n < nElem && llista[n] != null) {
            return llista[n].getNombreAccions();
        } else {
            return 0;
        }
    }

    public void incrementarNombreAccionsPosicio(int n){
        if (n >= 0 && n < nElem && llista[n] != null) {
            llista[n].incrementarNombreAccions();
        } else {
            if(n<0) System.out.println("incrementarNombreAccionsPosicio: No es compleix que n>=0 || n: " + n);
            if(n>=nElem) System.out.println("incrementarNombreAccionsPosicio: No es compleix que n<nElem  || n: " + n + " || nElem: " + nElem);
            if(llista[n]==null) System.out.println("incrementarNombreAccionsPosicio: No es compleix que llista[n] != null  ");
        }
    }

    public int getNElem() {
        return nElem;
    }

}


