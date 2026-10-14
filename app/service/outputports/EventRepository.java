package app.service.outputports;

import app.domain.Event;

import java.util.List;

public interface EventRepository {
    Event save(Event event);
    Event selectById(int id);
    List<Event> selectAll();
    Event updateEvent(Event event);
    void deleteById(int id);
}
