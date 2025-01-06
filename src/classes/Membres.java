package Classes;
/**
 * @author Núria Yepes
 */
/**
 * Classe abstracta que representa els membres d'una associació.
 * Conté informació sobre la data d'alta, data de baixa, estat de graduació,
 * identificador, correu electrònic, associacions vinculades i el nombre d'associacions.
 * 
 * Aquesta classe és abstracta i es pot estendre per a especialitzacions específiques de membres.
 * 
 */

 public abstract class Membres {
    private Data dataAlta;
    private Data dataBaixa;
    private boolean graduat;
    private String aliesId;
    private String correu;
    //private LlistaAssociacions associacions;
    private int numAssociacions;



    /**
     * Retorna la data d'alta del membre.
     * 
     * @return La data d'alta.
     */
    public Data getDataAlta() {
        return dataAlta;
    }

    /**
     * Retorna la data de baixa del membre.
     * 
     * @return La data de baixa.
     */
    public Data getDataBaixa() {
        return dataBaixa;
    }

    /**
     * Retorna si el membre està graduat o no.
     * 
     * @return True si el membre està graduat, false en cas contrari.
     */
    public boolean isGraduat() {
        return graduat;
    }

    /**
     * Retorna l'identificador alies del membre.
     * 
     * @return L'identificador alies.
     */
    public String getAliesId() {
        return aliesId;
    }

    /**
     * Retorna el correu electrònic del membre.
     * 
     * @return El correu electrònic .
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * Retorna el nombre d'associacions en les quals participa el membre.
     * 
     * @return El nombre d'associacions.
     */
    public int getNumAssociacions() {
        return numAssociacions;
    }

    /**
     * Estableix la data d'alta del membre.
     * 
     * @param dataAlta La nova data d'alta.
     */
    public void setDataAlta(Data dataAlta) {
        this.dataAlta = dataAlta;
    }

    /**
     * Estableix la data de baixa del membre.
     * 
     * @param dataBaixa La nova data de baixa.
     */
    public void setDataBaixa(Data dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    /**
     * Estableix si el membre està graduat o no.
     * 
     * @param graduat True si el membre està graduat, false en cas contrari.
     */
    public void setGraduat(boolean graduat) {
        this.graduat = graduat;
    }

    /**
     * Estableix l'identificador alies del membre.
     * 
     * @param aliesId El nou identificador alies.
     */
    public void setAliesId(String aliesId) {
        this.aliesId = aliesId;
    }

    /**
     * Estableix el correu electrònic del membre.
     * 
     * @param correu El nou correu electrònic.
     */
    public void setCorreu(String correu) {
        this.correu = correu;
    }

    /**
     * Estableix el nombre d'associacions en les quals participa el membre.
     * 
     * @param numAssociacions El nou nombre d'associacions.
     */
    public void setNumAssociacions(int numAssociacions) {
        this.numAssociacions = numAssociacions;
    }

    
    public String toString() {
        return "Membres [dataAlta=" + dataAlta + ", dataBaixa=" + dataBaixa + ", graduat=" + graduat + ", aliesId="
                + aliesId + ", correu=" + correu + ", numAssociacions="+ numAssociacions + "]";
                
    }

    
}

