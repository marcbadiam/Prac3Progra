package Classes;

/**
 * @author Yeray Zarza
 */

 public class Alumnes extends Membres {
    private String ensenyament;
    private int anys;

    public Alumnes(String aliesID, String correu, Data dataAlta, Data dataBaixa, String ensenyament, int anys) {
        super(aliesID, correu, false, dataAlta, dataBaixa);
        this.ensenyament = ensenyament;
        this.anys = anys;
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