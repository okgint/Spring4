package org.ogin.dao;

import org.ogin.domain.Manufacturer;
import org.ogin.domain.Model;

import java.util.List;

/**
 * @author ogin
 */
public interface ModelDao {
    public void persist(String name, Manufacturer manufacturer);
    List<Model> getModel();
}
