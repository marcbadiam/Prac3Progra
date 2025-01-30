package ProgramaPrincipal;
import java.io.IOException;
import java.util.Scanner;

import Classes.Accio;
import Classes.Alumnes;
import Classes.Associacio;
import Classes.Data;
import Classes.Demostracio;
import Classes.Professors;
import Classes.Xerrada;
import LlistesGestioFitxers.LlistaAccionsText;
import LlistesGestioFitxers.LlistaAssociacionsSerial;
import LlistesGestioFitxers.LlistaMembresText;
import Classes.Membres;


public class programaPrincipal {
    ///
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }
    
    private static void mostrarMenu(){
        int opcio = -1;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("\nEscull una opcio del menu:");
            System.out.println("\nMenu d'opcions:");
            System.out.println("1. Mostrar les dades de la llista d'associacions:");
            System.out.println("2. Mostrar les dades de la llista de membres que formen part d’una associació (afegint filtre per a professors, alumnes o ambdós):");
            System.out.println("3. Mostrar les dades de la llista de membres actius, que formen part de qualsevol associació (afegint filtre per a professors, alumnes o ambdós):");
            System.out.println("4. Mostrar les dades de la llista d’accions (afegint filtre o no per tipus d’acció):");
            System.out.println("5. Obtenir i mostrar la llista d’accions que ofereix una associació concreta:");
            System.out.println("6. Obtenir i mostrar la llista de les xerrades que es duen a terme en una franja de dates indicada per teclat:");
            System.out.println("7. Afegir una nova associació:");
            System.out.println("8. Alta d’un membre a una associació:");
            System.out.println("9. Afegir una nova xerrada:");
            System.out.println("10. Afegir una nova demostració:");
            System.out.println("11. Consultar i mostrar les dades de les demostracions que es consideren no actives:");
            System.out.println("12. Calcular la persona més activa (la que participa en més associacions):");
            System.out.println("13. Consultar i mostrar les dades de les xerrades que ha tingut més d’un cert nombre indicat d’assistents:");
            System.out.println("14. Valorar una xerrada per part d’un assistent:");
            System.out.println("15. Consultar i mostrar la xerrada que està millor valorada:");
            System.out.println("16. Mostrar les dades de les xerrades que farà una persona concreta:");
            System.out.println("17. Donar de baixa les demostracions que no estiguin actives i que es van dissenyar abans d’una certa data:");
            System.out.println("18. Sortir de l'aplicacio:\n");
    
            opcio = Integer.parseInt(teclat.nextLine());
            LlistaAssociacionsSerial llistaBaseA = new LlistaAssociacionsSerial();
            try {
            llistaBaseA.carregarAssociacions();
            } catch (IOException e) {
            System.out.println("Error carregant les associacions: " + e.getMessage());
            }
            
            switch (opcio) {
                case 1:
                    System.out.println("\nHeu escollit:");
                    System.out.println("1.Mostrar les dades de la llista d'associacions):\n\n");
                    System.out.println(llistaBaseA.toString());  
                    break;
            
                case 2:
                    System.out.println("\nHeu escollit:");
                    System.out.println("2. Mostrar les dades de la llista de membres que formen part d’una associació (afegint filtre per a professors, alumnes o ambdós):\n");
                
                    // Solicitar el nom de l'associació
                    System.out.println("Digues el nom de a associacio: \n");
                    String nomAssociacio = teclat.nextLine().trim();
                
                    // Solicitar l'opció de filtratge
                    System.out.println("Si vols mostrar nomes professors escriu 1, si vols mostrar nomes alumnes escriu 0 i si vols mostrar ambdós escriu 2:\n");
                    int opcioMostrar = teclat.nextInt();
                
                    // Crear i carregar la llista de membres
                    LlistaMembresText llistaMembres2 = new LlistaMembresText();
                    llistaMembres2.carregarMembres(llistaBaseA);
                    
                    // Filtrar segons l'opció seleccionada
                    if (opcioMostrar == 1) {
                        System.out.println("Llista de professors:");
                        for (int i = 0; i < llistaMembres2.getNumMembres(); i++) {
                            Membres membre = llistaMembres2.getMembre(i);
                            if (membre instanceof Professors) { // Comprovar si és un professor
                                if (membre.esDAquestaAssociacio(nomAssociacio)) {
                                    System.out.println(membre); // Mostrar el professor que pertany a l'associació
                                }
                            }
                        }
                    } else if (opcioMostrar == 0) {
                        System.out.println("Llista d'alumnes:");
                        for (int i = 0; i < llistaMembres2.getNumMembres(); i++) {
                            Membres membre = llistaMembres2.getMembre(i);
                            if (membre instanceof Alumnes) { // Comprovar si és un alumne
                                if (membre.esDAquestaAssociacio(nomAssociacio)) {
                                    System.out.println(membre); // Mostrar l'alumne que pertany a l'associació
                                }
                            }
                        }
                    } else if (opcioMostrar == 2) {
                        System.out.println("Llista de tots els membres:");
                        for (int i = 0; i < llistaMembres2.getNumMembres(); i++) {
                            Membres membre = llistaMembres2.getMembre(i);
                            if (membre.esDAquestaAssociacio(nomAssociacio)) {
                            System.out.println(llistaMembres2.getMembre(i)); // Mostrar tots els membres
                            }
                        }
                    } else {
                        System.out.println("Opció no vàlida.");
                    }
                    break;
                
                case 3:
                    System.out.println("\nHeu escollit:");
                    System.out.println("3. Mostrar les dades de la llista de membres actius, que formen part de qualsevol associació (afegint filtre per a professors, alumnes o ambdós):\n");
                    
                    // Solicitar l'opció de filtratge
                    System.out.println("Si vols mostrar nomes professors escriu 1, si vols mostrar nomes alumnes escriu 0 i si vols mostrar ambdós escriu 2:\n");
                    int opcioMostrar1 = teclat.nextInt(); 
                    
                    // Crear i carregar la llista de membres
                    LlistaMembresText llistaMembres3 = new LlistaMembresText();
                    llistaMembres3.carregarMembres(llistaBaseA);
                    
                    // Filtrar segons l'opció seleccionada
                    if (opcioMostrar1 == 1) {
                        System.out.println("Llista de professors:");
                        for (int i = 0; i < llistaMembres3.getNumMembres(); i++) {
                            Membres membre = llistaMembres3.getMembre(i);
                            if (membre instanceof Professors) { // Comprovar si és un professor
                                System.out.println(membre); // Mostrar el professor     
                            }
                        }
                    } else if (opcioMostrar1 == 0) {
                        System.out.println("Llista d'alumnes:");
                        for (int i = 0; i < llistaMembres3.getNumMembres(); i++) {
                            Membres membre = llistaMembres3.getMembre(i);
                            if (membre instanceof Alumnes) { // Comprovar si és un alumne
                                System.out.println(membre); // Mostrar el membre 
                            }
                        }
                    } else if (opcioMostrar1 == 2) {
                        System.out.println("Llista de tots els membres:");
                        for (int i = 0; i < llistaMembres3.getNumMembres(); i++) {
                            Membres membre = llistaMembres3.getMembre(i);
                            System.out.println(membre); // Mostrar tots els membre
                        }
                    } else {
                        System.out.println("Opció no vàlida.");
                    } 
                    break;
                
                case 4:
                    System.out.println("\nHeu escollit:");
                    System.out.println("4. Mostrar les dades de la llista d’accions (afegint filtre o no per tipus d’acció):\n");

                    // Solicitar l'opció de filtratge
                    System.out.println("Si vols mostrar només Xerrades, escriu 1. Si vols mostrar només Demostracions, escriu 0. Si vols mostrar ambdós, escriu 2:\n");
                    int opcioMostrar2 = teclat.nextInt();

                    // Crear i carregar la llista d'accions
                    LlistaAccionsText llistaAccions = new LlistaAccionsText();
                    llistaAccions.carregarAccions();

                    // Filtrar segons l'opció seleccionada5
                    if (opcioMostrar2 == 1) {
                        System.out.println("Llista de Xerrades:");
                        for (int i = 0; i < llistaAccions.getNumAccions(); i++) {
                            Accio accio = llistaAccions.getAccio(i);
                            if (accio instanceof Xerrada) { // Comprovar si és una Xerrada
                                System.out.println(accio); // Mostrar la xerrada
                            }
                        }
                    } else if (opcioMostrar2 == 0) {
                        System.out.println("Llista de Demostracions:");
                        for (int i = 0; i < llistaAccions.getNumAccions(); i++) {
                            Accio accio = llistaAccions.getAccio(i);
                            if (accio instanceof Demostracio) { // Comprovar si és una Demostració
                                System.out.println(accio); // Mostrar la demostració
                            }
                        }
                    } else if (opcioMostrar2 == 2) {
                        System.out.println("Llista de totes les accions:");
                        for (int i = 0; i < llistaAccions.getNumAccions(); i++) {
                            System.out.println(llistaAccions.getAccio(i)); // Mostrar totes les accions
                        }
                    } else {
                        System.out.println("Opció no vàlida.");
                    }
                    break;
                
                case 5:
                    System.out.println("\nHeu escollit:");
                    System.out.println("5. Obtenir i mostrar la llista d’accions que ofereix una associació concreta:\n");
                    
                    // Sol·licitar el nom de l'associació
                    System.out.println("Introdueix el nom de l'associació: ");
                    String nomAssociacio1 = teclat.nextLine().trim();
                    
                    // Sol·licitar l'opció de filtratge
                    System.out.println("Si vols mostrar només Xerrades, escriu 1. Si vols mostrar només Demostracions, escriu 0. Si vols mostrar ambdós, escriu 2:\n");
                    int opcioMostrar4 = teclat.nextInt();
                    
                    // Crear i carregar la llista d'accions
                    LlistaAccionsText llistaAccions1 = new LlistaAccionsText();
                    llistaAccions1.carregarAccions();
                    
                    // Filtrar per nom d'associació i tipus d'acció
                    System.out.println("Accions disponibles per a l'associació \"" + nomAssociacio1 + "\":");
                    boolean accionsTrobades = false; // Per comprovar si hi ha resultats
                    
                    for (int i = 0; i < llistaAccions1.getNumAccions(); i++) {
                        Accio accio = llistaAccions1.getAccio(i);
                        
                        // Comprovar si l'acció pertany a l'associació
                        if (accio.esDAssociacio(nomAssociacio1)) { 
                            if (opcioMostrar4 == 1 && accio instanceof Xerrada) {
                                System.out.println(accio); // Mostrar només Xerrades
                                accionsTrobades = true;
                            } else if (opcioMostrar4 == 0 && accio instanceof Demostracio) {
                                System.out.println(accio); // Mostrar només Demostracions
                                accionsTrobades = true;
                            } else if (opcioMostrar4 == 2) {
                                System.out.println(accio); // Mostrar totes les accions
                                accionsTrobades = true;
                            }
                        }
                    }
                    
                    // Si no s'han trobat accions, mostrar un missatge
                    if (!accionsTrobades) {
                        System.out.println("No s'han trobat accions per a l'associació \"" + nomAssociacio1 + "\" amb el filtre seleccionat.");
                    }
                    break;

                case 6:
                    System.out.println("\nHeu escollit:");
                    System.out.println("6. Obtenir i mostrar la llista de les xerrades que es duen a terme en una franja de dates indicada per teclat:\n\n");

                    // Demanar les dates d'inici i final
                    System.out.println("Introdueix la data d'inici (format: dd mm aaaa):");
                    int diaInici = teclat.nextInt();
                    int mesInici = teclat.nextInt();
                    int anyInici = teclat.nextInt();
                    Data dataInici = new Data(diaInici, mesInici, anyInici);

                    System.out.println("Introdueix la data de finalització (format: dd mm aaaa):");
                    int diaFi = teclat.nextInt();
                    int mesFi = teclat.nextInt();
                    int anyFi = teclat.nextInt();
                    Data dataFi = new Data(diaFi, mesFi, anyFi);

                    // Crear i carregar la llista d'accions
                    LlistaAccionsText llistaAccions2 = new LlistaAccionsText();
                    llistaAccions2.carregarAccions();

                    // Verificar xerrades dins la franja de dates
                    System.out.println("Xerrades dins la franja de dates:");
                    for (int i = 0; i < llistaAccions2.getNumAccions(); i++) {
                        Accio accio = llistaAccions2.getAccio(i);
                        if (accio instanceof Xerrada) { 
                            Xerrada xerrada = (Xerrada) accio; 

                            Data dataXerrada = xerrada.getDataXerrada();

                            // Comprovem si la data de la xerrada està dins la franja
                            if (dataXerrada.esDataInferiorOigual(dataFi) && dataXerrada.esDataInferiorOigual(dataInici)) {
                                System.out.println(xerrada); // Mostrem la xerrada
                            }
                        }
                    }
                    break;

                case 7:
                    System.out.println("\nHeu escollit:");
                    System.out.println("7. Afegir una nova associació:\n\n");

                    System.out.println("Nom de l'associació: ");
                    String nomAssociacio2 = scanner.nextLine();

                    System.out.println("Email de contacte: ");
                    String emailContacte = scanner.nextLine();

                    
                    System.out.println("Quantes titulacions vols introduir(GEB, GEI, GESST, BioGEI, DG GEB-GESST, externETSE)?");
                    int numTitulacions = scanner.nextInt(); 
                    while (numTitulacions > 6  && numTitulacions < 1) {
                        System.out.println("Quantes titulacions vols introduir(GEB, GEI, GESST, BioGEI, DG GEB-GESST, externETSE)?");
                        numTitulacions = scanner.nextInt();
                    }
                    scanner.nextLine();  

                    String[] titulacions = new String[numTitulacions];
                    for (int i = 0; i < numTitulacions; i++) {
                        System.out.println("Introduïu la titulació " + (i + 1) + ": ");
                        titulacions[i] = scanner.nextLine();
                    }
                    
                    System.out.println("Quantes Membres vols introduir?");
                    int numMembres = scanner.nextInt();
                    scanner.nextLine();

                    String[] membres = new String[numMembres];
                    for (int i = 0; i < numMembres; i++) {
                        System.out.println("Introduïu el Membre " + (i + 1) + ": ");
                        membres[i] = scanner.nextLine();
                    }

                    System.out.println("Qui es el president: ");
                    String president = scanner.nextLine();

                    System.out.println("Qui es el secretari: ");
                    String secretari = scanner.nextLine();

                    System.out.println("Qui es el tresorer: ");
                    String tresorer = scanner.nextLine();

                    System.out.println("Nombre d'accions: ");
                    int nombreAccions = scanner.nextInt();
                    
                    Associacio associacioNova = new Associacio(nomAssociacio2, emailContacte, titulacions, membres, president, secretari, tresorer, numTitulacions, nombreAccions);
                    
                    llistaBaseA.afegirAssoc(associacioNova);
                    break;

                case 8:
                    System.out.println("\nHeu escollit:");
                    System.out.println("8. Alta d’un membre a una associació:\n\n");
                    System.out.println("Nom de l'associació: ");
                    String nomAs = scanner.nextLine();
                    System.out.println("Digues el nom del membre a afegir:");
                    String nom = scanner.nextLine();
                    
                    Associacio as = llistaBaseA.getAssociacioNom(nomAs);
                    if(as == null){
                        System.out.println("L'associacio no existeix");
                    }
                    else{
                        as.afegirMembre(nom);
                        System.out.println("Membre afegit correctament");
                    }

                    break;

                case 9:
                    System.out.println("\nHeu escollit:");
                    System.out.println("9. Afegir una nova xerrada:\n\n");
                    
                    System.out.println("\nAfegeix el titol:");
                    String titol = scanner.next();
                    System.out.println("\nAfegeix el responsable:");
                    String responsable = scanner.next();
                    System.out.println("\nAfegeix el numero d'assistents:");
                    int nAssistents = scanner.nextInt();
                    System.out.println("\nAfegeix la valoracio (una nota entre 1 i 10):");
                    short valoracions = scanner.nextShort();
                    System.out.println("\nAfegeix la data de la xerrada (dia mes any):");
                    int dia = scanner.nextInt();
                    int mes = scanner.nextInt();
                    int any = scanner.nextInt();
                    Data dataXerrada = new Data(dia, mes, any);
                    
                    System.out.println("\nAfegeix el cost:");
                    int cost = scanner.nextInt();
                    
                    // Posa el codi de les associacions de la xerrada
                    System.out.println("\nAfegeix les associacions organitzadores (usant indexes de les associacions disponibles):");
                    int[] posicionsAssociacions = new int[3]; // Depèn de la quantitat d'associacions
                    for (int i = 0; i < posicionsAssociacions.length; i++) {
                        posicionsAssociacions[i] = scanner.nextInt(); // Assigna la posició d'una associació
                    }

                    LlistaAccionsText llistaAccions4 = new LlistaAccionsText();

                    llistaAccions4.carregarAccions();

                    Xerrada xerradaAfegir = new Xerrada(titol, responsable, nAssistents, dataXerrada, valoracions, cost, posicionsAssociacions);
                    llistaAccions4.afegirAccio(xerradaAfegir);

                    System.out.println("Xerrada afegida correctament");
                    System.out.println(xerradaAfegir.toString()); // Això imprimeix totes les dades de la xerrada
            
                    break;

                case 10:
                    System.out.println("\nHeu escollit:");
                    System.out.println("10. Afegir una nova demostració:\n");
                    
                    System.out.println("\nAfegeix el titol:");
                    String titol1 = scanner.next();
                    System.out.println("\nAfegeix el responsable:");
                    String responsable1 = scanner.next();
                    System.out.println("\nAfegeix la data de disseny (dia mes any):");
                    int dia1 = scanner.nextInt();
                    int mes1 = scanner.nextInt();
                    int any1 = scanner.nextInt();
                    Data dataDisseny = new Data(dia1, mes1, any1);
                    
                    System.out.println("\nLa demostració és vàlida? (true/false):");
                    boolean valida = scanner.nextBoolean();
                    
                    System.out.println("\nAfegeix el nombre de vegades que s’ha ofert aquesta demostració:\n");
                    short nVegades = scanner.nextShort();
                    
                    System.out.println("\nAfegeix el cost de la demostració:");
                    int cost1 = scanner.nextInt();
                    
                    // Posa el codi de les associacions de la demostració
                    System.out.println("\nAfegeix les associacions organitzadores (usant indexes de les associacions disponibles):");
                    int[] posicionsAssociacions1 = new int[3]; // Depèn de la quantitat d'associacions
                    for (int i = 0; i < posicionsAssociacions1.length; i++) {
                        posicionsAssociacions1[i] = scanner.nextInt(); // Assigna la posició d'una associació
                    }
                    LlistaAccionsText llistaAccions5 = new LlistaAccionsText();
                    llistaAccions5.carregarAccions();

                    // Crear la nova instància de Demostracio
                    Demostracio demostracioAfegir = new Demostracio(titol1, responsable1, dataDisseny, valida, nVegades, cost1, posicionsAssociacions1);
                    llistaAccions5.afegirAccio(demostracioAfegir);
                    

                    System.out.println("Demostracio afegida correctament");
                    System.out.println(demostracioAfegir.toString()); // Això imprimeix totes les dades de la demostració 
                    
                    break;

                case 11:
                    System.out.println("\nHeu escollit:");
                    System.out.println("11. Consultar i mostrar les dades de les demostracions que es consideren no actives:\n");
                    LlistaAccionsText llistaAccions6 = new LlistaAccionsText();
                    llistaAccions6.carregarAccions();

                    for(int i = 0;i < llistaAccions6.getNElem();i++){
                        Accio accio  = llistaAccions6.getAccio(i);
                        if(accio instanceof Xerrada && !((Xerrada)accio).getValida()){
                            System.out.println(accio.toString());
                        }
                    }
                    break;

                case 12:
                    System.out.println("\nHeu escollit:");
                    System.out.println("12. Calcular la persona més activa (la que participa en més associacions):\n");
                    LlistaMembresText llistaMembres = new LlistaMembresText();
                    llistaMembres.carregarMembres(llistaBaseA);
                    Membres membreMesActiu;
                    membreMesActiu = llistaMembres.getMembre(0);
                    for(int i = 1; i < llistaMembres.getNumMembres(); i++){
                        Membres membreAux = llistaMembres.getMembre(i);
                        if(membreMesActiu.getNumAssociacions() < membreAux.getNumAssociacions()){
                            membreMesActiu = membreAux;
                        }
                    }
                    System.out.println("El membre mes actiu es: "+membreMesActiu.toString());
                    break;

                case 13:
                    System.out.println("\nHeu escollit:");
                    System.out.println("13. Consultar i mostrar les dades de les xerrades que ha tingut més d’un cert nombre indicat d’assistents:\n");
                    
                    System.out.println("Digues el nombre d’assistents minim");
                    int nAssistents2 = scanner.nextInt();
                    scanner.nextLine();

                    LlistaAccionsText llistaAccions7 = new LlistaAccionsText();
                    llistaAccions7.carregarAccions();

                    for(int i = 0;i < llistaAccions7.getNElem();i++){
                        Accio accio  = llistaAccions7.getAccio(i);
                        if(accio instanceof Xerrada && ((Xerrada)accio).getNAssistents() > nAssistents2){
                            System.out.println(accio.toString());
                        }
                    }
                    break;

                case 14:
                    System.out.println("\nHeu escollit:");
                    System.out.println("14. Valorar una xerrada per part d’un assistent:\n");
                    System.out.println("Digues el titol de la xerrada a valorar");
                    String titolX = scanner.nextLine();
                    System.out.println("Quia valoracio li vols ficar? (Numero 1-10)");
                    short valoracio = scanner.nextShort();

                    LlistaAccionsText llistaAccions8 = new LlistaAccionsText();
                    llistaAccions8.carregarAccions();
                    int j = 0;
                    boolean  trobat = false;
                    while(j < llistaAccions8.getNElem() && !trobat){
                        Accio accio  = llistaAccions8.getAccio(j);
                        if(accio instanceof Xerrada && ((Xerrada)accio).getTitol().equals(titolX)){
                            ((Xerrada)accio).setValoracions(valoracio);
                        }else{
                          j++;  
                        } 
                    }
                    
                    if(trobat){
                     System.out.println("Xerrada valorada correctament"); 
                    }else{
                        System.out.println("Xerrada no trobada");
                    }
                    
                    break;

                case 15:
                    System.out.println("\nHeu escollit:");
                    System.out.println("15. Consultar i mostrar la xerrada que està millor valorada:\n");
                    /*que serà la que té la mitjana de valoracions més alta), en cas d’empat en la nota, considerar la que ha tingut més valoracions i
                    en cas d’empat agafar qualsevol */
                    LlistaAccionsText accions = new LlistaAccionsText(); 
                    Xerrada xerradaMillor = null;
                    double mitjanaMillor = -1.0;
                    
                    accions.carregarAccions();

                    for(int i = 0; i < accions.getNElem(); i++){
                        Accio accio = accions.getAccio(i);
                        if (accio instanceof Xerrada) {
                            Xerrada xerradaActual = (Xerrada) accio;
                            double mitjanaActual = (double) xerradaActual.getValoracions() / xerradaActual.getNAssistents();
                            if (mitjanaActual > mitjanaMillor || (mitjanaActual == mitjanaMillor && xerradaActual.getValoracions() > xerradaMillor.getValoracions())) {
                            xerradaMillor = xerradaActual;
                            mitjanaMillor = mitjanaActual;
                        }   
                        } 
                    }
                    System.out.println("La millor xerrada ha estat: "+xerradaMillor+" I la seva mitjana ha estat: "+mitjanaMillor+"\n");
                    break;

                case 16:
                    System.out.println("\nHeu escollit:");
                    System.out.println("16. Mostrar les dades de les xerrades que farà una persona concreta:\n");

                    System.out.println("De qui vols cosultar la Xerrada:\n");
                    String aliesID = teclat.nextLine().trim();

                    LlistaAccionsText accions1 = new LlistaAccionsText();
                    accions1.carregarAccions();

                    LlistaAccionsText xerradesMembres = new LlistaAccionsText();
                    for (int i = 0; i < accions1.getNElem(); i++) {
                        Accio accio1 =accions1.getAccio(i);
                        if (accio1 instanceof Xerrada) {
                            Xerrada xerrada = (Xerrada) accio1;
                            if (xerrada.esMembre(aliesID)) {
                                xerradesMembres.afegirAccio(accio1);
                            }
                        }
                    }
                    System.out.println(xerradesMembres.toString());
                    break;

                case 17:
                    System.out.println("\nHeu escollit:");
                    System.out.println("17. Donar de baixa les demostracions que no estiguin actives i que es van dissenyar abans d’una certa data:\n");
                    
                    System.out.println("\nAfegeix la data de limit(dia mes any):");
                    int dia2 = scanner.nextInt();
                    int mes2 = scanner.nextInt();
                    int any2 = scanner.nextInt();
                    Data dataLimit = new Data(dia2, mes2, any2);

                    LlistaAccionsText llistaAccions9 = new LlistaAccionsText();
                    llistaAccions9.carregarAccions();
                    for(int i = 0;i < llistaAccions9.getNElem();i++){
                        Accio accio  = llistaAccions9.getAccio(i);
                        if(accio instanceof Xerrada && !((Xerrada)accio).getDataXerrada().esDataInferiorOigual(dataLimit)){
                            llistaAccions9.eliminarAccio(accio.getCodi());
                            System.out.println("Accio eliminada correctament");
                        }
                    }
                    break;

                case 18:
                    System.out.println("\nHeu escollit:");
                    System.out.println("18. Sortir de l'aplicacio. Fins la propera!");
                    break;
 
                default:
                    System.out.println("\nOpcio no valida. Intenta de nou\n");
                    scanner.close();
                    break;
            }
        } while (opcio != 18);
    
    }
}




