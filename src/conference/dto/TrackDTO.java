package conference.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin.rivera
 */
public class TrackDTO {

    private List<EventDTO> events;
    private int trackId;

    public TrackDTO(int trackId) {
        this.trackId = trackId;
        this.events = new ArrayList<>();
    }

    public TrackDTO(List<EventDTO> events, int trackId) {
        this.events = events;
        this.trackId = trackId;
    }

    /**
     * @return the events
     */
    public List<EventDTO> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }

    /**
     * @return the trackId
     */
    public int getTrackId() {
        return trackId;
    }

    /**
     * @param trackId the trackId to set
     */
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void addEvent(EventDTO event) {
        this.events.add(event);
    }

}
