package GestioFitxers;

import java.io.*;
//import java.util.ArrayList;
//import java.util.List;

import Classes.Associacio;

//import classes.Associacio;

/**
 * @author Marc Badia, Pol Caballé
 */

public class LlistaAssociacionsSerial {
    
    private static final String FILE_PATH = "associacions.csv";
    private int nElem;
    private Associacio[] llista;
    private static final int CAPACITAT_INICIAL = 100; // Capacitat inicial de la llista

    public LlistaAssociacionsSerial() {
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
                llista[i] = llista[nElem-1].copia();
                llista[nElem-1] = null;
                nElem--;
                i=nElem; //condició per sortir del bucle un cop trobar el element a eliminar
            }
        }
    } // 1      2      3

    public LlistaAssociacionsSerial copiaLlistAssociacio(){

        LlistaAssociacionsSerial copia = new LlistaAssociacionsSerial();
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
            if(n>=nElem) str+= "getNomAssociacioPosicio: Assoc no existent: n>=nElem  \n"+n+ "nElem: " +nElem;
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
    public void guardarAssociacions() throws IOException {
        try (ObjectOutputStream outputfile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("associacions.bin")))) {
            for (Associacio associacio : llista) {
                outputfile.writeObject(associacio);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
        }
    }

    public void carregarAssociacions() throws IOException{
        try (ObjectInputStream inputfile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("associacions.bin")))) {
            Associacio associacio;
            while ((associacio = (Associacio) inputfile.readObject()) != null) {
                afegirAssoc(associacio);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
        }
        catch(EOFException e) {
            System.out.println("Fitxer carregat correctament");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Classe no trobada");
        }
    }
/* 
    public void carregarAssociacions() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String[] membres = data[2].split(",");
                String[] titulacions = data[3].split(",");
                Associacio a = new Associacio(data[0],data[1],
                            membres,titulacions,data[4],data[5],data[6],
                            Integer.parseInt(data[7]),Integer.parseInt(data[8])); 
                afegirAssoc(a);
            }
        } catch (IOException e) {
            System.out.println("No es pot carregar el fitxer: " + e.getMessage());
        }
    }

    public void guardarAssociacions() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Associacio associacio : llista) {
                if (associacio != null)
                    bw.write(associacio.toStringSerial()+ "\n");
            }
        } catch (IOException e) {
            System.out.println("No es pot guardar el fitxer: " + e.getMessage());
        }
    }*/
    public String toString(){
        String str = "";
        int i=0;
        if(llista!=null) {
            for (Associacio associacio : llista) {
                if (associacio != null) { 
                    str += "Associacio Numero: " + i++ + "=\n";
                    str += associacio.toStringSerial() + "\n"; //Utilitzo el Serial mentre encara no han creat el toString "normal"
                }
            }
        } else {
            str = "No hi ha cap associacio";
        }
        return str;
    }

    public boolean equals(LlistaAssociacionsSerial llista2){
        if(nElem!=llista2.getNElem()) return false;
        for(int i=0; i<nElem; i++){
            if(!llista[i].equals(llista2.llista[i])) return false;
        }
        return true;
    }

    /**
     * Mètode per obtenir una associació en una posició específica de la llista.
     * @param posicio la posició de l'associació a retornar.
     * @return la instància de l'associació en la posició especificada, o null si la posició és invàlida.
     */
    public Associacio getAssociacio(int posicio) {
        if (posicio >= 0 && posicio < nElem) {
            return llista[posicio];
        }
        return null;
    }


    /**
     * Mètode per carregar les associacions des del fitxer en les posicions especificades i emmagatzemar-les en una llista.
     * @param posicions un array d'enters que conté les línies del fitxer a extreure.
     * @return una llista d'associacions.
     
    public LlistaAssociacionsSerial carregarPosicionsAssociacions(int[] posicions) {
        LlistaAssociacionsSerial llistaAssociacions = new LlistaAssociacionsSerial();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int currentLine = 0;
            int posIndex = 0;
            while ((line = br.readLine()) != null && posIndex < posicions.length) {
                if (currentLine == posicions[posIndex]) {
                    String[] data = line.split(";");
                    if (data.length < 9) {
                        System.out.println("Línia incorrecta: " + line);
                        posIndex++;
                        continue; // Salta a la siguiente línea
                    }
                    String[] membres = data[2].isEmpty() ? new String[0] : data[2].split(",");
                    String[] titulacions = data[3].isEmpty() ? new String[0] : data[3].split(",");
                    Associacio a = new Associacio(data[0], data[1], membres, titulacions, data[4], data[5], data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]));
                    llistaAssociacions.afegirAssoc(a);
                    posIndex++;
                }
                currentLine++;
            }
        } catch (IOException e) {
            System.out.println("No es pot carregar el fitxer: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el format numèric: " + e.getMessage());
        }
        return llistaAssociacions;
    }*/
}