package App;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Manager {
    private static Manager manager = null;
    public EntityManagerFactory entityManagerFactory;
    private Manager(String name) {entityManagerFactory = Persistence.createEntityManagerFactory(name);}

    private Manager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public static Manager getInstance() {
        if (manager == null) {
            manager = new Manager();
        }
        return manager;
    }
}



