package Tests;

import Llistes.LlistaMembres;

public class TestProfessorAlumne {
    public static void main(String[] args) {
        System.out.println("\n!!!!!!!!!!!:");
        System.out.println("60. Comprovació professor/alumne:\n\n");
        LlistaMembres professorOAlumne = new LlistaMembres();
        professorOAlumne.carregarMembres();
        professorOAlumne.toString();
        System.out.println(professorOAlumne.toString());
    }
}
