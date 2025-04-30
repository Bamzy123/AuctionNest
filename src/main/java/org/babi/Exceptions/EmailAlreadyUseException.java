package org.babi.Exceptions;

public class EmailAlreadyUseException extends RuntimeException {
    public EmailAlreadyUseException(String message) {
        super(message);
    }
}
