package org.ogin.dao;

import org.ogin.domain.Car;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @author ogin
 */
public interface CarDao {
    public List<Car> getCars() throws DataAccessException;

    public Car getCar(Long caId);

    public void persist(Car car);
}
