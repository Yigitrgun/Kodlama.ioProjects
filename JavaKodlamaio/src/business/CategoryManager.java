package business;

import Core.Logging.Logger;
import dataAccess.Category.CategoryDao;
import dataAccess.Category.HibernateCategoryDao;
import entitites.Category;

import java.util.List;
import java.util.Objects;

public class CategoryManager {
    private CategoryDao categoryDao;
    private Logger[] loggers;
    private Category[] categories;

    public CategoryManager() {
    }

    public CategoryManager(HibernateCategoryDao categoryDao, Logger[] loggers, List<Category> categories) {
    }

    public CategoryManager(CategoryDao categoryDao, Logger[] loggers, Category[] categories) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
        this.categories = categories;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Logger[] getLoggers() {
        return loggers;
    }

    public void setLoggers(Logger[] loggers) {
        this.loggers = loggers;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) throws Exception {

        for (Category category1 : categories) {
            if (category1 != category) {
                if (Objects.equals(category1.getName(), category1.getName())) {
                    throw new Exception("Kategori ismi tekrar edemez.");
                }
            }
            for (Logger logger : loggers) {
                logger.log(category.getName());
            }
        }
    }
}
