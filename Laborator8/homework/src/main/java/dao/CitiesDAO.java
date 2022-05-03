package dao;

import database.Database;
import model.Cities;

import java.sql.*;
import java.util.ArrayList;


public class CitiesDAO {
    public void create(String name,String id, boolean code, Double latitude, Double longitude) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.
                prepareStatement("insert into cities (name,id,code,latitude,longitude) values (?,?,?,?,?)")) {
            pstmt.setString(1,name);
            pstmt.setString(2,id);
            pstmt.setBoolean(3,code);
            pstmt.setDouble(4,latitude);
            pstmt.setDouble(5,longitude);
            pstmt.executeUpdate();
            connection.commit();
        }
    }

    public static ArrayList findName(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT name FROM cities";
        ResultSet result = statement.executeQuery(sql);
        ArrayList<String> ar = new ArrayList<String>();
        while (result.next()) {
            ar.add(result.getString(1));
        }
        return ar;
    }

    public static Double printDistance(String name1, String name2) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement pstmt1 = connection.prepareStatement("select latitude from cities where name='" + name1 + "'");
        PreparedStatement pstmt11 = connection.prepareStatement("select longitude from cities where name='" + name1 + "'");
        PreparedStatement pstmt2 = connection.prepareStatement("select latitude from cities where name='" + name2 + "'");
        PreparedStatement pstmt12 = connection.prepareStatement("select longitude from cities where name='" + name2 + "'");

        ResultSet rs1 = pstmt1.executeQuery();
        ResultSet rs11 = pstmt11.executeQuery();
        ResultSet rs2 = pstmt2.executeQuery();
        ResultSet rs12 = pstmt12.executeQuery();

        return Cities.distance(rs1.getDouble(1),rs2.getDouble(1),rs11.getDouble(1),rs12.getDouble(1));
    }

}