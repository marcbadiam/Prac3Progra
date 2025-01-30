package LlistesGestioFitxers;
/**
 * @author Pol Caballé
 */
import java.io.IOException;

import Classes.Alumnes;
import Classes.Associacio;
import Classes.Professors;
import Classes.Xerrada;
import Classes.Data;
import Classes.Demostracio;

public class OmplirFitxers {
    
    public void OmplirAccions() {
    LlistaAccionsText llAccions = new LlistaAccionsText();
    
    // Datos de ejemplo para la fecha
    Data dataXerradaPasada = new Data(2024, 10, 10);
    Data dataXerradaPendent = new Data(2025, 10, 10);
    Data dataDisseny = new Data(2023, 5, 20);
    
    Xerrada xerrada1 = new Xerrada("Xerrada 1", "Responsable1", 3, dataXerradaPasada, (short) 10, 15, new int[]{0});
    Xerrada xerrada2 = new Xerrada("Xerrada 2", "Responsable2", 3, dataXerradaPendent, (short) 10, 16, new int[]{1});
    Xerrada xerrada3 = new Xerrada("Xerrada 3", "Responsable3", 3, dataXerradaPendent, (short) 10, 17, new int[]{2,3});
    Xerrada xerrada4 = new Xerrada("Xerrada 4", "Responsable4", 3, dataXerradaPasada, (short) 10, 18, new int[]{3});
    Demostracio demostracio1 = new Demostracio("Demostracio 1", "Responsable5", dataDisseny, true, (short) 5, 20, new int[]{0,1});
    Demostracio demostracio2 = new Demostracio("Demostracio 2", "Responsable6", dataDisseny, true, (short) 3, 25, new int[]{2});
    Demostracio demostracio3 = new Demostracio("Demostracio 3", "Responsable7", dataDisseny, false, (short) 4, 30, new int[]{3,4});
    Demostracio demostracio4 = new Demostracio("Demostracio 4", "Responsable8", dataDisseny, true, (short) 2, 18, new int[]{5});
    
    // Añadir las acciones a la lista
    llAccions.afegirAccio(xerrada1);
    llAccions.afegirAccio(xerrada2);
    llAccions.afegirAccio(xerrada3);
    llAccions.afegirAccio(xerrada4);
    llAccions.afegirAccio(demostracio1);
    llAccions.afegirAccio(demostracio2);
    llAccions.afegirAccio(demostracio3);
    llAccions.afegirAccio(demostracio4);
    
    llAccions.guardarAccions();
}

