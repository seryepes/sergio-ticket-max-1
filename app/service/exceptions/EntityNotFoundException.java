package app.service.exceptions;

public class EntityNotFoundException extends TicketMaxException {
    public EntityNotFoundException(String entity, int id) {
        super("No existe " + entity + " con id " + id);
    }

}
