package Classes;

import LlistesGestioFitxers.LlistaAssociacionsSerial;

/**
 * @author Yeray Zarza
 */

 public class Alumnes extends Membres {
    private String ensenyament;
    private int anys;
    private boolean graduat;

    public Alumnes(String aliesID, String correu,boolean esProfessor, Data dataAlta, Data dataBaixa, String ensenyament, int anys,LlistaAssociacionsSerial associacions, boolean graduat) {
        super(aliesID, correu, esProfessor, dataAlta, dataBaixa,associacions);
        this.ensenyament = ensenyament;
        this.anys = anys;
        this.graduat = graduat;
    }

    public boolean esGraduat() {
        return graduat;
    }

    public String getEnsenyament() {
        return ensenyament;
    }

    public int getAnys() {
        return anys;
    }

    public void setEnsenyament(String ensenyament) {
        this.ensenyament = ensenyament;
    }

    public void setAnys(int anys) {
        this.anys = anys;
    }

    
    public String toString() {
        return super.toString() + ", Alumnes [ensenyament=" + ensenyament + ", anys universitat=" + anys + "]";
    }
}