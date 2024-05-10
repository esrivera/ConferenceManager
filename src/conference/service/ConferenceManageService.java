/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conference.service;

import conference.config.EnumValues;
import conference.dto.ConferenceDTO;
import conference.dto.EventDTO;
import conference.dto.TalkDTO;
import conference.dto.TrackDTO;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin.rivera
 */
public class ConferenceManageService {

    /**
     * Programa charlas para una conferencia basándose en la lista proporcionada de
     * charlas.
     * 
     * @param talks La lista de charlas que se programarán.
     * @return La conferencia con charlas programadas.
     */
    public static ConferenceDTO scheduleTalks(List<TalkDTO> talks) {
        ConferenceDTO conference = new ConferenceDTO();

        int trackCount = 0;

        while (0 != talks.size()) {
            EventDTO morningEvent = new EventDTO(EnumValues.MORNING_EVENT_DURATION, EnumValues.TRACK_START_TIME);
            fillEvent(morningEvent, talks);

            EventDTO lunchEvent = new EventDTO(EnumValues.LUNCH_DURATION, EnumValues.LUNCH_START_TIME);
            lunchEvent.addTalk(new TalkDTO(EnumValues.LUNCH_START_TIME, EnumValues.LUNCH_DURATION, "Lunch"));

            EventDTO afternoonEvent = new EventDTO(EnumValues.AFTERNOON_EVENT_DURATION,
                    EnumValues.POST_LUNCH_START_TIME);
            fillEvent(afternoonEvent, talks);

            EventDTO networkingEvent = new EventDTO(EnumValues.NETWORKING_DURATION, EnumValues.NETWORKING_START_TIME);
            networkingEvent.addTalk(new TalkDTO(EnumValues.NETWORKING_START_TIME, 0, "Networking Event"));

            TrackDTO track = new TrackDTO(++trackCount);
            track.addEvent(morningEvent);
            track.addEvent(lunchEvent);
            track.addEvent(afternoonEvent);
            track.addEvent(networkingEvent);

            conference.addTrack(track);
        }

        return conference;
    }

    /**
     * Llena un evento con charlas basadas en el tiempo disponible y las duraciones
     * de las charlas.
     * 
     * @param event El evento en el que se llenarán las charlas.
     * @param talks La lista de charlas disponibles para programar.
     */
    public static void fillEvent(EventDTO event, List<TalkDTO> talks) {
        LocalTime currentStartTime = event.getStartTime();
        List<TalkDTO> talksToRemove = new ArrayList<>();

        for (TalkDTO talk : talks) {
            if (event.getTimeLeft() >= talk.getDuration()) {
                event.addTalk(new TalkDTO(currentStartTime, talk.getDuration(), talk.getTitle()));
                currentStartTime = nextStartTime(currentStartTime, talk);
                talksToRemove.add(talk);
            }
        }

        talks.removeAll(talksToRemove);
    }

    /**
     * Calcula la hora de inicio para la próxima charla basada en la hora de inicio
     * actual y la duración de la charla actual.
     * 
     * @param currentStartTime La hora de inicio actual.
     * @param currentTalk      La charla actual.
     * @return La hora de inicio para la próxima charla.
     */
    public static LocalTime nextStartTime(LocalTime currentStartTime, TalkDTO currentTalk) {
        LocalTime newTime = currentStartTime.plusMinutes(currentTalk.getDuration());
        return newTime;
    }

    /**
     * Imprime los detalles de la conferencia, incluidas las charlas programadas.
     * 
     * @param conference La conferencia que se imprimirá.
     */
    public static void printConference(ConferenceDTO conference) {

        DateTimeFormatter formatDate = EnumValues.DATE_FORMATTER;
        System.out.println("\n\n\t\t>>===== CONFERENCE =====<<");
        System.out.println("=========================================================");
        for (TrackDTO track : conference.getTracks()) {
            System.out.println("\nTrack " + track.getTrackId());
            List<EventDTO> events = track.getEvents();
            System.out.println("");
            for (EventDTO event : events) {
                for (TalkDTO talk : event.getTalks()) {
                    System.out.println(formatDate.format(talk.getStartTime()) + " " + talk.getTitle()
                            + " " + talk.getDuration());
                }
            }
            System.out.println("=========================================================");
        }
    }
}
