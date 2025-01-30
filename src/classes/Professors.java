package Classes;

import LlistesGestioFitxers.LlistaAssociacionsSerial;

/**
 * @author Yeray Zarza
 */

 public class Professors extends Membres {
    private int despatx;
    private String departament;

    public Professors(String aliesID, String correu,boolean esProfessor,Data dataAlta, Data dataBaixa, String departament, int despatx,LlistaAssociacionsSerial associacions){
        super(aliesID, correu, esProfessor, dataAlta, dataBaixa,associacions);
        this.departament = departament;
        this.despatx = despatx;
    }

    public int getDespatx() {
        return despatx;
    }

    public String getDepartament() {
        return departament;
    } 
    
    public void setDespatx(int despatx) {
        this.despatx = despatx;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    
    public String toString() {
        return "Professors [alies=" + getAliesId() + ", correu institucional=" + getCorreu() +
               ", departament=" + departament + ", despatx=" + despatx + "]";
    }
}

