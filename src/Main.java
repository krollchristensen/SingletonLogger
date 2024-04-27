public class Main {
    public static void main(String[] args) {

        // Henter logger-instansen og bruger den til at logge forskellige begivenheder
        Logger logger = Logger.getInstance();
        logger.log("Application is starting...");
        logger.log("Performing some operations...");
        logger.log("Application is shutting down...");

        // Lukker loggeren korrekt
        logger.closeLogger();
    }
}