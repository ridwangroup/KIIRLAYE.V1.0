package sn.ridwan.ipm.service;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerService {
    private static EntityManagerService instance;
    private EntityManagerFactory entityManagerFactory;

    public EntityManagerService() {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("Ridwanipm");
    }

    public static synchronized EntityManagerService getInstance() {
        return instance == null ? instance = new EntityManagerService() : instance ;
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public void fermer(){
        if (entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }
}
