package at.aberger.tutorial.jee.database;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    @Produces
    @PersistenceContext(unitName = "mydb")
    @Database
    static private EntityManager entityManager;

}