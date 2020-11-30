package persistence;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

public interface IConnector {
    Connection getConnection()throws URISyntaxException, SQLException;
}
