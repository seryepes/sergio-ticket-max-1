package app.service;

import app.domain.Event;
import app.service.exceptions.DuplicateEntityException;
import app.service.exceptions.EntityNotFoundException;
import app.service.exceptions.TicketMaxException;
import app.service.inputports.EventService;
import app.service.outputports.EventRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event create(Integer eventId, String eventName, LocalDate eventDate, LocalTime eventTime) {
        if (eventRepository.selectById(eventId) != null) {
            throw new DuplicateEntityException("un evento", eventId);
        }
        Event event = buildEvent(eventId, eventName, eventDate, eventTime);
        return eventRepository.save(event);
    }

    @Override
    public Event selectById(int id) {
        Event event = eventRepository.selectById(id);
        if (event == null) {
            throw new EntityNotFoundException("un evento", id);
        }
        return event;
    }

    @Override
    public List<Event> selectEvents() {
        return eventRepository.selectAll();
    }

    @Override
    public Event update(Integer eventId, String eventName, LocalDate eventDate, LocalTime eventTime) {
        selectById(eventId);
        Event event = buildEvent(eventId, eventName, eventDate, eventTime);
        return eventRepository.updateEvent(event);
    }

    @Override
    public void deleteEvent(int id) {
        selectById(id);
        eventRepository.deleteById(id);
    }


    private Event buildEvent(Integer eventId, String eventName, LocalDate eventDate, LocalTime eventTime) {
        if (eventDate.isBefore(LocalDate.now())) {
            throw new TicketMaxException("La fecha del evento no puede ser en el pasado");
        }
        return new Event(eventId, eventName, eventDate, eventTime);
    }
}
