package br.com.hytech.rhsouthsystem.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ClosedSessionException extends RuntimeException{

    public ClosedSessionException(
            final String message,
            final Throwable cause) {
        super(message, cause);
    }

    public ClosedSessionException(
            final String message) {
        super(message);
    }

}
