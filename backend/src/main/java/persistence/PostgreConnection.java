package persistence;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection implements IConnector {

    private static final PostgreConnection instance = new PostgreConnection();

    public static PostgreConnection getInstance() {
        return instance;
    }

    private PostgreConnection() {
    }

    public Connection getConnection() throws URISyntaxException, SQLException {

        URI dbUri = new URI("postgres://rwmxbsfwlalcpj:9692678f6abf5b3d4e501950e6f658cc2e96a100c9bb3f4a7ea7f7b22ff5e964@ec2-54-146-142-58.compute-1.amazonaws.com:5432/d9vvj1oclae893");
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        return DriverManager.getConnection(dbUrl, username, password);
    }
}
