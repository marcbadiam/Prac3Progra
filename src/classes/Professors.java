package Classes;
/**
 * @author Yeray Zarza
 */

 public class Professors extends Membres {
    private int despatx;
    private String departament;

    public Professors(String aliesID, String correu, Data dataAlta, Data dataBaixa, String departament, int despatx) {
        super(aliesID, correu, true, dataAlta, dataBaixa);
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

