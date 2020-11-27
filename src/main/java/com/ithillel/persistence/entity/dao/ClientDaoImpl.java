package com.ithillel.persistence.entity.dao;

import com.ithillel.persistence.entity.ClientEntity;
import com.ithillel.persistence.entity.dao.intefaces.ClientDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class ClientDaoImpl implements ClientDao {

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;


    @Override
    public ClientEntity get(Integer id) {
        return entityManager.find(ClientEntity.class, id);
    }

    @Override
    public Integer create(ClientEntity clientEntity) {
        entityManager.persist(clientEntity);
        return clientEntity.getId();
    }

    @Override
    public ClientEntity delete(Integer integer) {
        return null;
    }

    @Override
    public ClientEntity update(ClientEntity client) {
        return entityManager.merge(client);
    }
}
