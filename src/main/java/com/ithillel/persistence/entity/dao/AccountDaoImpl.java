package com.ithillel.persistence.entity.dao;

import com.ithillel.persistence.entity.AccountEntity;
import com.ithillel.persistence.entity.dao.intefaces.AccountDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public AccountEntity get(Integer id) {
        AccountEntity accountEntity = entityManager.find(AccountEntity.class, id);
        accountEntity.getClients().size();
        return accountEntity;
    }

    @Override
    public Integer create(AccountEntity accountEntity) {
        entityManager.persist(accountEntity);
        return accountEntity.getId();
    }

    @Override
    public AccountEntity delete(Integer integer) {
        return null;
    }

    @Override
    public AccountEntity update(AccountEntity accountEntity) {
        return null;
    }

}
