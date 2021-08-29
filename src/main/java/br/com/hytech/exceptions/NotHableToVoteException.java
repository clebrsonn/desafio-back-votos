package br.com.hytech.exceptions;

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

    public NotHableToVoteException(
            final Throwable cause) {
        super(cause);
    }


}
