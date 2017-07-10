package org.ogin.dao.impl;

import org.ogin.dao.CategoryDao;
import org.ogin.domain.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ogin
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public List<Category> getCategories() {
        Query query = getEntityManager().createQuery("SELECT c FROM Category c");
        List<Category> results = query.getResultList();
        return results;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public Category getCategory(int id) {
        return getEntityManager().find(Category.class, id);
    }

    @Transactional
    public void persist(Category category) {
        getEntityManager().persist(category);
    }
}
