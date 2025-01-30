/**
 * @author Núria Yepes
 */

 package LlistesGestioFitxers;

 import Classes.*;
 import java.io.*;
 
 public class LlistaMembresText {
     private int nMembres;
     private Membres[] llistaMembres;
     private static int MAX_MEM = 300;
     private static final String FITXER_MEMBRES = "membres.csv";
 
     public LlistaMembresText(){
         llistaMembres = new Membres[MAX_MEM];
         nMembres = 0;
     }
 
     public int getNumMembres(){
         return nMembres;
     }
 
     public LlistaMembresText copia(){
         LlistaMembresText copiaLlistaMembres = new LlistaMembresText();
         copiaLlistaMembres.nMembres = this.nMembres;
         for(int i=0; i<this.nMembres; i++){
             copiaLlistaMembres.llistaMembres[i]=this.llistaMembres[i];
         }
         return copiaLlistaMembres;
         }
 
         public void afegirMembre(Membres membre){
             if (nMembres < MAX_MEM) {
                 llistaMembres[nMembres] = membre;
                 nMembres++;
                 System.out.println("S'ha afegit correctament el membre: " + membre.getAliesId());
                 System.out.println("Nombre de membres actuals: " + nMembres);
             } else {
                 System.out.println("\nNo es poden afegir mes membres. S'ha superat la capacitat.");
             }
         }
 
         public void eliminarMembre(String aliesId) {
             boolean trobat = false;  // Variable para indicar si se ha encontrado el membre
             for (int i = 0; i < nMembres; i++) {
                 // Verificar si el membre actual no es nulo antes de acceder a su aliesId
                 if (llistaMembres[i] != null && llistaMembres[i].getAliesId().equalsIgnoreCase(aliesId)) {
                     // Desplazar los elementos hacia la izquierda
                     for (int j = i; j < nMembres - 1; j++) {
                         llistaMembres[j] = llistaMembres[j + 1];
                     }
                     llistaMembres[nMembres - 1] = null;  // Eliminar la última posición
                     nMembres--;  // Disminuir el contador de membres
                     trobat = true;
                     System.out.println("S'ha eliminat correctament el membre: " + aliesId);
                     break;  // Salir del bucle ya que hemos eliminado el membre
                 }
             }
         
             if (!trobat) {
                 System.out.println("No s'ha trobat el membre amb el aliesId: " + aliesId);
             }
         
             // Intentar guardar membres en el fitxer
             // Aquí ya no deberías capturar IOException si no se lanza desde guardarMembres()
             guardarMembres();
         }
         
         
         
     public String toString(){
         String str = "";
         int i=0;
         for(Membres membre : llistaMembres){
             if (membre!=null) {
                 str += "MembreNumero: " + i++ +"=\n";
                 str += membre.toString() + "\n";
             }
         }
         if (str.isEmpty()) {
             str = "No hi ha cap membre\n";
         }
         return str;
     }
 
     public Membres getMembre(int i) {
         if (i >= 0 && i < nMembres) { // Verificar que el índice sea válido
             return llistaMembres[i];
         } else {
             throw new IndexOutOfBoundsException("Índex fora de límits: " + i);
         }
     }
 
     public void carregarMembres(LlistaAssociacionsSerial llistaAssociacions) {
         try (BufferedReader br = new BufferedReader(new FileReader(FITXER_MEMBRES))) {
             String linia;
             while ((linia = br.readLine()) != null) {
                 String[] camps = linia.split(";");
                 if (camps.length == 8) {  
                     try {
                         String aliesId = camps[0];
                         String email = camps[1];
                         boolean esProfessor = Boolean.parseBoolean(camps[2]);
                         String departamentOrEnsenyament = camps[3];
                         int anys = Integer.parseInt(camps[4]);
                         String dataAltaS = camps[5]; 
                         String dataBaixaS = camps[6]; 
                         String nomAssoc = camps[7];
                         // Procesar dataAlta
                         String[] parts = dataAltaS.split("-");
                         Data dataAlta = null;
                         if (parts.length == 3) {
                             int dia = Integer.parseInt(parts[0]);
                             int mes = Integer.parseInt(parts[1]);
                             int any = Integer.parseInt(parts[2]);
                             dataAlta = new Data(dia, mes, any);  // Crear instancia de Data para dataAlta
                         }
     
                         // Procesar dataBaixa
                         String[] parts1 = dataBaixaS.split("-");
                         Data dataBaixa = null;
                         if (parts1.length == 3) {
                             int dia = Integer.parseInt(parts1[0]);
                             int mes = Integer.parseInt(parts1[1]);
                             int any = Integer.parseInt(parts1[2]);
                             dataBaixa = new Data(dia, mes, any);  // Crear instancia de Data para dataBaixa
                         } 
                         LlistaAssociacionsSerial llistaAssociacionsMembres = new LlistaAssociacionsSerial();
                         for(int i = 0; i < llistaAssociacions.getNElem(); i++){
                            Associacio a = llistaAssociacions.getAssociacio(i);
                            if(a.getNomAssociacio().equals(nomAssoc)){
                              llistaAssociacionsMembres.afegirAssoc(a);  
                            }
                         }

                         // Determinar si es un profesor o un alumno
                         if (esProfessor) {
                             // Si es un profesor
                             if (dataAlta != null && dataBaixa != null) {
                                 Professors professor = new Professors(aliesId, email,esProfessor,dataAlta, dataBaixa, departamentOrEnsenyament, anys,llistaAssociacionsMembres);
                                 if (nMembres < MAX_MEM) {
                                     afegirMembre(professor);
                                 }
                             }
                         } else {
                             // Si es un alumno
                             if (dataAlta != null && dataBaixa != null) {
                                 Alumnes alumne = new Alumnes(aliesId, email,esProfessor,dataAlta, dataBaixa, departamentOrEnsenyament, anys,llistaAssociacionsMembres);
                                 if (nMembres < MAX_MEM) {
                                     afegirMembre(alumne);
                                 }
                             }
                         }
                     } catch (IllegalArgumentException e) {
                         System.out.println("Error al procesar la línia (format incorrecte): " + linia);
                     }
                 }
             }
         } catch (IOException e) {
             System.out.println("Hi ha hagut un error en la lectura del fitxer: " + e.getMessage());
         }
     }
     
     
 
     public void guardarMembres() {
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(FITXER_MEMBRES))) {
             for (int i = 0; i < nMembres; i++) {
                 Membres membre = llistaMembres[i];
                 if (membre instanceof Alumnes) {
                     Alumnes alumne = (Alumnes) membre;
                     bw.write(alumne.getAliesId() + ";" + alumne.getCorreu() + ";" + alumne.getEnsenyament() + ";" + alumne.getAnys());
                 } else if (membre instanceof Professors) {
                     Professors professor = (Professors) membre;
                     bw.write(professor.getAliesId() + ";" + professor.getCorreu() + ";" + professor.getDepartament() + ";" + professor.getDespatx());
                 }
                 bw.newLine();
             }
         } catch (IOException e) {
             System.out.println("Hi ha hagut un error en l'escriptura al fitxer: " + e.getMessage());
         }
     }
 
     /**
      * Mètode per obtenir tots els professors de la llista de membres.
      * @return una llista de professors.
      */
     public Membres[] membresAProfessors() {
         Membres[] professors = new Membres[nMembres];
         int count = 0;
 
         for (int i = 0; i < nMembres; i++) {
             //String  departament = llistaMembres[i].getDepartament();
             String  departament="";
             Membres membre = llistaMembres[i];
             if (departament.equals("DEIM") || departament.equals("DEEEA")) {
                 professors[count++] = membre;
             }
         }
         Membres[] result = new Membres[count];
         return result;
     }
 
 }
 