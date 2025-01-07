package GestioFitxers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import Llistes.LlistaAssociacions;
import Classes.*;

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
/* 
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
    }*/
    public void carregarAccions() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
    
                String codi = st.nextToken();
                String titol = st.nextToken();
                String responsable = st.nextToken();
                String[] dateParts = st.nextToken().split("-");
                int[] data = new int[3];
                for (int i = 0; i < dateParts.length; i++) {
                data[i] = Integer.parseInt(dateParts[i]);
                }
                String nomAssociacions = st.nextToken();
                int cost = Integer.parseInt(st.nextToken());
                short valoracions = Short.parseShort(st.nextToken());
                int vegades = Integer.parseInt(st.nextToken());
                boolean valida = Boolean.parseBoolean(st.nextToken());
                boolean esXerrada = Boolean.parseBoolean(st.nextToken());
                
    
                String[] associacions = nomAssociacions.split(",");
                LlistaAssociacions llistaAs = new LlistaAssociacions();
                for (String assoc : associacions) {
                      
                }
                

                
                Accio ac;
                if (esXerrada) {
                    Data dataXerrada = new Data();
                    dataXerrada.setData(data[2], data[1], data[0]);
                    ac = new Xerrada(titol, responsable, dataXerrada, vegades, valoracions, llistaAs);
                } else {
                    Data dataDisseny = new Data();
                    dataDisseny.setData(data[2], data[1], data[0]);
                    ac = new Demostracio(titol, responsable, dataDisseny, vegades, valida, valoracions, cost, llistaAs);
                }

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

    public Associacio getAssocPosicio(int pos) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int currentIndex = 0; 
            while ((line = br.readLine()) != null) {
                if (currentIndex == pos) { 
                    String[] data = line.split(";");
    
                    
                    if (data.length < 9) {
                        System.out.println("Format incorrecte a la línia: " + line);
                        return null;
                    }
    
                    String[] membres = data[2].split(",");
                    String[] titulacions = data[3].split(",");
                    return new Associacio(
                            data[0],  // ID
                            data[1],  // Nom
                            membres,  // Membres
                            titulacions,  // Titulacions
                            data[4],  // Algún campo adicional
                            data[5],  // Algún campo adicional
                            data[6],  // Algún campo adicional
                            Integer.parseInt(data[7]), // Algún campo numérico
                            Integer.parseInt(data[8])  // Algún campo numérico
                    );
                }
                currentIndex++; // Incrementar el índice actual
            }
        } catch (IOException e) {
            System.out.println("No es pot carregar el fitxer: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el format numèric: " + e.getMessage());
        }
        return null; // Retornar null si no se encuentra la posición
    }
    


}
