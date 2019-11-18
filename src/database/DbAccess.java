package database;

import java.sql.Connection;

/**
 * Realizza l'accesso alla base di dati
 */
public class DbAccess {

    /**
     * contiene il nome della classe Driver
     */
    private String DRIVER_CLASS_NAME = "org.gjt.mm.mysql.Driver";

    /**
     * contiene l'identificativo del Database Management System
     */
    private final String DBMS = "jdbc:mysql";

    /**
     * contiene l'identificativo del server che contiene il database
     */
    private final String SERVER = "localhost";

    /**
     * nome della base di dati
     */
    private final String DATABASE = "MapDB";

    /**
     * porta su cui il DBMS MySQL accetta le connessioni
     */
    private final String PORT = "3306";

    /**
     * nome dell’utente per l’accesso alla base di dati
     */
    private final String USER_ID = "Map";

    /**
     * password di autenticazione per l’utente identificato da USER_ID
     */
    private final String PASSWORD = "map";

    /**
     * gestisce una connessione
     */
    private Connection conn;
}
