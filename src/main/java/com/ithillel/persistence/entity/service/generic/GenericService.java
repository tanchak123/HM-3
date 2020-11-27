package com.ithillel.persistence.entity.service.generic;

public interface GenericService<M, L> {

    M getById(L id);

    L create(M m);

    M removeById(L l);

    M update(M m);
}
