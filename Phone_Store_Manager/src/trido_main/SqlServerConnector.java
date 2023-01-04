package trido_main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlServerConnector {

    public Connection init() {
        String url = "jdbc:sqlserver://localhost:1433; databaseName=" + Const.DATABASE.DB_NAME + "; user=" + Const.DATABASE.DB_USER + "; password=" + Const.DATABASE.DB_PASSWORD + ";" +
                "encrypt=true; trustServerCertificate=true; sslProtocol=TLSv1.2";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            return DriverManager.getConnection(url);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
