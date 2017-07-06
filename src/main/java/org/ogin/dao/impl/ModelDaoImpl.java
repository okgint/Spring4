package org.ogin.dao.impl;

import org.ogin.dao.ModelDao;
import org.ogin.domain.Manufacturer;
import org.ogin.domain.Model;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author ogin
 */
@Repository("modelDao")
public class ModelDaoImpl implements ModelDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public void persist(String name, Manufacturer manufacturer){
        Model model = new Model(name, manufacturer);
        getEntityManager().persist(model);
    }
    @Transactional
    public List<Model> getModel() {
        // Search for All Model objects
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Model> criteriaQuery = criteriaBuilder.createQuery(Model.class);
        Root<Model> from = criteriaQuery.from(Model.class);
        criteriaQuery.select(from);
        TypedQuery<Model> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Model> resultList = typedQuery.getResultList();
        return resultList;
    }
}
