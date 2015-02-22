package sml.exceptions;

public class RegisterOverflowException extends Exception {
    public RegisterOverflowException(){
        super("Register values must be between 0-31");
    }
}
