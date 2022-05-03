package dao;

import java.sql.*;
import database.Database;

public class ContinentDAO {
    public void create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into continents (name) values (?)")) {
            pstmt.setString(1,name);
            pstmt.executeUpdate();
            connection.commit();
        }
    }

    public String findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
