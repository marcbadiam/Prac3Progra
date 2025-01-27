package ProgramaPrincipal;
import java.util.Scanner;

import Classes.Accio;
import Classes.Alumnes;
import Classes.Associacio;
import Classes.Data;
import Classes.Professors;
import Classes.Xerrada;
import GestioFitxers.LlistaAssociacionsSerial;
import Llistes.LlistaAccions;
import Llistes.LlistaAssociacions;
import Llistes.LlistaMembres;
import GestioFitxers.LlistaAccionsText;

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
                    llistaCarregada1.carregarAssociacions();
                    System.out.println(llistaCarregada1.toString());
                    break;
                case 2:
                    System.out.println("\nHeu escollit:");
                    System.out.println("2. Mostrar les dades de la llista de membres que formen part d’una associació (afegint filtre per a professors, alumnes o ambdós):\n");
                    LlistaMembres llistaMembres2 = new LlistaMembres();
                    llistaMembres2.carregarMembres();
                    for(int i = 0; i<llistaMembres2.getNumMembres(); i++){/* 
                        if (llistaMembres2.getInstanceAt(i).equals("DEIM") || departament.equals("DEEEA")){ // Si el tercer campo es un departament, es un Professor
                            Professors professor = new Professors(camps[0], camps[1], departament, Integer.parseInt(camps[3]));
                            afegirMembre(professor);
                        } else { // Si no, es un Professor
                            Alumnes alumne = new Alumnes(camps[0], camps[1], camps[2], Integer.parseInt(camps[3]));
                            afegirMembre(alumne);
                        }*/
                    }
                    break;
                case 3:
                    System.out.println("\nHeu escollit:");
                    System.out.println("3. Mostrar les dades de la llista de membres actius, que formen part de qualsevol associació (afegint filtre per a professors, alumnes o ambdós):\n");
                    //Marc  
                    break;
                case 4:
                    System.out.println("\nHeu escollit:");
                    System.out.println("4. Mostrar les dades de la llista d’accions (afegint filtre o no per tipus d’acció):\n\n");
                    //Nuria
                    break;
                case 5:
                    System.out.println("\nHeu escollit:");
                    System.out.println("5. Obtenir i mostrar la llista d’accions que ofereix una associació concreta:\n");
                    //Yeray
                    break;
                case 6:
                    System.out.println("\nHeu escollit:");
                    System.out.println("6. Obtenir i mostrar la llista de les xerrades que es duen a terme en una franja de dates indicada per teclat:\n\n");
                    //
                    break;
                case 7:
                    System.out.println("\nHeu escollit:");
                    System.out.println("7. Afegir una nova associació:\n\n");
                    //
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
                    //
                    break;
                case 16:
                    System.out.println("\nHeu escollit:");
                    System.out.println("16. Mostrar les dades de les xerrades que farà una persona concreta:\n");
                    //
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
                case 30:
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("18. Comprovacio AccionsText!");
                    LlistaAssociacions llistaAssociacions51 = new LlistaAssociacions();
                    String[] titulacions51 = {"GEB", "GEI", "GESST"};
                    String[] membres51 = {"Membre1", "Membre2", "Membre3"};
                    Associacio associacio51 = new Associacio("Associació de Prova", "email@example.com", titulacions51, membres51, "President", "Secretari", "Tresorer", 3, 0);
                    llistaAssociacions51.afegirAssoc(associacio51);
                    System.out.println("Arriba aqui! 185");
                    LlistaAccionsText llistaAccions = new LlistaAccionsText();
                    
                    //Accio accio1 = new Accio("Accio1", "Jaume", llistaAssociacions51);
                    //Accio accio2 = new Accio("Accio2", "Miquel", llistaAssociacions51);
                    //llistaAccions.afegirAccio(accio1);
                    //llistaAccions.afegirAccio(accio2);
                    System.out.println("Arriba aqui! 192");
                    llistaAccions.carregarAccions();
                    System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                    System.out.println("Detalls de la Llista d'Accions:");
                    System.out.println(llistaAccions.toString());

                    // getters
                    System.out.println("\nProva dels getters:");
                    System.out.println("Nombre d'Accions: " + llistaAccions.getNumAccions());
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

                case 60:
                    System.out.println("\n!!!!!!!!!!!:");
                    System.out.println("60. Comprovació professor/alumne:\n\n");
                    LlistaMembres professorOAlumne = new LlistaMembres();
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




