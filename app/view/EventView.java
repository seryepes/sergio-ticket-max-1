package app.view;

import app.domain.Event;
import app.service.exceptions.TicketMaxException;
import app.service.inputports.EventService;
import app.service.validators.DataTypeValidator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventView {

    private final EventService eventService;

    public EventView(EventService eventService) {
        this.eventService = eventService;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println();
            System.out.println("===== EVENTOS =====");
            System.out.println("1. Crear");
            System.out.println("2. Listar todos");
            System.out.println("3. Buscar por id");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            option = DataTypeValidator.validateInt("Seleccione una opción: ");

            try {
                switch (option) {
                    case 1:
                        fillForm(false);
                        break;
                    case 2:
                        showAllEvents();
                        break;
                    case 3:
                        showEventById();
                        break;
                    case 4:
                        fillForm(true);
                        break;
                    case 5:
                        deleteEvent();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (TicketMaxException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }

    private void fillForm(boolean isUpdate) {
        int id = DataTypeValidator.validateInt("Id del evento: ");
        if (isUpdate) {
            eventService.selectById(id);
        }
        String name = DataTypeValidator.validateString("Nombre del evento: ");
        LocalDate date = DataTypeValidator.validateDate("Fecha (AAAA-MM-DD): ");
        LocalTime time = DataTypeValidator.validateTime("Hora (HH:MM): ");

        if (isUpdate) {
            eventService.update(id, name, date, time);
            System.out.println("Evento actualizado.");
        } else {
            eventService.create(id, name, date, time);
            System.out.println("Evento creado.");
        }
    }

    private void showAllEvents() {
        List<Event> events = eventService.selectEvents();
        if (events.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }
        for (Event event : events) {
            System.out.println(event);
        }
    }

    private void showEventById() {
        int id = DataTypeValidator.validateInt("Id del evento: ");
        Event event = eventService.selectById(id);
        System.out.println(event);
    }

    private void deleteEvent() {
        int id = DataTypeValidator.validateInt("Id del evento a eliminar: ");
        eventService.deleteEvent(id);
        System.out.println("Evento eliminado.");
    }
}
