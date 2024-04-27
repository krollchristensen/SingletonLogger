public class Logger {
    // Statisk variabel, der indeholder referencen til singleton-objektet
    private static Logger instance;

    // Privat konstruktør for at forhindre instansiering udefra
    private Logger() {
        // Her kunne initialisering af logfiler eller logkonfigurationer foretages
    }

    // Offentlig metode til at hente instansen af klassen
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Metode til at logge information
    public void log(String message) {
        // Log meddelelsen til en fil eller konsol
        System.out.println(message);
    }
}