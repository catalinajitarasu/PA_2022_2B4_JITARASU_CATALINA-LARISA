package dao;

import database.Database;

import java.sql.*;

public class CountryDAO {
    public void create(String name, String id) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into countries (name,id) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
            connection.commit();
        }
    }

    public String findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from countries where name='" + name + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

}
