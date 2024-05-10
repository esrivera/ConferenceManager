package conference.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin.rivera
 */
public class ConferenceDTO {

    private List<TrackDTO> tracks;

    public ConferenceDTO() {
        this.tracks = new ArrayList<>();
    }

    public ConferenceDTO(List<TrackDTO> tracks, String title) {
        this.tracks = tracks;
    }

    /**
     * @return the tracks
     */
    public List<TrackDTO> getTracks() {
        return tracks;
    }

    /**
     * @param tracks the tracks to set
     */
    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(TrackDTO track) {
        this.tracks.add(track);
    }
}
