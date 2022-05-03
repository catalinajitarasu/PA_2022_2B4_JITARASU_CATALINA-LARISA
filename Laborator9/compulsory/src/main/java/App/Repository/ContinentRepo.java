package App.Repository;
import App.Entities.ContinentsEntity;
import App.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ContinentRepo {
    private static EntityManager entityManager = Manager.getInstance().entityManagerFactory.createEntityManager();
    public static ContinentsEntity findById(int id) {
        return entityManager.find(ContinentsEntity.class, id);
    }

    public static ContinentsEntity findByName(String name) {
        TypedQuery<ContinentsEntity> query = entityManager.createQuery("SELECT a FROM ContinentsEntity a where a.name=:name", ContinentsEntity.class);
        query.setParameter("name", name);
        if (query.getResultList().isEmpty())
            return null;
        return query.getSingleResult();

    }

    public static ContinentsEntity create(ContinentsEntity continent) {
        ContinentsEntity existingContinent = findByName(continent.getName());
        if (existingContinent == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(continent);
            entityManager.getTransaction().commit();
        }
        return continent;
    }
}
