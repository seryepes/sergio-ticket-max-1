package app.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private Integer eventId;
    private String eventName;
    // LocalDate (solo fecha) y LocalTime (solo hora)
    private LocalDate eventDate;
    private LocalTime eventTime;

    public Event() {
    }

    public Event(Integer eventId, String eventName, LocalDate eventDate, LocalTime eventTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "Evento #" + eventId + " | " + eventName
                + " | Fecha: " + eventDate + " a las " + eventTime;
    }
}
