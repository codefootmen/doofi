package persistence;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection implements IConnector {
    private static final SqliteConnection instance = new SqliteConnection();

    public static SqliteConnection getInstance() {
        return instance;
    }

    private SqliteConnection() {
    }

    @Override
    public Connection getConnection() throws SQLException {

        String url = "jdbc:sqlite:doofi.db";
        return DriverManager.getConnection(url);
    }
}
