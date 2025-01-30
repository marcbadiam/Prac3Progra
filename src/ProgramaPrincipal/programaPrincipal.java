package ProgramaPrincipal;
import java.io.IOException;
import java.util.Scanner;

import classes.Accio;
import classes.Alumnes;
import classes.Associacio;
import classes.Data;
import classes.Demostracio;
import classes.Professors;
import classes.Xerrada;
import LlistesGestioFitxers.LlistaAccionsText;
import LlistesGestioFitxers.LlistaAssociacionsSerial;
import LlistesGestioFitxers.LlistaMembresText;
import classes.Membres;


public class programaPrincipal {
    ///
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }
    
    private static void mostrarMenu(){
        int opcio;
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
    
            switch (opcio) {
                case 1:
                    System.out.println("\nHeu escollit:");
                    System.out.println("1.Mostrar les dades de la llista d'associacions):\n\n");
                    LlistaAssociacionsSerial llistaCarregada1 = new LlistaAssociacionsSerial();
                    try {
                        llistaCarregada1.carregarAssociacions();
                        System.out.println(llistaCarregada1.toString());
                    } catch (IOException e) {
                        System.out.println("Error carregant les associacions: " + e.getMessage());
                    }

                    System.out.println(llistaCarregada1.toString());
                    break;
                case 2:
                System.out.println("\nHeu escollit:");
                System.out.println("2. Mostrar les dades de la llista de membres que formen part d’una associació (afegint filtre per a professors, alumnes o ambdós):\n");
                
                // Solicitar el nom de l'associació
                System.out.println("Digues el nom de la associacio: \n");
                String nomAssociacio = teclat.nextLine().trim();
                
                // Solicitar l'opció de filtratge
                System.out.println("Si vols mostrar nomes professors escriu 1, si vols mostrar nomes alumnes escriu 0 i si vols mostrar ambdós escriu -1:\n");
                int opcioMostrar = teclat.nextInt();
                
                // Crear i carregar la llista de membres
                LlistaMembresText llistaMembres2 = new LlistaMembresText();
                llistaMembres2.carregarMembres();
                
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
                } else if (opcioMostrar == -1) {
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
                System.out.println("Si vols mostrar nomes professors escriu 1, si vols mostrar nomes alumnes escriu 0 i si vols mostrar ambdós escriu -1:\n");
                int opcioMostrar1 = teclat.nextInt(); 
                
                // Crear i carregar la llista de membres
                LlistaMembresText llistaMembres3 = new LlistaMembresText();
                llistaMembres3.carregarMembres();
                
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
                } else if (opcioMostrar1 == -1) {
                    System.out.println("Llista de tots els membres:");
                    for (int i = 0; i < llistaMembres3.getNumMembres(); i++) {
                        Membres membre = llistaMembres3.getMembre(i);
                        System.out.println(llistaMembres3.getMembre(i)); // Mostrar tots els membre
                    }
                } else {
                    System.out.println("Opció no vàlida.");
                } 
                    break;
                case 4:
                    System.out.println("\nHeu escollit:");
                    System.out.println("4. Mostrar les dades de la llista d’accions (afegint filtre o no per tipus d’acció):\n");

                    // Solicitar l'opció de filtratge
                    System.out.println("Si vols mostrar només Xerrades, escriu 1. Si vols mostrar només Demostracions, escriu 0. Si vols mostrar ambdós, escriu -1:\n");
                    int opcioMostrar2 = teclat.nextInt();

                    // Crear i carregar la llista d'accions
                    LlistaAccionsText llistaAccions = new LlistaAccionsText();
                    llistaAccions.carregarAccions();

                    // Filtrar segons l'opció seleccionada
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
                    } else if (opcioMostrar2 == -1) {
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
                System.out.println("Si vols mostrar només Xerrades, escriu 1. Si vols mostrar només Demostracions, escriu 0. Si vols mostrar ambdós, escriu -1:\n");
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
                        } else if (opcioMostrar4 == -1) {
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

                    // Capturar les dades de l'associació
                    System.out.println("Nom de l'associació: ");
                    String nomAssociacio3 = scanner.nextLine();

                    System.out.println("Email de contacte: ");
                    String emailContacte = scanner.nextLine();

                    System.out.println("Introduir el president: ");
                    String president = scanner.nextLine();

                    System.out.println("Introduir el secretari: ");
                    String secretari = scanner.nextLine();

                    System.out.println("Introduir el tresorer: ");
                    String tresorer = scanner.nextLine();

                    System.out.println("Nombre d'accions: ");
                    int nombreAccions = scanner.nextInt();

                    
                    
                    break;
                case 8:
                    System.out.println("\nHeu escollit:");
                    System.out.println("8. Alta d’un membre a una associació:\n\n");
                    /*Es pot donar el cas que el membre sigui nou, i s’haurà d’introduir tota la informació del membre, o que el membre ja participi 
                    en una altra associació i en aquest cas serà afegir la relació corresponent */
                    //
                    break;
                case 9:
                    System.out.println("\nHeu escollit:");
                    System.out.println("9. Afegir una nova xerrada:\n\n");

                    System.out.println("Afegeix el codi:");
                    int codi = scanner.nextInt();
                    System.out.println("\nAfegeix el titol:");
                    String titol = scanner.next();
                    System.out.println("\nAfegeix el responsable:");
                    String responsable = scanner.next();
                    System.out.println("\nAfegeix el numero d'assistents:");
                    int nAssistents = scanner.nextInt();
                    System.out.println("\nAfegeix la valoracio:");
                    //int valora = scanner.nextInt();
                    //System.out.println("Afegeix l'associacio organitzadora:\n");
                    //String llistaAssociacions = scanner.next();
                    //Data dataXerrada = dataXerrada.Copia(null);
                    //Xerrada xerrada = xerrada.copia(titol, responsable, dataXerrada, nAssistents, valora, llistaAssociacions);
                    
                    //System.out.println(xerrada.toString());
                    System.out.println("Professors [alies=" + codi + "email institucional=" + titol + ", departament=" + responsable + ", despatx=" + nAssistents + "]");
            
                    break;
                case 10:
                    System.out.println("\nHeu escollit:");
                    System.out.println("10. Afegir una nova demostració:\n");
                    //
                    break;
                case 11:
                    System.out.println("\nHeu escollit:");
                    System.out.println("11. Consultar i mostrar les dades de les demostracions que es consideren no actives:\n");
                    /*Calcular el cost econòmic total que va suposar preparar totes aquestes demostracions */
                    //
                    break;
                case 12:
                    System.out.println("\nHeu escollit:");
                    System.out.println("12. Calcular la persona més activa (la que participa en més associacions):\n");
                    /*En cas d’empat es considera la que té més antiguitat (en qualsevol associació). Si encara hi ha empat, s’escull qualsevol de les persones que compleixen els requisits */
                    //
                    break;
                case 13:
                    System.out.println("\nHeu escollit:");
                    System.out.println("13. Consultar i mostrar les dades de les xerrades que ha tingut més d’un cert nombre indicat d’assistents:\n");
                    //
                    break;
                case 14:
                    System.out.println("\nHeu escollit:");
                    System.out.println("14. Valorar una xerrada per part d’un assistent:\n");
                    //
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
                    //
                    break;
                case 18:
                    System.out.println("\nHeu escollit:");
                    System.out.println("18. Sortir de l'aplicacio. Fins la propera!");
                    break;
                case 23: 
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("Comprovacio carregarPosicionsAssocciacio");

                    LlistaAssociacionsSerial llistaTestt = new LlistaAssociacionsSerial();
                    String[] titulacionsTestt1 = {"GEB", "GEI"};
                    String[] membresTestt1 = {"Membre1", "Membre2", "Membre3"};
                    Associacio assocTestt1 = new Associacio("AssociacióTest1", "test1@example.com", titulacionsTestt1, membresTestt1, "President1", "Secretari1", "Tresorer1", 3, 1);
                    String[] titulacionsTestt2 = {"GEB", "GESST"};
                    String[] membresTestt2 = {"Membre4", "Membre5", "Membre6"};
                    Associacio assocTestt2 = new Associacio("AssociacióTest2", "test2@example.com", titulacionsTestt2, membresTestt2, "President2", "Secretari2", "Tresorer2", 3, 4);
                    String[] titulacionsTestt3 = {"GEB", "GEI"};
                    String[] membresTestt3 = {"Membre7", "Membre8", "Membre9"};
                    Associacio assocTestt3 = new Associacio("AssociacióTest3", "test3@example.com", titulacionsTestt3, membresTestt3, "President3", "Secretari3", "Tresorer3", 3, 2);
                    String[] titulacionsTestt4 = {"GEB", "GESST"};
                    String[] membresTestt4 = {"Membre10", "Membre11", "Membre12"};
                    Associacio assocTestt4 = new Associacio("AssociacióTest4", "test4@example.com", titulacionsTestt4, membresTestt4, "President4", "Secretari4", "Tresorer4", 3, 3);

                    llistaTestt.afegirAssoc(assocTestt1);
                    llistaTestt.afegirAssoc(assocTestt2);
                    llistaTestt.afegirAssoc(assocTestt3);
                    llistaTestt.afegirAssoc(assocTestt4);
                    
                    System.out.println("Llista d'associacions després d'afegir:");
                    System.out.println(llistaTestt.toString());

                    try {
                        llistaTestt.guardarAssociacions();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    int[] posicionsTestt = {0, 3};
                    LlistaAssociacionsSerial llistaPos = new LlistaAssociacionsSerial();
                    llistaPos = llistaPos.carregarPosicionsAssociacions(posicionsTestt);
                    System.out.println(llistaPos.toString());




                    break;  
                case 24:
                    System.out.println("Mostrar associacions.bin");
                    LlistaAssociacionsSerial mostrar = new LlistaAssociacionsSerial();
                    try {
                        mostrar.carregarAssociacions();
                        System.out.println("Associacions carregades correctament.");
                    } catch (IOException e) {
                        System.out.println("Error carregant les associacions: " + e.getMessage());
                    }

                    System.out.println(mostrar.toString());
                    break;

                case 25:
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("25. Comprovació LlistaAssociacionsSerial!\n");

                    LlistaAssociacionsSerial llistaTest = new LlistaAssociacionsSerial();

                    String[] titulacionsTest1 = {"GEB", "GEI"};
                    String[] membresTest1 = {"Membre1", "Membre2", "Membre3"};
                    Associacio assocTest1 = new Associacio("AssociacióTest1", "test1@example.com", titulacionsTest1, membresTest1, "President1", "Secretari1", "Tresorer1", 3, 0);
                    String[] titulacionsTest2 = {"GEB", "GESST"};
                    String[] membresTest2 = {"Membre4", "Membre5", "Membre6"};
                    Associacio assocTest2 = new Associacio("AssociacióTest2", "test2@example.com", titulacionsTest2, membresTest2, "President2", "Secretari2", "Tresorer2", 3, 0);

                    llistaTest.afegirAssoc(assocTest1);
                    llistaTest.afegirAssoc(assocTest2);

                    System.out.println("Llista d'associacions després d'afegir:");
                    System.out.println(llistaTest.toString());

                    llistaTest.eliminarAssoc("AssociacióTest1");

                    System.out.println("Llista d'associacions després d'eliminar:");
                    System.out.println(llistaTest.toString());

                    try {
                        llistaTest.guardarAssociacions();
                        System.out.println("Associacions guardades correctament.");
                    } catch (IOException e) {
                        System.out.println("Error guardant les associacions: " + e.getMessage());
                    }

                    LlistaAssociacionsSerial llistaCarregadaTest = new LlistaAssociacionsSerial();
                    try {
                        llistaCarregadaTest.carregarAssociacions();
                        System.out.println("Associacions carregades correctament.");
                    } catch (IOException e) {
                        System.out.println("Error carregant les associacions: " + e.getMessage());
                    }

                    System.out.println("Llista d'associacions carregades:");
                    System.out.println(llistaCarregadaTest.toString());

                    if (llistaCarregadaTest.equals(llistaTest)) {
                        System.out.println("Les dues llistes són iguals i per tant la serialització ha funcionat correctament.");
                    } else {
                        System.out.println("Les dues llistes no són iguals i per tant la serialització no ha funcionat correctament.");
                    }
                    break;
                case 26:
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("26. Mostrar el contingut del fitxer creat en el case 25!\n");

                    LlistaAssociacionsSerial llistaCarregada26 = new LlistaAssociacionsSerial();
                    try {
                        llistaCarregada26.carregarAssociacions();
                        System.out.println("Associacions carregades correctament.");
                    } catch (IOException e) {
                        System.out.println("Error carregant les associacions: " + e.getMessage());
                    }

                    System.out.println("Llista d'associacions carregades:");
                    System.out.println(llistaCarregada26.toString());
                    break;
                case 30: //Faig llista d'accions
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("18. Comprovacio AccionsText!");
                    LlistaAssociacionsSerial llistaAssociacions51 = new LlistaAssociacionsSerial();
                    String[] titulacions51 = {"GEB", "GEI", "GESST"};
                    String[] membres51 = {"Membre1", "Membre2", "Membre3"};
                    Associacio associacio51 = new Associacio("Associació de Prova", "email@example.com", titulacions51, membres51, "President", "Secretari", "Tresorer", 3, 3);
                    llistaAssociacions51.afegirAssoc(associacio51);
                    
                    System.out.println("Arriba aqui! 185");
                    LlistaAccionsText llistaAccions3 = new LlistaAccionsText();
                    System.out.println("Arriba 529");
                    int[] pos1 = {1};
                    int[] pos2 = {2};
                    Data data1 = new Data(); 
                    short valor = 20;
                    //Accio accio1 = new Accio("Accio1", "Jaume", pos1);
                    //Accio accio2 = new Accio("Accio2", "Miquel", pos2);
                    Demostracio demo1 = new Demostracio("secretari", "titol", "responsable", 10, data1, true, valor , 100, pos2);
                    Xerrada xerra1 = new Xerrada("secretari", "titol", "responsable", 10, data1, valor , 100, pos1);
                    llistaAccions3.afegirAccio(demo1);

                    llistaAccions3.afegirAccio(xerra1);

                    //llistaAccions3.carregarAccions();
            
                    System.out.println("Detalls de la Llista d'Accions:");
                    System.out.println(llistaAccions3.toString());

                    // getters
                    System.out.println("\nProva dels getters:");
                    System.out.println("Nombre d'Accions: " + llistaAccions3.getNumAccions());
                    break;


                case 50:
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("50. Comprovació classe Xerrada:\n\n");
                
                   
                    /*LlistaAssociacions llistaAssociacions = new LlistaAssociacions();
                    String[] titulacions = {"GEB", "GEI", "GESST"};
                    String[] membres = {"Membre1", "Membre2", "Membre3"};
                    Associacio associacio = new Associacio("Associació de Prova", "email@example.com", titulacions, membres, "President", "Secretari", "Tresorer", 3, 0);
                    llistaAssociacions.afegirAssoc(associacio);
                    
                    
                    Data dataXerrada = new Data(); 
                    Xerrada xerrada1 = new Xerrada("Xerrada1", "Toni", dataXerrada, 50, (short) 5, llistaAssociacions);
                    Xerrada xerrada2 = new Xerrada("Xerrada2", "Albert", dataXerrada, 32, (short) 3, llistaAssociacions);
                    
                    System.out.println("Detalls de la Xerrada 1:");
                    System.out.println(xerrada1.toString());
                    System.out.println("Detalls de la Xerrada 2:");
                    System.out.println(xerrada2.toString());
                
                    // getters
                    System.out.println("\nProva dels getters:");
                    System.out.println("Data de la Xerrada: " + xerrada1.getDataXerrada());
                    System.out.println("Nombre d'Assistents: " + xerrada1.getNAssistents());
                    System.out.println("Valoracions: " + xerrada1.getValoracions());
                
                    // setters
                    System.out.println("\nProva dels setters:");
                    Data novaDataXerrada = new Data(); 
                    xerrada1.setDataXerrada(novaDataXerrada);
                    xerrada1.setNAssistents(100);
                    xerrada1.setValoracions((short) 4);
                
                    // Mostrar despres de setters
                    System.out.println("Detalls de la Xerrada després de modificar:");
                    System.out.println(xerrada1.toString());
                    break;*/
                case 51:/* 
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("51. Comprovació classe LlistaAccions:\n\n");

                    
                    LlistaAssociacions llistaAssociacions51 = new LlistaAssociacions();
                    String[] titulacions51 = {"GEB", "GEI", "GESST"};
                    String[] membres51 = {"Membre1", "Membre2", "Membre3"};
                    Associacio associacio51 = new Associacio("Associació de Prova", "email@example.com", titulacions51, membres51, "President", "Secretari", "Tresorer", 3, 0);
                    llistaAssociacions51.afegirAssoc(associacio51);
                   
                    LlistaAccions llistaAccions = new LlistaAccions();
                    Accio accio1 = new Accio("Accio1", "Jaume", llistaAssociacions51);
                    Accio accio2 = new Accio("Accio2", "Miquel", llistaAssociacions51);
                    llistaAccions.afegirAccio(accio1);
                    llistaAccions.afegirAccio(accio2);

                    
                    System.out.println("Detalls de la Llista d'Accions:");
                    System.out.println(llistaAccions.toString());

                    // getters
                    System.out.println("\nProva dels getters:");
                    System.out.println("Nombre d'Accions: " + llistaAccions.getNumAccions());
                    break;*/
/* 
                case 52:
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("51. Comprovació classe LlistaAssociacionsSerial:\n\n");

                
                    LlistaAssociacionsSerial llista = new LlistaAssociacionsSerial();

                    
                    String[] titulacions1 = {"GEB", "GEI"};
                    String[] membres1 = {"Membre1", "Membre2", "Membre3"};
                    Associacio assoc1 = new Associacio("Associació1", "pr1@example.com", titulacions1, membres1, "President1", "Secretari1", "Tresorer1", 3, 0);
                    String[] titulacions2 = {"GEB","GESST"};
                    String[] membres2 = {"Membre4", "Membre5", "Membre6"};
                    Associacio assoc2 = new Associacio("Associació2", "pr2@example.com", titulacions2, membres2, "President2", "Secretari2", "Tresorer2", 3, 0);
                    String[] titulacions3 = {"GEI", "GESST"};
                    String[] membres3 = {"Membre7", "Membre8", "Membre9"};
                    Associacio assoc3 = new Associacio("Associació3", "pr3@example.com", titulacions3, membres3, "President3", "Secretari3", "Tresorer3", 3, 0);


                   
                    llista.afegirAssoc(assoc1);
                    llista.afegirAssoc(assoc2);
                    llista.afegirAssoc(assoc3);

                    System.out.println(llista.toString());

                    llista.eliminarAssoc("Associació2");
                    
                    System.out.println("Numero d'elements actuals: " + llista.getNElem());
                    
                    System.out.println("Associacions actuals:");
                    System.out.println(llista.toString());

                    //part serialitzada

                    llista.guardarAssociacions();
                    
                    LlistaAssociacionsSerial llistaCarregada = new LlistaAssociacionsSerial();
                    llistaCarregada.carregarAssociacions();

                    System.out.println("Llista Associacions Carregades:");
                    System.out.println(llistaCarregada.toString());
                    
                    if(llistaCarregada.equals(llista))
                        System.out.println("Les dues llistes són iguals i per tant la serialització ha funcionat correctament");
                    else    
                        System.out.println("Les dues llistes no són iguals i per tant la serialització no ha funcionat correctament");
                    break;
*/
                case 60:
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("60. Comprovació professor/alumne:\n\n");
                    LlistaMembresText professorOAlumne = new LlistaMembresText();
                    professorOAlumne.carregarMembres();
                    professorOAlumne.toString();
                    System.out.println(professorOAlumne.toString());
                    break;

                default:
                    System.out.println("\nOpcio no valida. Intenta de nou\n");
                    break;
            }
        } while (opcio != 18);
    
    }
}




