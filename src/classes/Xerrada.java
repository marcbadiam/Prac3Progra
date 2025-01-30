package classes;

import java.time.LocalDate;

/**
 * Classe que representa una xerrada.
 * 
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

    public Xerrada(String c, String t, String r, int nAssistents, Data d, short valoracions, int cost, int[] posicionsAssociacions) {
        super(t, r, posicionsAssociacions);
        this.nAssistents = nAssistents;
        this.valoracions = valoracions;
        this.posicionsAssociacions = posicionsAssociacions;
        this.dataXerrada = d;
        this.cost = cost;
        this.valida = esValida(); // Decideix si és vàlida segons la data
    }

    public boolean esValida() {
        boolean valida;

        LocalDate dataActual = LocalDate.now();
        Data dataA = new Data(dataActual.getDayOfMonth(), dataActual.getMonthValue(), dataActual.getYear());
        
        if (dataA.esDataInferiorOigual(dataXerrada))
            valida = true;
        else
            valida = false;
        return valida;
    }

    public void setNMembres(short n) {
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

    public Xerrada copia() {
        return new Xerrada(
            this.codi, this.titol, this.responsable, 
            this.nAssistents, this.dataXerrada, this.valoracions, this.cost, this.posicionsAssociacions
        );
    }

    public boolean esMembre(String aliesId) {
        for (int i = 0; i < nMembres; i++) {
            if (membres[i] != null && membres[i].getAliesId().equals(aliesId)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Xerrada [codi=" + codi 
            + ", titol=" + titol 
            + ", responsable=" + responsable
            + ", dataXerrada=" + dataXerrada
            + ", nAssistents=" + nAssistents 
            + ", valoracions=" + valoracions
            + ", valida=" + valida + ", Super=" + super.toString() +"]";
    }
}
