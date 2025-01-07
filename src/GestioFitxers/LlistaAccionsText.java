package GestioFitxers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import Classes.Accio;
import Llistes.LlistaAssociacions;

/**
 * @author Yeray Zarza
 */

public class LlistaAccionsText {
    private static final String FILE_PATH = "accions.csv";
    private int nElem;
    private Accio[] llista;
    private static final int CAPACITAT_INICIAL = 100; // Capacitat inicial de la llista

    public LlistaAccionsText(){
        llista = new Accio[CAPACITAT_INICIAL];
        nElem = 0;
    }

    public void afegirAccio(Accio ac) {
        if (nElem < llista.length) {
            llista[nElem] = ac.copia();
            nElem++;
            System.out.println("Acció afegida: " + ac.getTitol());
            System.out.println("Nombre d'elements actual: " + nElem);
        } else {
            System.out.println("No es pot afegir més acccions, capacitat màxima.");
        }
    }

    public void eliminarAccio(String codiId) { 
        int i=0;
        boolean trobat = false;
        while (i < nElem && !trobat){
           if(llista[i].getCodi().equalsIgnoreCase(codiId)){
                trobat = true;
                llista[i] = llista[nElem-1].copia();
                llista[nElem-1] = null;
                nElem--; 
                System.out.println("Accio eliminada correctament.");
           } 
           i++;   
        }
        if(!trobat){
            System.out.println("La accio no s'ha eliminat ja que no existeix.");
        }
    }

    public LlistaAccionsText copiaLlistaAccionstext(){

        LlistaAccionsText copia = new LlistaAccionsText();
        for (int i = 0; i < nElem; i++){
            copia.afegirAccio(llista[i].copia());
        }
        return copia;
    }

    /**
     * Mètode per obtenir una acció en una posició específica de la llista.
     * @param posicio la posició de l'acció a retornar.
     * @return la instància de l'acció en la posició especificada, o null si la posició és invàlida.
     */
    public Accio getAccio(int posicio) {
        if (posicio >= 0 && posicio < nElem) {
            return llista[posicio];
        }
        return null;
    }

    /**
     * Mètode per obtenir el nombre d'elements en la llista.
     * @return el nombre d'elements en la llista.
     */
    public int getNElem() {
        return nElem;
    }

    public void carregarAccions() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";"); 
                String titol = st.nextToken();
                String responsable = st.nextToken();
                
                
                //int idAssociacio = Integer.parseInt(st.nextToken());
                LlistaAssociacions llistaAs = new LlistaAssociacions();
    
                Accio ac = new Accio(titol, responsable, llistaAs);
                afegirAccio(ac);
            }
        } catch (IOException e) {
            System.out.println("No es pot carregar el fitxer: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el format de dades numèriques: " + e.getMessage());
        }
    }

    public void guardarAccions() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Accio accio : llista) {
                if (accio != null)
                    bw.write(accio.toString()+ "\n");
            }
        } catch (IOException e) {
            System.out.println("No es pot guardar el fitxer: " + e.getMessage());
        }
    }


}
