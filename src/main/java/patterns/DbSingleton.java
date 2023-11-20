package patterns;

import java.sql.SQLException;

public class DbSingleton {
    
    private static Db instance;

    private DbSingleton(){};

    public static Db getInstance(String connection, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new Db(connection, user, password);
        }
        return instance;
    }

}
