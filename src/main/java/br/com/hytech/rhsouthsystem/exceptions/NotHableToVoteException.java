package br.com.hytech.rhsouthsystem.exceptions;

public class NotHableToVoteException extends RuntimeException{

public NotHableToVoteException(
        final String message,
        final Throwable cause) {
    super(message, cause);
}

    public NotHableToVoteException(
            final String message) {
        super(message);
    }

}
