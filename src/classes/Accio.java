package Classes;

import GestioFitxers.LlistaAssociacionsSerial;

/**
 * @author Marc Badia, Pol Caballé
 */

public class Accio {
    
    protected String codi = "";    // S'ha de fer metode que a partir de nom assoc. generi codi
    protected String titol;
    protected String responsable;
    protected LlistaAssociacionsSerial llistaAss = new LlistaAssociacionsSerial();
    int[] posicionsAssociacions;



    public Accio(String t, String r, int[] posicionsAssociacions) {//String = "1;4;5"
        //this.llistaAss = new LlistaAssociacionsSerial();
        //this.llistaAss.carregarPosicionsAssociacions(posicionsAssociacions);
        //codi = generarCodi(); 
        //falta associar les associacions amb les accions per gaurdar els reesponsables i generar el codi
        
        //codi = "";
        titol = t; 
        responsable = r; 
        this.posicionsAssociacions = posicionsAssociacions;

        llistaAss = llistaAss.carregarPosicionsAssociacions(posicionsAssociacions);
        codi = generarCodi();
    }

    public String getCodi(){
        return codi;
    }

    public String getTitol(){
        return titol;
    }

    public String getResponsable(){
        return responsable;
    }

    public LlistaAssociacionsSerial getLlistaAss(){
        return llistaAss;
    }

    public String generarCodi(){

        String digits = ""; 
        System.out.println(llistaAss.getNomAssociacioPosicio(0));
        for (int i = 0; i < llistaAss.getNomAssociacioPosicio(0).length() && i<3; i++) {
            char c = llistaAss.getNomAssociacioPosicio(0).charAt(i); 
            digits += c; 
        }//arreglar
        //llistaAss.incrementarNombreAccionsPosicio(0);
        int val = 99+llistaAss.getNumAccionsPosicio(0);
        digits += val;
        return digits;
    }

    public String toString() {

        return "Accio{" +
                "codi='" + codi + '\'' +
                ", titol='" + titol + '\'' +
                ", responsable='" + responsable + '\'' +
                ", nAssoc organitzadores=" + llistaAss.getNElem() +
                ", posicionsAssociacions0='" + posicionsAssociacions[0] + '\'' +
                '}';
    }

    public Accio copia(){
        Accio copiaAccio = new Accio(titol, responsable, posicionsAssociacions);
        return copiaAccio;
    }

    public boolean esDAssociacio(String nomAssociacio){
       boolean trobat = false;
       for(int i = 0; i < llistaAss.getNElem(); i++){
        if(llistaAss.getNomAssociacioPosicio(i).equals(nomAssociacio)){
            trobat = true;
        }
       }
        return trobat;
    }

}