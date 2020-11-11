package com.ithillel.persistence.entity.service;

import com.ithillel.persistence.entity.ClientEntity;
import com.ithillel.persistence.entity.dao.intefaces.ClientDao;
import com.ithillel.persistence.entity.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    public ClientEntity updateById(Integer integer) {
        return null;
    }
}
