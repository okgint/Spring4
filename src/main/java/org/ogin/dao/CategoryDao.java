package org.ogin.dao;

import org.ogin.domain.Category;

import java.util.List;

/**
 * @author ogin
 */
public interface CategoryDao {
    public List<Category> getCategories();

    public Category getCategory(int id);

    public void persist(Category category);
}
