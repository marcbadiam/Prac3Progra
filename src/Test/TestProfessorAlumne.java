package Test;

import LlistesGestioFitxers.LlistaMembresText;

public class TestProfessorAlumne {
    public static void main(String[] args) {
        System.out.println("\n!!!!!!!!!!!:");
        System.out.println("60. Comprovació professor/alumne:\n\n");
        LlistaMembresText professorOAlumne = new LlistaMembresText();
        professorOAlumne.carregarMembres(null);
        professorOAlumne.toString();
        System.out.println(professorOAlumne.toString());
    }
}
