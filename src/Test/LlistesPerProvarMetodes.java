package Test;

import java.util.Scanner;

import Classes.Accio;
import Classes.Alumnes;
import Classes.Associacio;
import Classes.Data;
import Classes.Demostracio;
import Classes.Membres;
import Classes.Professors;
import Classes.Xerrada;
import LlistesGestioFitxers.LlistaAccionsText;
import LlistesGestioFitxers.LlistaAssociacionsSerial;
import LlistesGestioFitxers.LlistaMembresText;

public class LlistesPerProvarMetodes {

    static Scanner teclat = new Scanner(System.in);
    public static void main(String[] args) {    

        Scanner scanner = new Scanner(System.in);

        LlistaAccionsText llistaAccionsProv = new LlistaAccionsText();
        Accio accioP1 = new Xerrada ("Xerrada Intel·ligència Artificial", "Marc Badia", 50, new Data(15, 3, 2024), (short) 20, 100, new int[]{1, 2});
        Accio accioP2 = new Demostracio( "Demostració Robotica", "Pol Caballé", new Data(20, 4, 2024), true, (short) 15, 200, new int[]{3});
        Accio accioP3 = new Xerrada("Xerrada Big Data", "Yeray Zarza", 40, new Data(10, 5, 2024), (short) 25, 150, new int[]{2, 4});
        Accio accioP4 = new Demostracio("Demostració IoT", "Anna Pérez", new Data(12, 6, 2024), false, (short) 10, 120, new int[]{3});
        Accio accioP5 = new Xerrada("Xerrada Cloud Computing", "Joan Gómez", 60, new Data(8, 7, 2024), (short) 30, 200, new int[]{3});
        llistaAccionsProv.afegirAccio(accioP1);
        llistaAccionsProv.afegirAccio(accioP2);
        llistaAccionsProv.afegirAccio(accioP3);
        llistaAccionsProv.afegirAccio(accioP4);
        llistaAccionsProv.afegirAccio(accioP5);
             
        // Crear una lista de asociaciones
         LlistaAssociacionsSerial llistaAssociacionsProv = new LlistaAssociacionsSerial();

        // Crear y afegir manualment algunes associacions
        Associacio assoc1 = new Associacio("As001", "contacte@cultural.org", new String[]{"GEB"},new String[]{"Membre1", "Membre2"},
            "Marc", "Nuria", "Descripció 1", 10, 100);

        Associacio assoc2 = new Associacio("As002", "contacte@esportiva.org",new String[]{"GEB"}, new String[]{"MembreA", "MembreB"},
            "Pol", "Joan", "Descripció 2", 15, 150);

        Associacio assoc3 = new Associacio("As003", "contacte@tecnologica.org",new String[]{"GEB"}, new String[]{"MembreX", "MembreY"},
            "Yeray", "Pepa", "Descripció 3", 20, 200);

        Associacio assoc4 = new Associacio("As004", "contacte@solidaria.org",new String[]{"GEB"}, new String[]{"MembreM", "MembreN"},
            "Gerard", "Albert", "Descripció 4", 25, 250);

        Associacio assoc5 = new Associacio("As005", "contacte@musical.org",new String[]{"GEB"}, new String[]{"MembreQ", "MembreP"},
            "Pep", "Marina", "Descripció 5", 30, 300);

        // Afegir associacions a la llista
        llistaAssociacionsProv.afegirAssoc(assoc1);
        llistaAssociacionsProv.afegirAssoc(assoc2);
        llistaAssociacionsProv.afegirAssoc(assoc3);
        llistaAssociacionsProv.afegirAssoc(assoc4);
        llistaAssociacionsProv.afegirAssoc(assoc5);
             
        // Crear la llista de membres
        LlistaMembresText llistaMembresProv = new LlistaMembresText();

        // Crear membres de prova
        Alumnes alumne1 = new Alumnes("Al001", "alumne1@example.com", false, new Data(1, 9, 2020), new Data(1, 9, 2024),"GEI",4,llistaAssociacionsProv, true);
        Alumnes alumne2 = new Alumnes("Al002", "alumne2@example.com", false, new Data(2, 9, 2020), new Data(2, 9, 2024),"GEI",3,llistaAssociacionsProv, false);
        Professors professor1 = new Professors("P001", "professor1@example.com", true, new Data(1, 9, 2010), new Data(1, 9, 2020),"GEI",10,llistaAssociacionsProv);
        Professors professor2 = new Professors("P002", "professor2@example.com", true, new Data(1, 9, 2015), new Data(1, 9, 2021),"GEI",5,llistaAssociacionsProv);
        Alumnes alumne3 = new Alumnes("Al003", "alumne3@example.com", false, new Data(3, 9, 2020), new Data(3, 9, 2024),"GEI",3,llistaAssociacionsProv, false);

        // Afegir membres a la llista
        llistaMembresProv.afegirMembre(alumne1);
        llistaMembresProv.afegirMembre(alumne2);
        llistaMembresProv.afegirMembre(professor1);
        llistaMembresProv.afegirMembre(professor2);
        llistaMembresProv.afegirMembre(alumne3);

        System.out.println("Quina opció vols provar? (81, 82, 83, 84, 85, 86, 87, 88)");
        int opcio = Integer.parseInt(teclat.nextLine());

        switch (opcio) {
            case 81:
                System.out.println("\nHeu escollit:");
                System.out.println("81. Mostrar les dades de la llista de membres que formen part d’una associació (afegint filtre per a professors, alumnes o ambdós):\n");
                        
                // Solicitar el nom de l'associació
                System.out.println("Digues el nom de la associacio: \n");
                String nomAssociacioProv = teclat.nextLine().trim();
                        
                // Solicitar l'opció de filtratge
                System.out.println("Si vols mostrar nomes professors escriu 1, si vols mostrar nomes alumnes escriu 0 i si vols mostrar ambdós escriu -1:\n");
                int opcioMostrarProv = teclat.nextInt();
                        
                // Filtrar segons l'opció seleccionada
                if (opcioMostrarProv == 1) {
                    System.out.println("Llista de professors:");
                    for (int i = 0; i < llistaMembresProv.getNumMembres(); i++) {
                        Membres membre = llistaMembresProv.getMembre(i);
                        if (membre instanceof Professors) { // Comprovar si és un professor
                            if (membre.esDAquestaAssociacio(nomAssociacioProv)) {
                                System.out.println(membre); // Mostrar el professor que pertany a l'associació
                            }
                        }
                    }
                } else if (opcioMostrarProv == 0) {
                    System.out.println("Llista d'alumnes:");
                    for (int i = 0; i < llistaMembresProv.getNumMembres(); i++) {
                        Membres membre = llistaMembresProv.getMembre(i);
                        if (membre instanceof Alumnes) { // Comprovar si és un alumne
                            if (membre.esDAquestaAssociacio(nomAssociacioProv)) {
                                System.out.println(membre); // Mostrar l'alumne que pertany a l'associació
                            }
                        }
                    }
                } else if (opcioMostrarProv == -1) {
                    System.out.println("Llista de tots els membres:");
                    for (int i = 0; i < llistaMembresProv.getNumMembres(); i++) {
                        Membres membre = llistaMembresProv.getMembre(i);
                        if (membre.esDAquestaAssociacio(nomAssociacioProv)) {
                            System.out.println(llistaMembresProv.getMembre(i)); // Mostrar tots els membres
                        }
                    }
                } else {
                    System.out.println("Opció no vàlida.");
                }
                break;
            case 82:
                System.out.println("\nHeu escollit:");
                System.out.println("82. Mostrar les dades de la llista de membres que formen part de qualsevol (afegint filtre per a professors, alumnes o ambdós):\n");
                        

                // Solicitar l'opció de filtratge
                System.out.println("Si vols mostrar nomes professors escriu 1, si vols mostrar nomes alumnes escriu 0 i si vols mostrar ambdós escriu -1:\n");
                int opcioMostrarProv3 = teclat.nextInt();
                        
                // Filtrar segons l'opció seleccionada
                if (opcioMostrarProv3 == 1) {
                    System.out.println("Llista de professors:");
                    for (int i = 0; i < llistaMembresProv.getNumMembres(); i++) {
                        Membres membre = llistaMembresProv.getMembre(i);
                        if (membre instanceof Professors)// Comprovar si és un professor
                                    System.out.println(membre); // Mostrar el professor que pertany a l'associació
                    }
                } else if (opcioMostrarProv3 == 0) {
                    System.out.println("Llista d'alumnes:");
                    for (int i = 0; i < llistaMembresProv.getNumMembres(); i++) {
                        Membres membre = llistaMembresProv.getMembre(i);
                        if (membre instanceof Alumnes)  // Comprovar si és un alumn
                            System.out.println(membre); // Mostrar l'alumne que pertany a l'associació    
                    }
                } else if (opcioMostrarProv3 == -1) {
                    System.out.println("Llista de tots els membres:");
                    for (int i = 0; i < llistaMembresProv.getNumMembres(); i++) {
                        Membres membre = llistaMembresProv.getMembre(i);
                        System.out.println(membre); // Mostrar tots els membres
                    }
                } else {
                    System.out.println("Opció no vàlida.");
                }
                break;
            case 83:
                System.out.println("\nHeu escollit:");
                System.out.println("83. Mostrar les dades de la llista d’accions (afegint filtre o no per tipus d’acció):\n");

                // Solicitar l'opció de filtratge
                System.out.println("Si vols mostrar només Xerrades, escriu 1. Si vols mostrar només Demostracions, escriu 0. Si vols mostrar ambdós, escriu -1:\n");
                int opcioMostrarProv2 = teclat.nextInt();

                // Filtrar segons l'opció seleccionada
                if (opcioMostrarProv2 == 1) {
                    System.out.println("Llista de Xerrades:");
                    for (int i = 0; i < llistaAccionsProv.getNumAccions(); i++) {
                        Accio accio = llistaAccionsProv.getAccio(i);
                        if (accio instanceof Xerrada) { // Comprovar si és una Xerrada
                            System.out.println(accio); // Mostrar la xerrada
                        }
                    }
                } else if (opcioMostrarProv2 == 0) {
                    System.out.println("Llista de Demostracions:");
                    for (int i = 0; i < llistaAccionsProv.getNumAccions(); i++) {
                        Accio accio = llistaAccionsProv.getAccio(i);
                        if (accio instanceof Demostracio) { // Comprovar si és una Demostració
                            System.out.println(accio); // Mostrar la demostració
                        }
                    }
                } else if (opcioMostrarProv2 == -1) {
                    System.out.println("Llista de totes les accions:");
                    for (int i = 0; i < llistaAccionsProv.getNumAccions(); i++) {
                        System.out.println(llistaAccionsProv.getAccio(i)); // Mostrar totes les accions
                    }
                } else {
                    System.out.println("Opció no vàlida.");
                }
                break;
            
            case 84:
                System.out.println("\nHeu escollit:");
                System.out.println("84. Obtenir i mostrar la llista d’accions que ofereix una associació concreta:\n");
                
                // Sol·licitar el nom de l'associació
                System.out.println("Introdueix el nom de l'associació: ");
                String nomAssociacioProv1 = teclat.nextLine().trim();
                
                // Sol·licitar l'opció de filtratge
                System.out.println("Si vols mostrar només Xerrades, escriu 1. Si vols mostrar només Demostracions, escriu 0. Si vols mostrar ambdós, escriu -1:\n");
                int opcioMostrarProv4 = teclat.nextInt();
                
                // Filtrar per nom d'associació i tipus d'acció
                System.out.println("Accions disponibles per a l'associació \"" + nomAssociacioProv1 + "\":");
                boolean accionsTrobades1 = false; // Per comprovar si hi ha resultats
                
                for (int i = 0; i < llistaAccionsProv.getNumAccions(); i++) {
                    Accio accio = llistaAccionsProv.getAccio(i);
                    
                    // Comprovar si l'acció pertany a l'associació
                    if (accio.esDAssociacio(nomAssociacioProv1)) { 
                        if (opcioMostrarProv4 == 1 && accio instanceof Xerrada) {
                            System.out.println(accio); // Mostrar només Xerrades
                            accionsTrobades1 = true;
                        } else if (opcioMostrarProv4 == 0 && accio instanceof Demostracio) {
                            System.out.println(accio); // Mostrar només Demostracions
                            accionsTrobades1 = true;
                        } else if (opcioMostrarProv4 == -1) {
                            System.out.println(accio); // Mostrar totes les accions
                            accionsTrobades1 = true;
                        }
                    }
                }
                
                // Si no s'han trobat accions, mostrar un missatge
                if (!accionsTrobades1) {
                    System.out.println("No s'han trobat accions per a l'associació \"" + nomAssociacioProv1 + "\" amb el filtre seleccionat.");
                }
                break;
            
            case 85:
                System.out.println("\nHeu escollit:");
                System.out.println("85. Obtenir i mostrar la llista de les xerrades que es duen a terme en una franja de dates indicada per teclat:\n\n");

                // Demanar les dates d'inici i final
                System.out.println("Introdueix la data d'inici (format: dd mm aaaa):");
                int diaIniciProv = teclat.nextInt();
                int mesIniciProv = teclat.nextInt();
                int anyIniciProv = teclat.nextInt();
                Data dataIniciProv = new Data(diaIniciProv, mesIniciProv, anyIniciProv);

                System.out.println("Introdueix la data de finalització (format: dd mm aaaa):");
                int diaFiProv = teclat.nextInt();
                int mesFiProv = teclat.nextInt();
                int anyFiProv = teclat.nextInt();
                Data dataFiProv = new Data(diaFiProv, mesFiProv, anyFiProv);


                // Verificar xerrades dins la franja de dates
                System.out.println("Xerrades dins la franja de dates:");
                for (int i = 0; i < llistaAccionsProv.getNumAccions(); i++) {
                    Accio accio = llistaAccionsProv.getAccio(i);
                    if (accio instanceof Xerrada) { 
                        Xerrada xerrada = (Xerrada) accio; 

                        Data dataXerradaProv = xerrada.getDataXerrada();

                        // Comprovem si la data de la xerrada està dins la franja
                        if (dataXerradaProv.esDataInferiorOigual(dataFiProv) && dataXerradaProv.esDataInferiorOigual(dataIniciProv)) {
                            System.out.println(xerrada); // Mostrem la xerrada
                        }
                    }
                }
                break;
            
            case 86:
                System.out.println("\nHeu escollit:");
                System.out.println("86. Afegir una nova associació:\n\n");

                System.out.println("Nom de l'associació: ");
                String nomAssociacioProv2 = scanner.nextLine();

                System.out.println("Email de contacte: ");
                String emailContacteProv = scanner.nextLine();

                
                System.out.println("Quantes titulacions vols introduir(GEB, GEI, GESST, BioGEI, DG GEB-GESST, externETSE)?");
                int numTitulacionsProv = scanner.nextInt(); 
                while (numTitulacionsProv > 6  && numTitulacionsProv < 1) {
                    System.out.println("Quantes titulacions vols introduir(GEB, GEI, GESST, BioGEI, DG GEB-GESST, externETSE)?");
                    numTitulacionsProv = scanner.nextInt();
                }
                scanner.nextLine();  

                String[] titulacionsProv = new String[numTitulacionsProv];
                for (int i = 0; i < numTitulacionsProv; i++) {
                    System.out.println("Introduïu la titulació " + (i + 1) + ": ");
                    titulacionsProv[i] = scanner.nextLine();
                }
                
                System.out.println("Quantes Membres vols introduir?");
                int numMembresProv = scanner.nextInt();
                scanner.nextLine();

                String[] membresProv = new String[numMembresProv];
                for (int i = 0; i < numMembresProv; i++) {
                    System.out.println("Introduïu el Membre " + (i + 1) + ": ");
                    membresProv[i] = scanner.nextLine();
                }

                System.out.println("Qui es el president: ");
                String presidentProv = scanner.nextLine();

                System.out.println("Qui es el secretari: ");
                String secretariProv = scanner.nextLine();

                System.out.println("Qui es el tresorer: ");
                String tresorerProv = scanner.nextLine();

                System.out.println("Nombre d'accions: ");
                int nombreAccionsProv = scanner.nextInt();
                
                Associacio associacioNovaProv = new Associacio(nomAssociacioProv2, emailContacteProv, titulacionsProv, membresProv, presidentProv, secretariProv, tresorerProv, numTitulacionsProv, nombreAccionsProv);
                
                llistaAssociacionsProv.afegirAssoc(associacioNovaProv);

                System.out.println("Associacio nova afegida correctament");
                break;
            
            case 87:
                System.out.println("\nHeu escollit:");
                System.out.println("87. Alta d’un membre a una associació:\n\n");
                System.out.println("Nom de l'associació: ");
                String nomAsProv = scanner.nextLine();
                System.out.println("Digues el nom del membre a afegir:");
                String nomProv = scanner.nextLine();
                
                Associacio asProv = llistaAssociacionsProv.getAssociacioNom(nomAsProv);
                if(asProv == null){
                    System.out.println("L'associacio no existeix");
                }
                else{
                    asProv.afegirMembre(nomProv);
                    System.out.println("Membre afegit correctament");
                }
                break;
            
            case 88:
                System.out.println("\nHeu escollit:");
                System.out.println("88. Afegir una nova xerrada:\n\n");
                
                System.out.println("\nAfegeix el titol:");
                String titolProv = scanner.next();
                System.out.println("\nAfegeix el responsable:");
                String responsableProv = scanner.next();
                System.out.println("\nAfegeix el numero d'assistents:");
                int nAssistentsProv = scanner.nextInt();
                System.out.println("\nAfegeix la valoracio (una nota entre 1 i 10):");
                short valoracionsProv = scanner.nextShort();
                System.out.println("\nAfegeix la data de la xerrada (dia mes any):");
                int diaProv = scanner.nextInt();
                int mesProv = scanner.nextInt();
                int anyProv = scanner.nextInt();
                Data dataXerradaProv = new Data(diaProv, mesProv, anyProv);
                
                System.out.println("\nAfegeix el cost:");
                int costProv = scanner.nextInt();
                
                // Posa el codi de les associacions de la xerrada
                System.out.println("\nAfegeix les associacions organitzadores (usant indexes de les associacions disponibles):");
                int[] posicionsAssociacionsProv = new int[3]; // Depèn de la quantitat d'associacions
                for (int i = 0; i < posicionsAssociacionsProv.length; i++) {
                    posicionsAssociacionsProv[i] = scanner.nextInt(); // Assigna la posició d'una associació
                }

                Xerrada xerradaProvAfegir = new Xerrada(titolProv, responsableProv, nAssistentsProv, dataXerradaProv, valoracionsProv, costProv, posicionsAssociacionsProv);
                llistaAccionsProv.afegirAccio(xerradaProvAfegir);

                System.out.println("Xerrada afegida correctament");
                System.out.println(xerradaProvAfegir.toString()); // Això imprimeix totes les dades de la xerrada
                break;

            case 89:
                System.out.println("\nHeu escollit:");
                System.out.println("89. Afegir una nova demostració:\n");
                
                System.out.println("\nAfegeix el titol:");
                String titol1Prov = scanner.next();
                System.out.println("\nAfegeix el responsable:");
                String responsable1Prov = scanner.next();
                System.out.println("\nAfegeix la data de disseny (dia mes any):");
                int dia1Prov = scanner.nextInt();
                int mes1Prov = scanner.nextInt();
                int any1Prov = scanner.nextInt();
                Data dataDissenyProv = new Data(dia1Prov, mes1Prov, any1Prov);
                
                System.out.println("\nLa demostració és vàlida? (true/false):");
                boolean validaProv = scanner.nextBoolean();
                
                System.out.println("\nAfegeix el nombre de vegades que s’ha ofert aquesta demostració:\n");
                short nVegadesProv = scanner.nextShort();
                
                System.out.println("\nAfegeix el cost de la demostració:");
                int cost1Prov = scanner.nextInt();
                
                // Posa el codi de les associacions de la demostració
                System.out.println("\nAfegeix les associacions organitzadores (usant indexes de les associacions disponibles):");
                int[] posicionsAssociacions1Prov = new int[3]; // Depèn de la quantitat d'associacions
                for (int i = 0; i < posicionsAssociacions1Prov.length; i++) {
                    posicionsAssociacions1Prov[i] = scanner.nextInt(); // Assigna la posició d'una associació
                }

                // Crear la nova instància de Demostracio
                Demostracio demostracioAfegirProv = new Demostracio(titol1Prov, responsable1Prov, dataDissenyProv, validaProv, nVegadesProv, cost1Prov, posicionsAssociacions1Prov);
                llistaAccionsProv.afegirAccio(demostracioAfegirProv);
                

                System.out.println("Demostracio afegida correctament");
                System.out.println(demostracioAfegirProv.toString()); // Això imprimeix totes les dades de la demostració 
                break;

            case 90:
                System.out.println("\nHeu escollit:");
                System.out.println("11. Consultar i mostrar les dades de les demostracions que es consideren no actives:\n");

                for(int i = 0;i < llistaAccionsProv.getNElem();i++){
                    Accio accio  = llistaAccionsProv.getAccio(i);
                    if(accio instanceof Xerrada && !((Xerrada)accio).getValida()){
                        System.out.println(accio.toString());
                    }
                }
                break;

            case 91:
                System.out.println("\nHeu escollit:");
                System.out.println("12. Calcular la persona més activa (la que participa en més associacions):\n");
                Membres membreMesActiuProv;
                membreMesActiuProv = llistaMembresProv.getMembre(0);
                for(int i = 1; i < llistaMembresProv.getNumMembres(); i++){
                    Membres membreAuxProv = llistaMembresProv.getMembre(i);
                    if(membreMesActiuProv.getNumAssociacions() < membreAuxProv.getNumAssociacions()){
                        membreMesActiuProv = membreAuxProv;
                    }
                }
                System.out.println("El membre mes actiu es: "+membreMesActiuProv.toString());
                break;

            case 92:
                System.out.println("\nHeu escollit:");
                System.out.println("13. Consultar i mostrar les dades de les xerrades que ha tingut més d’un cert nombre indicat d’assistents:\n");
                
                System.out.println("Digues el nombre d’assistents minim");
                int nAssistentsProv2 = scanner.nextInt();
                scanner.nextLine();

                for(int i = 0;i < llistaAccionsProv.getNElem();i++){
                    Accio accioProv  = llistaAccionsProv.getAccio(i);
                    if(accioProv instanceof Xerrada && ((Xerrada)accioProv).getNAssistents() > nAssistentsProv2){
                        System.out.println(accioProv.toString());
                    }
                }
                break;

            case 93:
                System.out.println("\nHeu escollit:");
                System.out.println("14. Valorar una xerrada per part d’un assistent:\n");
                System.out.println("Digues el titol de la xerrada a valorar");
                String titolXProv = scanner.nextLine();
                System.out.println("Quia valoracio li vols ficar? (Numero 1-10)");
                short valoracioProv = scanner.nextShort();

                int jProv = 0;
                boolean  trobatProv = false;
                while(jProv < llistaAccionsProv.getNElem() && !trobatProv){
                    Accio accioProv  = llistaAccionsProv.getAccio(jProv);
                    if(accioProv instanceof Xerrada && ((Xerrada)accioProv).getTitol().equals(titolXProv)){
                        ((Xerrada)accioProv).setValoracions(valoracioProv);
                    }else{
                    jProv++;  
                    } 
                }
                
                if(trobatProv){
                System.out.println("Xerrada valorada correctament"); 
                }else{
                    System.out.println("Xerrada no trobada");
                }
                
                break;

            case 94:
                System.out.println("\nHeu escollit:");
                System.out.println("15. Consultar i mostrar la xerrada que està millor valorada:\n");
                /*que serà la que té la mitjana de valoracions més alta), en cas d’empat en la nota, considerar la que ha tingut més valoracions i
                en cas d’empat agafar qualsevol */
                Xerrada xerradaMillorProv = null;
                double mitjanaMillorProv = -1.0;

                for(int i = 0; i < llistaAccionsProv.getNElem(); i++){
                    Accio accioProv = llistaAccionsProv.getAccio(i);
                    if (accioProv instanceof Xerrada) {
                        Xerrada xerradaActualProv = (Xerrada) accioProv;
                        double mitjanaActualProv = (double) xerradaActualProv.getValoracions() / xerradaActualProv.getNAssistents();
                        if (mitjanaActualProv > mitjanaMillorProv || (mitjanaActualProv == mitjanaMillorProv && xerradaActualProv.getValoracions() > xerradaMillorProv.getValoracions())) {
                        xerradaMillorProv = xerradaActualProv;
                        mitjanaMillorProv = mitjanaActualProv;
                    }   
                    } 
                }
                System.out.println("La millor xerrada ha estat: "+xerradaMillorProv+" I la seva mitjana ha estat: "+mitjanaMillorProv+"\n");
                break;

            case 95:
                System.out.println("\nHeu escollit:");
                System.out.println("16. Mostrar les dades de les xerrades que farà una persona concreta:\n");

                System.out.println("De qui vols cosultar la Xerrada:\n");
                String aliesIDProv = teclat.nextLine().trim();

                LlistaAccionsText xerradesMembresProv = new LlistaAccionsText();
                for (int i = 0; i < llistaAccionsProv.getNElem(); i++) {
                    Accio accio1Prov = llistaAccionsProv.getAccio(i);
                    if (accio1Prov instanceof Xerrada) {
                        Xerrada xerradaProv = (Xerrada) accio1Prov;
                        if (xerradaProv.esMembre(aliesIDProv)) {
                            xerradesMembresProv.afegirAccio(accio1Prov);
                        }
                    }
                }
                System.out.println(xerradesMembresProv.toString());
                break;

            case 96:
                System.out.println("\nHeu escollit:");
                System.out.println("17. Donar de baixa les demostracions que no estiguin actives i que es van dissenyar abans d’una certa data:\n");
                
                System.out.println("\nAfegeix la data de limit(dia mes any):");
                int dia2Prov = scanner.nextInt();
                int mes2Prov = scanner.nextInt();
                int any2Prov = scanner.nextInt();
                Data dataLimitProv = new Data(dia2Prov, mes2Prov, any2Prov);

                for(int i = 0;i < llistaAccionsProv.getNElem();i++){
                    Accio accio  = llistaAccionsProv.getAccio(i);
                    if(accio instanceof Xerrada && !((Xerrada)accio).getDataXerrada().esDataInferiorOigual(dataLimitProv)){
                        llistaAccionsProv.eliminarAccio(accio.getCodi());
                        System.out.println("Accio eliminada correctament");
                    }
                }
                break;
            default:
                System.out.println("Opció no vàlida.");
                scanner.close();
                teclat.close();
                break;  
            }
    }

}
