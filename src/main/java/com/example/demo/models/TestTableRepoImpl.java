package com.example.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;

/*
  TODO: Refactor1
    1.  Check the structure of project.
    2.  Bad naming.
 */
@Component
public class TestTableRepoImpl {
    /*
      TODO: Refactor2
      1. Bad naming.
     */
    @Autowired
    private EntityManagerFactory emf;

    @Transactional
    public int createWithoutExist() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery(
                    "CREATE TABLE IF NOT EXISTS test_table ( id bigint(20) NOT NULL, message varchar(255), status varchar(255), PRIMARY KEY (id))")
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
        return 1;
    }
}
