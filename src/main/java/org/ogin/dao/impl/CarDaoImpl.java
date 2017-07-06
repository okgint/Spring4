package org.ogin.dao.impl;

import org.ogin.dao.CarDao;
import org.ogin.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ogin
 */
@Repository("carDao")
public class CarDaoImpl implements CarDao {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Car> getCars() throws DataAccessException {
        Query query = getEntityManager().createQuery("select c from Car c");
        List<Car> resultList = query.getResultList();
        return resultList;
    }

    @Transactional
    public Car getCar(Long caId) {
        return getEntityManager().find(Car.class, caId);
    }
    @Transactional
    public void persist(Car car) {
        getEntityManager().persist(car);
    }
}
