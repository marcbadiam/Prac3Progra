package Excepcions;

public class Excepcio1 extends Exception {
    public Excepcio1(String message) {
        super("Hi ha hagut un ERROR en la lectura del fitxer");
    }
}