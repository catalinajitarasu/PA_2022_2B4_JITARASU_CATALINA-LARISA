package dao;

import java.sql.Connection;
import java.sql.SQLException;

import static dao.Database.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe",125);
            Database.getConnection().commit();

            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            countries.create("Italy16", europeId);
            countries.create("Portugal", europeId);
            Database.getConnection().commit();

            countries.create("France", europeId);
            countries.create("Norway", europeId);
            Database.getConnection().commit();

            //print all the countries in Europe
            countries.printCountries(europeId);
            Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            Database.rollback();
        }
    }
}
