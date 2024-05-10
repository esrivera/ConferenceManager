package conference.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin.rivera
 */
public class EventDTO {

    private List<TalkDTO> talks;
    private int timeLeft;
    private LocalTime startTime;

    public EventDTO() {
    }

    public EventDTO(int timeLeft, LocalTime startTime) {
        this.talks = new ArrayList<>();
        this.timeLeft = timeLeft;
        this.startTime = startTime;
    }

    /**
     * @return the talks
     */
    public List<TalkDTO> getTalks() {
        return talks;
    }

    /**
     * @param talks the talks to set
     */
    public void setTalks(List<TalkDTO> talks) {
        this.talks = talks;
    }

    /**
     * @return the timeLeft
     */
    public int getTimeLeft() {
        return timeLeft;
    }

    /**
     * @param timeLeft the timeLeft to set
     */
    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    /**
     * @return the startTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void addTalk(TalkDTO talk) {
        this.talks.add(talk);
        this.timeLeft -= talk.getDuration();
    }
}
