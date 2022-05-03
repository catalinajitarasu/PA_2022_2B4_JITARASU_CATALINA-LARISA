import dao.CitiesDAO;
import dao.ContinentDAO;
import dao.CountryDAO;
import database.Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadData {
    private final Database connectionDB;

    public ReadData() throws SQLException, IOException {
        connectionDB = Database.getInstance();
        readData();
        System.exit(0);
        ArrayList<String> ar = new ArrayList<String>();
        ar=CitiesDAO.findName(connectionDB.connection);
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(CitiesDAO.printDistance(ar.get(i),ar.get(i+1))+ " K.M");
            System.out.println("/n");
        }
    }
    public static void readData() throws FileNotFoundException {
        Path pathToFile = Paths.get("src/main/resources/concap.csv");
        try(BufferedReader br= Files.newBufferedReader(pathToFile, StandardCharsets.ISO_8859_1)){
            String line =br.readLine();
            while((line= br.readLine()) != null){
                String[] txt= line.split(",");
                String id= addContinent(txt);
                addCountry(txt,id);
                line=br.readLine();
            }
        }
        catch (IOException v){
            v.printStackTrace();
        }
        catch (SQLException t){
            t.printStackTrace();
        }
    }

    private static String addContinent(String[] data) throws SQLException{
        var continents=new ContinentDAO();
        continents.create(data[5]);
        Database.getConnection().commit();
        return continents.findByName(data[5]);
    }

    private static void addCountry(String[] data, String id) throws SQLException{
        var countries=new CountryDAO();
        countries.create(data[0],data[4]);
        Database.getConnection().commit();
        var city=new CitiesDAO();
        city.create(data[1],countries.findByName(data[0]),true,Double.parseDouble(data[2]),Double.parseDouble(data[3]));
        Database.getConnection().commit();
    }
}
