package it.ispw.efco.nottitranquille.model.dao;

import it.ispw.efco.nottitranquille.model.JPAInitializer;
import it.ispw.efco.nottitranquille.model.Manager;
import it.ispw.efco.nottitranquille.model.Tenant;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.List;

/**
 * @author Claudio Pastorini Omar Shalby Federico Vagnoni Emanuele Vannacci
 */
public class ManagerDAO {

    /**
     * Stores {@link Manager} into persistent system.
     *
     * @param manager the Tenant to persist
     */
    public static void store(Manager manager) {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(manager);

        entityManager.getTransaction().commit();
    }

    /**
     * Updates {@link Manager} into persistent system
     *
     * @param toUpdate the Tenant to update with the new state
     */
    public static void update(Manager toUpdate) {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        entityManager.getTransaction().begin();

        Manager managerLoaded = entityManager.find(Manager.class, toUpdate.getId());
        managerLoaded.update(toUpdate);

        entityManager.getTransaction().commit();
    }

    /**
     * Deletes {@link Manager } from persistent system.
     *
     * @param toDelete the Manager to remove
     */
    public static void delete(Manager toDelete) {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        entityManager.getTransaction().begin();

        Manager managerLoaded = entityManager.find(Manager.class, toDelete.getId());
        entityManager.remove(managerLoaded);

        entityManager.getTransaction().commit();
    }

    public static List<Manager> findAllTenant() {
        EntityManager entityManager = JPAInitializer.getEntityManager();
        return entityManager.createQuery("from Manager ", Manager.class)
                .getResultList();
    }

/*
    @SuppressWarnings("JpaQlInspection")
    public static Manager findByName(String firstname, String surname){
        EntityManager entityManager = JPAInitializer.getEntityManager();
        return entityManager.createQuery("from Tenant where (firstName = firstname)" +
                "and (lastName = surname) ", Manager.class)
                .getSingleResult();
    }*/

    @SuppressWarnings("JpaQlInspection")
    public static Manager findByNameAndPassword(String username, String passWord)
            throws NoResultException{

            EntityManager entityManager = JPAInitializer.getEntityManager();
            return entityManager.createQuery("from Tenant where " +
                    " (userName = username) and (password = passWord) ", Manager.class)
                    .getSingleResult();

    }


}

