package conference.conferencemanager;

import conference.dto.ConferenceDTO;
import conference.dto.TalkDTO;
import conference.service.ConferenceManageService;
import conference.service.TalkService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin.rivera
 */
public class ConferenceManager {

    public static void main(String[] args) {
        List<TalkDTO> talkList = new ArrayList<>();

        talkList = TalkService.readTalksFromConsole();

        if (talkList == null || talkList.isEmpty()) {
            return;
        }
        TalkService.printTalks(talkList);

        ConferenceDTO conference = ConferenceManageService.scheduleTalks(talkList);
        ConferenceManageService.printConference(conference);
    }
}
