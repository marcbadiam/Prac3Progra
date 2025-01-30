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
            
            
            
            
            /**
             * LListes per probar metodes
             */
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
             Alumnes alumne1 = new Alumnes("Al001", "alumne1@example.com", false, new Data(1, 9, 2020), new Data(1, 9, 2024),"GEI",4,llistaAssociacionsProv);
             Alumnes alumne2 = new Alumnes("Al002", "alumne2@example.com", false, new Data(2, 9, 2020), new Data(2, 9, 2024),"GEI",3,llistaAssociacionsProv);
             Professors professor1 = new Professors("P001", "professor1@example.com", true, new Data(1, 9, 2010), new Data(1, 9, 2020),"GEI",10,llistaAssociacionsProv);
             Professors professor2 = new Professors("P002", "professor2@example.com", true, new Data(1, 9, 2015), new Data(1, 9, 2021),"GEI",5,llistaAssociacionsProv);
             Alumnes alumne3 = new Alumnes("Al003", "alumne3@example.com", false, new Data(3, 9, 2020), new Data(3, 9, 2024),"GEI",3,llistaAssociacionsProv);

             // Afegir membres a la llista
             llistaMembresProv.afegirMembre(alumne1);
             llistaMembresProv.afegirMembre(alumne2);
             llistaMembresProv.afegirMembre(professor1);
             llistaMembresProv.afegirMembre(professor2);
             llistaMembresProv.afegirMembre(alumne3);
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
                System.out.println("Digues el nom de la associacio: \n");
                String nomAssociacio = teclat.nextLine().trim();
                
                // Solicitar l'opció de filtratge
                System.out.println("Si vols mostrar nomes professors escriu 1, si vols mostrar nomes alumnes escriu 0 i si vols mostrar ambdós escriu -1:\n");
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
                } else if (opcioMostrar1 == -1) {
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
                    //Accio accio1 = new Accio("Accio1", "Jaume", pos1);
                    //Accio accio2 = new Accio("Accio2", "Miquel", pos2);
                    Accio accioD = new Demostracio( "Demostració Robotica", "Pol Caballé", new Data(20, 4, 2024), true, (short) 15, 200, new int[]{3});
                    Accio accioX = new Xerrada("Xerrada Big Data", "Yeray Zarza", 40, new Data(10, 5, 2024), (short) 25, 150, new int[]{2, 4});
                    llistaAccions3.afegirAccio(accioD);

                    llistaAccions3.afegirAccio(accioX);

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
                    professorOAlumne.carregarMembres(llistaBaseA);
                    professorOAlumne.toString();
                    System.out.println(professorOAlumne.toString());
                    break;
                case 80: 
                    System.out.println("\nHeu escollit:");
                    System.out.println("80.Mostrar les dades de la llista d'associacions:\n\n");
                    System.out.println(llistaAssociacionsProv.toString());
                    break;
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
                        if (membre instanceof Professors) { // Comprovar si és un professor
                             System.out.println(membre); // Mostrar el professor que pertany a l'associació
                        }
                    }
                } else if (opcioMostrarProv3 == 0) {
                    System.out.println("Llista d'alumnes:");
                    for (int i = 0; i < llistaMembresProv.getNumMembres(); i++) {
                        Membres membre = llistaMembresProv.getMembre(i);
                        if (membre instanceof Alumnes) { // Comprovar si és un alumn
                            System.out.println(membre); // Mostrar l'alumne que pertany a l'associació
                        }
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
                    System.out.println("\nOpcio no valida. Intenta de nou\n");
                    scanner.close();
                    break;
            }
        } while (opcio != 18);
    
    }
}




