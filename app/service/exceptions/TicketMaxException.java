package app.service.exceptions;

public class TicketMaxException extends RuntimeException   {
    public TicketMaxException(String message) {
        super(message);
    }
}
