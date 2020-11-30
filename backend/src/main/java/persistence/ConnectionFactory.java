package persistence;

public class ConnectionFactory {
    public IConnector getConnector(ConnectionType type){
        switch (type){
            case POSTGRE:
                return PostgreConnection.getInstance();
            case SQLITE:
                return SqliteConnection.getInstance();
            default:
                throw new Error("No connection type");
        }
    }
}
