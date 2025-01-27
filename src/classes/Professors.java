package classes;
/**
 * @author Yerai Zarza
 */

public class Professors extends Membres {
    private int despatx;
    private String departament;
    private String email;
    private String aliesID;

    public Professors(String aliesID, String email, String departament, int despatx){
        super(aliesID, email, true);
        this.aliesID = aliesID;
        this.email = email;
        this.departament = departament;
        this.despatx = despatx;
    }

    public int getDespatx() {
        return despatx;
    }

    public String getDepartament() {
        return departament;
    } 

    public String getEmail() {
        return email;
    } 

    public String getAliesID() {
        return aliesID;
    } 
    
    public void setDespatx(int despatx) {
        this.despatx = despatx;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setAliesId (String aliesID) {
        this.aliesID = aliesID;
    }

    public String toString() {
        return ("Professors [alies=" + aliesID + "email institucional=" + email + ", departament=" + departament + ", despatx=" + despatx + "]");
    }
   
}
