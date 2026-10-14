package app.repository;

import app.domain.Event;
import app.service.outputports.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImplCollection implements EventRepository {

    private final List<Event> events = new ArrayList<>();

    @Override
    public Event save(Event event) {
        events.add(event);
        return event;
    }

    @Override
    public Event selectById(int id) {
        for (Event event : events) {
            if (event.getEventId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public List<Event> selectAll() {
        return new ArrayList<>(events);
    }

    @Override
    public Event updateEvent(Event event) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEventId().equals(event.getEventId())) {
                events.set(i, event);
                return event;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        events.removeIf(event -> event.getEventId().equals(id));
    }
}
