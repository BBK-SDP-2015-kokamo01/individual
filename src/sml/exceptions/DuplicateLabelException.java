package sml.exceptions;

public class DuplicateLabelException extends Exception {

    public DuplicateLabelException() {
        super("Duplicate label is not allowed.");
    }
}
