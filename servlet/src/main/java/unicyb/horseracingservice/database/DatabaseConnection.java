package unicyb.horseracingservice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Used for connect to database
public class DatabaseConnection {
    public static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException
    {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        String dbName = "HORSERACES";
        String dbUsername = "root";
        String dbPassword = "0961533469Vi";
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
}
