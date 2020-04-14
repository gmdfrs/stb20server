package fr.univ.rouen.stb20server.util;

/**
 * Exception pour la validation d STB
 * @author Yeser GOUMIDI
 */

public class StbNotValidException extends Exception {

    public StbNotValidException(String message) {
        super(message);
    }
    
    public StbNotValidException(){
        super("Validation error");
    }
}
