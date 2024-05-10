package conference.dto;

import java.time.LocalTime;

/**
 *
 * @author edwin.rivera
 */
public class TalkDTO {

    private LocalTime startTime;
    private int duration;
    private String title;

    public TalkDTO() {
    }

    public TalkDTO(LocalTime startTime, int duration, String title) {
        this.startTime = startTime;
        this.duration = duration;
        this.title = title;
    }

    public TalkDTO(String title, int duration) {
        this.duration = duration;
        this.title = title;
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

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
