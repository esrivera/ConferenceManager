package conference.service;

import conference.config.EnumValues;
import conference.dto.TalkDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author edwin.rivera
 */
public class TalkService {

    /**
     * Lee las charlas desde la consola en el formato 'Título Duración' y las
     * devuelve como una lista de objetos TalkDTO.
     * 
     * @return La lista de charlas leídas desde la consola.
     */
    public static List<TalkDTO> readTalksFromConsole() {
        Scanner scanner = new Scanner(System.in);
        List<TalkDTO> talks = new ArrayList<>();

        System.out.println("Ingrese las charlas en el formato 'Titulo Duracion', una por linea:");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split(" ");
            if (parts.length < 2) {
                System.out.println("Error: El formato de entrada es incorrecto. Use 'Título Duración' en cada línea.");
                scanner.close();
                return null;
            }

            String title = "";
            for (int i = 0; i < parts.length - 1; i++) {
                title += parts[i] + " ";
            }
            title = title.trim();
            int duration;
            try {
                if (parts[parts.length - 1].equals(EnumValues.LIGHTNING_TALK)) {
                    duration = EnumValues.LIGHTNING_TALK_DURATION;
                } else {
                    duration = Integer.parseInt(parts[parts.length - 1]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: La duración debe ser un número entero.");
                scanner.close();
                return null;
            }

            talks.add(new TalkDTO(title, duration));
        }
        scanner.close();

        return talks;
    }

    /**
     * Imprime las charlas en la consola.
     * 
     * @param talks La lista de charlas que se imprimirán.
     */
    public static void printTalks(List<TalkDTO> talks) {
        System.out.println("\n\n\t\t>>===== TALKS =====<<\n");
        System.out.println("=========================================================");
        for (TalkDTO talk : talks) {
            System.out.println("Título: " + talk.getTitle() + ", Duración: " + talk.getDuration() + " min");
        }
    }
}
