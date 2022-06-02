package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "student";
    private static final String PASSWORD = "STUDENT";
    public static Connection connection = null;
    private static Database connectionDB_instance = null;

    private Database() {
    }

    public static Connection getConnection() {
        createConnection();
        return connection;
    }

    public static Database getInstance() {
        if (connectionDB_instance == null) {
            connectionDB_instance = new Database();
        }
        return connectionDB_instance;
    }

    private static void createConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection =  DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void rollback() throws SQLException {
        connection.rollback();
    }

    public static void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
