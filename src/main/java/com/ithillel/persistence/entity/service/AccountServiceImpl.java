package com.ithillel.persistence.entity.service;

import com.ithillel.persistence.entity.AccountEntity;
import com.ithillel.persistence.entity.dao.intefaces.AccountDao;
import com.ithillel.persistence.entity.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public Integer create(final AccountEntity accountEntity) {
       return accountDao.create(accountEntity);
    }

    @Override
    public AccountEntity removeById(Integer integer) {
        return null;
    }

    @Override
    public AccountEntity updateById(Integer integer) {
        return null;
    }

    @Override
    @Transactional
    public AccountEntity getById(Integer id) {
        AccountEntity accountEntity = accountDao.get(id);
        accountEntity.getClients().size();
        return accountEntity;
    }
}
