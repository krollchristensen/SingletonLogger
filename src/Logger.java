import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;

    // Privat konstruktør for at forhindre instansiering udefra
    private Logger() {
        try {
            // Åbner logfilen i append mode, så nye logs tilføjes til eksisterende fil
            FileWriter fileWriter = new FileWriter("applog.txt", true);
            writer = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Offentlig metode til at hente instansen af klassen
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    // Metode til at logge information
    public void log(String message) {
        // Tilføjer tidsstempel til hver logmeddelelse
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        // Skriver beskeden med tidsstempel til logfilen
        writer.println(timestamp + " - " + message);
        writer.flush();  // Sikrer at data skrives til filen straks
    }
    // Ressourcefrigørelsesmetode
    public void closeLogger() {
        writer.close();
    }
}