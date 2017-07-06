package org.ogin.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ogin.config.ApplicationContext;
import org.ogin.domain.Manufacturer;
import org.ogin.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author ogin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class TestModelDao {
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private ManufacturerDao manufacturerDao;

    @Test
    public void ListModel() {
        List<Model> models = modelDao.getModel();
        assertNotNull(models);
        assertEquals(3, models.size());
    }

    @Test
    public void testManu() {
        int ford1 = 1;
        Manufacturer ford = manufacturerDao.getManufacturer(1);
        assertEquals("Ford", ford.getName());
    }

    @Test
    public void insertModelWithManufacturer() {
        int ford1 = 1;
        Manufacturer ford = manufacturerDao.getManufacturer(1);
        modelDao.persist("test", ford);
        assertEquals(4, modelDao.getModel().size());
    }
}
