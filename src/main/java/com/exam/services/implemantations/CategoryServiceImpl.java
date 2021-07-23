package com.exam.services.implemantations;

import com.exam.dao.CategoryDao;
import com.exam.entities.exam.Category;
import com.exam.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category addCategory(Category category) {
        return this.categoryDao.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryDao.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryDao.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryDao.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {

        Category category = new Category();
        category.setCid(categoryId);
        this.categoryDao.delete(category);

    }
}
