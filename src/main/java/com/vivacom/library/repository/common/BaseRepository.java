package com.vivacom.library.repository.common;

import com.vivacom.library.model.entity.BookDetails;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseRepository {

    @PersistenceContext
    protected EntityManager em;

    protected Session getCurrentSession() {
        return em.unwrap(Session.class);
    }

    protected org.hibernate.Query hibernateQuery(String query, Class dtoClazz) {
        return getCurrentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(dtoClazz));
    }

}
