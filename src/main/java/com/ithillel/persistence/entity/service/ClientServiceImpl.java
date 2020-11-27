package com.ithillel.persistence.entity.service;

import com.ithillel.persistence.entity.ClientEntity;
import com.ithillel.persistence.entity.dao.intefaces.ClientDao;
import com.ithillel.persistence.entity.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao clientDao;

    @Transactional
    @Override
    public ClientEntity getById(Integer id) {
        return clientDao.get(id);
    }

    @Transactional
    @Override
    public Integer create(ClientEntity clientEntity) {
        return clientDao.create(clientEntity);
    }

    @Override
    public ClientEntity removeById(Integer integer) {
        return null;
    }

    @Override
    @Transactional
    public ClientEntity update(ClientEntity client) {
        return clientDao.update(client);
    }

    @Override
    @Transactional
    public boolean changePasswordById(Integer id, String newPassword) {
        Assert.notNull(id, "entity is null");
        Assert.notNull(newPassword, "password can't be null");
        getById(id).setPassword(newPassword);
        return true;
    }
}
