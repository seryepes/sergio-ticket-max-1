package app.service.exceptions;

public class DuplicateEntityException extends TicketMaxException {
    public DuplicateEntityException(String entity, int id) {
        super("Ya existe " + entity + " con id " + id);
    }
}
