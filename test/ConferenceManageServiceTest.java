package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import conference.dto.ConferenceDTO;
import conference.dto.EventDTO;
import conference.dto.TalkDTO;
import conference.service.ConferenceManageService;

/**
 * Esta clase contiene pruebas unitarias para la clase ConferenceManageService.
 */
public class ConferenceManageServiceTest {

    /**
     * Prueba el método scheduleTalks para verificar que pueda programar charlas
     * correctamente en una conferencia.
     */
    @Test
    public void testScheduleTalks() {
        List<TalkDTO> talks = new ArrayList<>();
        talks.add(new TalkDTO("Charla 1", 60));
        talks.add(new TalkDTO("Charla 2", 45));
        talks.add(new TalkDTO("Charla 3", 30));

        ConferenceDTO conference = ConferenceManageService.scheduleTalks(talks);

        assertNotNull(conference);
        assertEquals(1, conference.getTracks().size());
        assertEquals(4, conference.getTracks().get(0).getEvents().size());
    }

    /**
     * Prueba el método fillEvent para verificar que pueda llenar un evento con
     * charlas basadas en el tiempo disponible.
     */
    @Test
    public void testFillEvent() {
        EventDTO event = new EventDTO(120, LocalTime.of(9, 0));
        List<TalkDTO> talks = new ArrayList<>();
        talks.add(new TalkDTO("Charla 1", 60));
        talks.add(new TalkDTO("Charla 2", 45));
        talks.add(new TalkDTO("Charla 3", 30));

        ConferenceManageService.fillEvent(event, talks);
        assertEquals(2, event.getTalks().size());
    }

    /**
     * Prueba el método nextStartTime para verificar que pueda calcular la hora de
     * inicio para la próxima charla correctamente.
     */
    @Test
    public void testNextStartTime() {
        LocalTime currentStartTime = LocalTime.of(10, 0);
        TalkDTO currentTalk = new TalkDTO("Charla", 45);

        LocalTime nextStartTime = ConferenceManageService.nextStartTime(currentStartTime, currentTalk);
        assertEquals(LocalTime.of(10, 45), nextStartTime);
    }
}
