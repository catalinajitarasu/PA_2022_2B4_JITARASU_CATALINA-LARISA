package App.Repository;

import App.Entities.CountriesEntity;
import App.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CountryRepo {
    private static EntityManager entityManager = Manager.getInstance().entityManagerFactory.createEntityManager();
    public static CountriesEntity findById(int id) {
        return entityManager.find(CountriesEntity.class, id);
    }

    public static CountriesEntity findByName(String name) {
        TypedQuery<CountriesEntity> query = entityManager.createQuery("SELECT a FROM CountriesEntity a where a.name=:name", CountriesEntity.class);
        query.setParameter("name", name);
        if (query.getResultList().isEmpty())
            return null;
        return query.getSingleResult();

    }

    public static CountriesEntity create(CountriesEntity country) {
        CountriesEntity existingCountry = findByName(country.getName());
        if (existingCountry == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(country);
            entityManager.getTransaction().commit();
        }
        return country;
    }
}
