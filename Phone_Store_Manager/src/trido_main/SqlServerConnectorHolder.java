package trido_main;

public abstract class SqlServerConnectorHolder {
    protected final SqlServerConnector connector;

    protected SqlServerConnectorHolder() {
        connector = new SqlServerConnector();
    }
}
