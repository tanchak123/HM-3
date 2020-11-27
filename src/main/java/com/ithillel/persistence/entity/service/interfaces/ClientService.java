package com.ithillel.persistence.entity.service.interfaces;

import com.ithillel.persistence.entity.ClientEntity;
import com.ithillel.persistence.entity.service.generic.GenericService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

public interface ClientService extends GenericService<ClientEntity, Integer> {

    boolean changePasswordById(Integer id, String newPassword);
}
