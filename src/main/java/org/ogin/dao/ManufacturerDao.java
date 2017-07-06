package org.ogin.dao;

import org.ogin.domain.Manufacturer;

import java.util.List;

/**
 * @author ogin
 */
public interface ManufacturerDao {
    List<Manufacturer> getManufacturers();

    Manufacturer getManufacturer(int id);

    void persist(Manufacturer manufacturer);
}
