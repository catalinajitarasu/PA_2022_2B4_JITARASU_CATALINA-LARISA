package App;

import App.Entities.CitiesEntity;
import App.Entities.CountriesEntity;
import App.Repository.CityRepo;
import App.Repository.CountryRepo;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(final String[] args) {
        Manager manager = Manager.getInstance();
        CitiesEntity city=new CitiesEntity();
        city.setName("Iasi");
        city.setId("CC");
        CountriesEntity country=new CountriesEntity();
        country.setName("Romania");
        country.setId("BB");
        EntityManager entityManager = manager.entityManagerFactory.createEntityManager();
        CityRepo.create(city);
        CountryRepo.create(country);
        System.out.println(CountryRepo.findByName("Romania"));
        entityManager.close();
        manager.entityManagerFactory.close();
    }
}
