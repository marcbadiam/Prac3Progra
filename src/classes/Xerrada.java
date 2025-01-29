package Classes;


/**
 * @author Marc Badia
 */

public class Xerrada extends Accio {
    
    private static short nMembres = 3;
    private Data dataXerrada;
    private int nAssistents;
    private short valoracions;
    private boolean valida;
    Membres[] membres = new Membres[nMembres];
    private int[] posicionsAssociacions;
    private int cost;

    public Xerrada(String c, String t, String r, int nAssistents, Data d, boolean valida, short valoracions, int cost, int[] posicionsAssociacions) {
        super(t, r, posicionsAssociacions);
        this.nAssistents = nAssistents;
        this.valoracions = valoracions;
        this.posicionsAssociacions = posicionsAssociacions;
        this.valida = valida;
    }

    public void setNMembres (short n) {
        nMembres = n;
    }

    public Data getDataXerrada() {
        return dataXerrada;
    }

    public void setDataXerrada(Data dataXerrada) {
        this.dataXerrada = dataXerrada;
    }

    public int getNAssistents() {
        return nAssistents;
    }

    public void setNAssistents(int nAssistents) {
        this.nAssistents = nAssistents;
    }
    
    public int getValoracions() {
        return valoracions;
    }

    public void setValoracions(short valoracions) {
        this.valoracions = valoracions;
    }

    public Xerrada copia(){
        Xerrada copiaXerrada = new Xerrada(
            this.codi, this.titol, this.responsable, 
            this.nAssistents, this.dataXerrada, this.valida, this.valoracions, this.cost, this.posicionsAssociacions);
        return copiaXerrada;
    }

    public boolean esMembre(String aliesId){
        boolean esMembre = false;
        for(int i = 0; i < nMembres -1; i++){
            if(membres[i].getAliesId().equals(aliesId)){
                esMembre =  true;
            }
        }
        return esMembre;
    }

    public String toString() {
        return "Xerrada [codi=" + codi 
        + ", titol=" + titol 
        + ", responsable=" + responsable
        + ", dataXerrada=" + dataXerrada
        + ", nAssistents=" + nAssistents 
        + ", valoracions=" + valoracions + super.toString() +"]";
    }
    
}
