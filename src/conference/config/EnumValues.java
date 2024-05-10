package conference.config;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author edwin.rivera
 */
public class EnumValues {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("hh:mm a");

    public static final String LIGHTNING_TALK = "lightning";

    public static final int TRACK_DURATION = 420;
    public static final int MORNING_EVENT_DURATION = 180;
    public static final int AFTERNOON_EVENT_DURATION = 240;
    public static final int LIGHTNING_TALK_DURATION = 5;

    public static LocalTime TRACK_START_TIME = LocalTime.of(9, 0);
    public static LocalTime LUNCH_START_TIME = LocalTime.of(12, 0);
    public static LocalTime POST_LUNCH_START_TIME = LocalTime.of(13, 0);
    public static LocalTime NETWORKING_START_TIME = LocalTime.of(17, 0);

    public static final int LUNCH_DURATION = 60;
    public static final int NETWORKING_DURATION = 60;
}
