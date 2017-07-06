package org.ogin.dao;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ogin.config.ApplicationContext;
import org.ogin.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author ogin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
//@ContextConfiguration(locations = {"classpath:appconfig-root.xml"})
@WebAppConfiguration
public class CarTest {
    @Autowired
    private CarDao carDao;
    private Long id;

    @Before
    public void init() {
        id = 1L;
    }
    @Test
    public void listCars() {

    }

    @Test
    public void carTest() {

    }
}
