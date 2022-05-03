package App.Repository;

import App.Entities.CitiesEntity;
import App.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CityRepo {

    private static EntityManager entityManager = Manager.getInstance().entityManagerFactory.createEntityManager();

    public static CitiesEntity findById(int id) {
        return entityManager.find(CitiesEntity.class, id);
    }

    public static CitiesEntity findByName(String name) {
        TypedQuery<CitiesEntity> query = entityManager.createQuery("SELECT a FROM CitiesEntity a where a.name=:name", CitiesEntity.class);
        query.setParameter("name", name);
        if (query.getResultList().isEmpty())
            return null;
        return query.getSingleResult();
    }

    public static CitiesEntity create(CitiesEntity city) {
        CitiesEntity existingCity = findByName(city.getName());
        if (existingCity == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(city);
            entityManager.getTransaction().commit();
        }
        return city;
    }
}
