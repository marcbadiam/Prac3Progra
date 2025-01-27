package classes;

/**
 * @author Yerai Zarza
 */

public class Alumnes extends Membres{
    private String ensenyament;
    private int anys;
    private String email;
    private String aliesID;

    public Alumnes(String aliesID, String email, String ensenyament, int anys){
        super(aliesID, email, false);
        this.aliesID = aliesID;
        this.email = email;
        this.ensenyament = ensenyament;
        this.anys = anys;
    }

    public String getEnsenyament() {
        return ensenyament;
    }
    
    public int getAnys() {
        return anys;
    }

    public String getEmail() {
        return email;
    } 

    public String getAliesID() {
        return aliesID;
    } 
    
    public void setEnsenyament(String ensenyament) {
        this.ensenyament = ensenyament;
    }
    
    public void setAnys(int anys) {
        this.anys = anys;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setAliesId (String aliesID) {
        this.aliesID = aliesID;
    }
    
    public String toString() {
        return "Alumnes [alies=" + aliesID + "ensenyament=" + ensenyament + ", email institucional=" + email + ", anys universitat=" + anys +"]";
    }
}
