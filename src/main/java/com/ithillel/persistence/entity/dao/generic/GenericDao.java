package com.ithillel.persistence.entity.dao.generic;

public interface GenericDao<M, L> {

    M get(L id);

    L create(M m);

    M delete(L l);

    M update(L l);

}
