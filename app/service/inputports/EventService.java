package app.service.inputports;

import app.domain.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventService {
    Event create(Integer eventId, String eventName, LocalDate eventDate, LocalTime eventTime);
    Event selectById(int id);
    List<Event> selectEvents();
    Event update(Integer eventId, String eventName, LocalDate eventDate, LocalTime eventTime);
    void deleteEvent(int id);
}
