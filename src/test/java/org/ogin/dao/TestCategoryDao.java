package org.ogin.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ogin.config.ApplicationContext;
import org.ogin.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author ogin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class TestCategoryDao {
    @Autowired
    private CategoryDao categoryDao;

    @Before
    public void init() {

    }
    @Test
    @Transactional
    public void listCategory() {
        List<Category> categoryList = categoryDao.getCategories();
        assertEquals(4, categoryList.size());

        Category category = categoryDao.getCategory(1);
        assertEquals("Tutorials", category.getName());

        List<Category> children = category.getChildren();
        assertEquals(3, children.size());
    }
}