    public void OmplirAssociacions(){
        LlistaAssociacionsSerial llAssoc = new LlistaAssociacionsSerial();
    
        String[] titulacionsAssoc1 = {"GEB", "GEI"};
        String[] membresAssoc1 = {"Membre1", "Membre2", "Membre3"};
        Associacio assoc1 = new Associacio("AssociacióTest1", "test1@example.com", titulacionsAssoc1, membresAssoc1, "President1", "Secretari1", "Tresorer1", 3, 8);
    
        String[] titulacionsAssoc2 = {"GESST", "BioGEI"};
        String[] membresAssoc2 = {"Membre4", "Membre5", "Membre6"};
        Associacio assoc2 = new Associacio("AssociacióTest2", "test2@example.com", titulacionsAssoc2, membresAssoc2, "President2", "Secretari2", "Tresorer2", 3, 6);
        
        String[] titulacionsAssoc3 = {"DG GEB-GESST", "GEB"};
        String[] membresAssoc3 = {"Membre7", "Membre8", "Membre9"};
        Associacio assoc3 = new Associacio("AssociacióTest3", "test3@example.com", titulacionsAssoc3, membresAssoc3, "President3", "Secretari3", "Tresorer3", 3, 9);
    
        String[] titulacionsAssoc4 = {"GEI", "GESST"};
        String[] membresAssoc4 = {"Membre10", "Membre11", "Membre12"};
        Associacio assoc4 = new Associacio("AssociacióTest4", "test4@example.com", titulacionsAssoc4, membresAssoc4, "President4", "Secretari4", "Tresorer4", 3, 8);
    
        String[] titulacionsAssoc5 = {"BioGEI", "DG GEB-GESST"};
        String[] membresAssoc5 = {"Membre13", "Membre14", "Membre15"};
        Associacio assoc5 = new Associacio("AssociacióTest5", "test5@example.com", titulacionsAssoc5, membresAssoc5, "President5", "Secretari5", "Tresorer5", 3, 7);
    
        String[] titulacionsAssoc6 = {"GEB", "BioGEI"};
        String[] membresAssoc6 = {"Membre16", "Membre17", "Membre18"};
        Associacio assoc6 = new Associacio("AssociacióTest6", "test6@example.com", titulacionsAssoc6, membresAssoc6, "President6", "Secretari6", "Tresorer6", 3, 10);
    
        String[] titulacionsAssoc7 = {"GEI", "GEB"};
        String[] membresAssoc7 = {"Membre19", "Membre20", "Membre21"};
        Associacio assoc7 = new Associacio("AssociacióTest7", "test7@example.com", titulacionsAssoc7, membresAssoc7, "President7", "Secretari7", "Tresorer7", 3, 7);
    
        llAssoc.afegirAssoc(assoc1);
        llAssoc.afegirAssoc(assoc2);
        llAssoc.afegirAssoc(assoc3);
        llAssoc.afegirAssoc(assoc4);
        llAssoc.afegirAssoc(assoc5);
        llAssoc.afegirAssoc(assoc6);
        llAssoc.afegirAssoc(assoc7);

        try {
            llAssoc.guardarAssociacions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OmplirMembres() {
        LlistaMembresText llMemb = new LlistaMembresText();

        // Datos de ejemplo para la fecha de alta y baja
        Data dataAlta = new Data(2023, 9, 1);
        Data dataBaixa = null; // Null indica que aún está activo
        LlistaAssociacionsSerial llistaAssociacions = new LlistaAssociacionsSerial();
        try {
            llistaAssociacions.carregarAssociacions();
            System.out.println("Associacions carregades correctament.");
        } catch (IOException e) {
            System.out.println("Error carregant les associacions: " + e.getMessage());
        }

        // Creación de alumnos
        Alumnes alumne1 = new Alumnes("NY01", "nuria.yepes@estudiants.urv.cat",false, dataAlta, dataBaixa, "GEI", 3,llistaAssociacions, false);
        Alumnes alumne2 = new Alumnes("PC01", "pol.caballe@estudiants.urv.cat",false, dataAlta, dataBaixa, "GEI", 4, llistaAssociacions, true);
        Alumnes alumne3 = new Alumnes("YZ01", "yeray.zarza@estudiants.urv.cat",false, dataAlta, dataBaixa, "GEI", 3, llistaAssociacions, false);
        Alumnes alumne4 = new Alumnes("MB01", "marc.badia@estudiants.urv.cat",false, dataAlta, dataBaixa, "GEI", 3, llistaAssociacions, false);
        Alumnes alumne5 = new Alumnes("AB02", "anna.blanc@estudiants.urv.cat",false, dataAlta, dataBaixa, "GEB", 2, llistaAssociacions, false);
        Alumnes alumne6 = new Alumnes("EV05", "eva.vila@estudiants.urv.cat",false, dataAlta, dataBaixa, "GESST", 4, llistaAssociacions, true);
        Alumnes alumne7 = new Alumnes("JS07", "joan.soler@estudiants.urv.cat",false, dataAlta, dataBaixa, "BioGEI", 1, llistaAssociacions, false);
        Alumnes alumne8 = new Alumnes("LP08", "laura.perez@estudiants.urv.cat",false, dataAlta, dataBaixa, "GEB", 5, llistaAssociacions,true);
        Alumnes alumne9 = new Alumnes("CM09", "carles.marti@estudiants.urv.cat",false, dataAlta, dataBaixa, "DG GEB-GESST", 3, llistaAssociacions, false);
        Alumnes alumne10 = new Alumnes("TF10", "toni.font@estudiants.urv.cat",false, dataAlta, dataBaixa, "GEI", 2, llistaAssociacions, false);
        
        // Creación de profesores
        Professors profe1 = new Professors("JC03", "joan.capdevila@urv.cat",true, dataAlta, dataBaixa, "DEIM", 133, llistaAssociacions);
        Professors profe2 = new Professors("MG16", "marta.garcia@urv.cat",true, dataAlta, dataBaixa, "DEEEA", 245, llistaAssociacions);
        Professors profe3 = new Professors("JP02", "josep.perez@urv.cat",true, dataAlta, dataBaixa, "DEIM", 143, llistaAssociacions);
        Professors profe4 = new Professors("AS11", "anna.sanchez@urv.cat",true, dataAlta, dataBaixa, "DEIM", 122, llistaAssociacions);
        Professors profe5 = new Professors("RG12", "roger.gomez@urv.cat",true, dataAlta, dataBaixa, "DEEEA", 215, llistaAssociacions);
        Professors profe6 = new Professors("VM13", "victor.molina@urv.cat",true, dataAlta, dataBaixa, "DEIM", 107, llistaAssociacions);
        Professors profe7 = new Professors("EP14", "eva.pardo@urv.cat",true, dataAlta, dataBaixa, "DEEEA", 198, llistaAssociacions);
        Professors profe8 = new Professors("FB15", "francesc.bosch@urv.cat",true, dataAlta, dataBaixa, "DEIM", 156, llistaAssociacions);
        Professors profe9 = new Professors("GC17", "gemma.casas@urv.cat",true, dataAlta, dataBaixa, "DEEEA", 276, llistaAssociacions);
        Professors profe10 = new Professors("DR18", "david.rodriguez@urv.cat",true, dataAlta, dataBaixa, "DEIM", 199, llistaAssociacions);
        
        // Agregar alumnos a la lista
        llMemb.afegirMembre(alumne1);
        llMemb.afegirMembre(alumne2);
        llMemb.afegirMembre(alumne3);
        llMemb.afegirMembre(alumne4);
        llMemb.afegirMembre(alumne5);
        llMemb.afegirMembre(alumne6);
        llMemb.afegirMembre(alumne7);
        llMemb.afegirMembre(alumne8);
        llMemb.afegirMembre(alumne9);
        llMemb.afegirMembre(alumne10);
        
        // Agregar profesores a la lista
        llMemb.afegirMembre(profe1);
        llMemb.afegirMembre(profe2);
        llMemb.afegirMembre(profe3);
        llMemb.afegirMembre(profe4);
        llMemb.afegirMembre(profe5);
        llMemb.afegirMembre(profe6);
        llMemb.afegirMembre(profe7);
        llMemb.afegirMembre(profe8);
        llMemb.afegirMembre(profe9);
        llMemb.afegirMembre(profe10);

        // Guardar la lista de miembros
        
        llMemb.guardarMembres();
    }
}