package org.ogin.dao.impl;

import org.ogin.dao.ManufacturerDao;
import org.ogin.domain.Manufacturer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ogin
 */
@Repository("manufacturerDao")
public class ManufacturerDaoImpl implements ManufacturerDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Transactional
    public List<Manufacturer> getManufacturers() {
        Query query = getEntityManager().createQuery("SELECT m from Manufacturer m");
        return query.getResultList();

    }
    @Transactional
    public Manufacturer getManufacturer(int id) {
        return getEntityManager().find(Manufacturer.class, id);
    }

    @Transactional
    public void persist(Manufacturer manufacturer) {
        getEntityManager().persist(manufacturer);
    }
}
